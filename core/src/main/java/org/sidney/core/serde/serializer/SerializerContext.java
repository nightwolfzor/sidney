package org.sidney.core.serde.serializer;

import org.sidney.core.Accessors;
import org.sidney.core.Registrations;
import org.sidney.core.SidneyException;
import org.sidney.core.TypeRef;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SerializerContext {
    private final List<SerializerEntry> entries = new ArrayList<>();
    private Registrations registrations;
    private final List<Serializer> serializers = new ArrayList<>();

    public SerializerContext(Registrations registrations) {
        this.registrations = registrations;

        addCustomFactories();
        addPrimitiveFactories();
        addArrayFactories();

        addEntry(Collection.class, CollectionSerializer.class);
        addEntry(Map.class, MapSerializer.class);
        addEntry(Object.class, BeanSerializer.class);

    }

    private void addCustomFactories() {
        entries.addAll(registrations.getRegistrations());
    }

    private void addPrimitiveFactories() {
        Class<PrimitiveSerializer> primitiveSerializerClass = PrimitiveSerializer.class;
        Class<PrimitiveSerializer.NonNullPrimitiveSerializer> nonNullPrimitiveSerializerClass = PrimitiveSerializer.NonNullPrimitiveSerializer.class;

        addEntry(boolean.class, nonNullPrimitiveSerializerClass);
        addEntry(Boolean.class, primitiveSerializerClass);
        addEntry(byte.class, nonNullPrimitiveSerializerClass);
        addEntry(Byte.class, primitiveSerializerClass);
        addEntry(char.class, nonNullPrimitiveSerializerClass);
        addEntry(Character.class, primitiveSerializerClass);
        addEntry(short.class, nonNullPrimitiveSerializerClass);
        addEntry(Short.class, primitiveSerializerClass);
        addEntry(int.class, nonNullPrimitiveSerializerClass);
        addEntry(Integer.class, primitiveSerializerClass);
        addEntry(long.class, nonNullPrimitiveSerializerClass);
        addEntry(Long.class, primitiveSerializerClass);
        addEntry(float.class, nonNullPrimitiveSerializerClass);
        addEntry(Float.class, primitiveSerializerClass);
        addEntry(double.class, nonNullPrimitiveSerializerClass);
        addEntry(Double.class, primitiveSerializerClass);
        addEntry(Enum.class, primitiveSerializerClass);
        addEntry(String.class, primitiveSerializerClass);
        addEntry(byte[].class, primitiveSerializerClass);
    }

    private void addArrayFactories() {
        Class<ArraySerializer> arraySerializerClass = ArraySerializer.class;

        addEntry(boolean[].class, arraySerializerClass);
        addEntry(char[].class, arraySerializerClass);
        addEntry(short[].class, arraySerializerClass);
        addEntry(int[].class, arraySerializerClass);
        addEntry(long[].class, arraySerializerClass);
        addEntry(float[].class, arraySerializerClass);
        addEntry(double[].class, arraySerializerClass);
        addEntry(Object[].class, arraySerializerClass);
    }

    public <T> Serializer<T> serializer(TypeRef typeRef) {
        return serializer(typeRef, null);
    }

    public <T> Serializer<T> serializer(TypeRef typeRef, Serializer parent) {
        Class<T> clazz = (Class<T>) typeRef.getType();
        Serializer<T> serializer = null;
        for (SerializerEntry entry : entries) {
            if (entry.getType() == clazz || entry.getType().isAssignableFrom(clazz)) {
                serializer = (Serializer) new InstanceFactory(entry.getSerializerType()).newInstance();
                break;
            }
        }
        if (serializer == null) {
            throw new SidneyException(String.format("Could not resolve serializer for type: %s", clazz));
        }
        serializers.add(serializer);
        if (typeRef instanceof TypeRef.TypeFieldRef) {
            serializer.setAccessor(Accessors.newAccessor(
                    ((TypeRef.TypeFieldRef) typeRef).getJdkField()
            ));
        }
        serializer.consume(typeRef, this);

        if (parent != null) {
            parent.addNumFieldsToIncrementBy(serializer.getNumFieldsToIncrementBy());
        }

        return serializer;
    }

    public void finish(TypeConsumer consumer) {
        for (Serializer serializer : serializers) {
            consumer.consume(serializer);
        }
    }

    private void addEntry(Class type, Class<? extends Serializer> serializerType) {
        entries.add(new SerializerEntry(type, serializerType));
    }
}