package org.sidney.core.serde;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeBindings;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

public class MapTypeHandler<T extends Map> extends GenericTypeHandler<MapType> {
    private TypeHandler keyTypeHandler;
    private TypeHandler valueTypeHandler;
    private Class rawClass;
    private InstanceFactoryCache cache = new InstanceFactoryCache();

    public MapTypeHandler(Type jdkType,
                          Field field,
                          TypeBindings parentTypeBindings,
                          TypeHandlerFactory typeHandlerFactory, Class... generics) {
        super(jdkType, field, parentTypeBindings, typeHandlerFactory, generics);

        handlers.add(keyTypeHandler);
        handlers.addAll(keyTypeHandler.getHandlers());
        handlers.add(valueTypeHandler);
        handlers.addAll(valueTypeHandler.getHandlers());
    }

    @Override
    protected void fromParameterizedClass(Class<?> clazz, Class... types) {
        rawClass = clazz;
        keyTypeHandler = getTypeHandlerFactory().handler(types[0], null, getTypeBindings());
        valueTypeHandler = getTypeHandlerFactory().handler(types[1], null, getTypeBindings());
    }

    @Override
    protected void fromParameterizedType(ParameterizedType type) {
        rawClass = type.getRawType().getClass();
        Type[] args = ((ParameterizedType) getJdkType()).getActualTypeArguments();
        keyTypeHandler = getTypeHandlerFactory().handler(args[0], null, getParentTypeBindings());
        valueTypeHandler = getTypeHandlerFactory().handler(args[1], null, getParentTypeBindings());
    }

    @Override
    protected void fromTypeVariable(TypeVariable typeVariable) {
        keyTypeHandler = getTypeHandlerFactory().handler(
                typeVariable.getBounds()[0], null, getParentTypeBindings());
        valueTypeHandler = getTypeHandlerFactory().handler(
                typeVariable.getBounds()[1], null, getParentTypeBindings());
    }

    @Override
    public void writeValue(Object value, TypeWriter typeWriter, WriteContext context) {
        writeMap((Map) value, typeWriter, context);
    }

    @Override
    public void writeFromField(Object parent, TypeWriter typeWriter, WriteContext context) {
        Map map = (Map) getAccessor().get(parent);
        writeMap(map, typeWriter, context);
    }

    @Override
    public Object readValue(TypeReader typeReader, ReadContext context) {
        return readMap(typeReader, context);
    }

    @Override
    public void readIntoField(Object parent, TypeReader typeReader, ReadContext context) {
        getAccessor().set(parent, readMap(typeReader, context));
    }

    private Object readMap(TypeReader typeReader, ReadContext context) {
        if(typeReader.readNullMarker(context)) {
            Map map = (Map)cache.newInstance(typeReader.readConcreteType(context));
            int size = typeReader.readRepetitionCount(context);
            context.incrementIndex();
            int idx = context.getIndex();
            for(int i = 0; i < size; i++) {
                context.setIndex(idx);
                Object key = keyTypeHandler.readValue(typeReader, context);
                Object value = valueTypeHandler.readValue(typeReader, context);
                map.put(key, value);
            }
            return map;
        }
        return null;
    }

    @Override
    public boolean requiresTypeColumn() {
        return true;
    }

    @Override
    public String name() {
        return String.format("%s", rawClass.toString());
    }

    private void writeMap(Map map, TypeWriter typeWriter, WriteContext context) {
        if (typeWriter.writeNullMarkerAndType(map, context)) {
            context.getColumnWriter().writeRepetitionCount(context.getIndex(), map.size());
            //bump index forward to key
            context.incrementIndex();
            int valueIndex = context.getIndex();
            for (Object e : map.entrySet()) {
                context.setIndex(valueIndex); //for each entry, make sure we are starting at the root
                Map.Entry entry = (Map.Entry) e;
                keyTypeHandler.writeValue(entry.getKey(), typeWriter, context);
                valueTypeHandler.writeValue(entry.getValue(), typeWriter, context);
            }
        }
    }
}