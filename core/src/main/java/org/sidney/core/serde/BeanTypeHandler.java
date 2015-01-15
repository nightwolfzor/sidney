package org.sidney.core.serde;

import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import org.sidney.core.field.FieldUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

public class BeanTypeHandler extends GenericTypeHandler<SimpleType> {
    private Class<?> rawClass;
    private List<TypeHandler> fieldHandlers = new ArrayList<>();
    private InstanceFactory instanceFactory;

    public BeanTypeHandler(Type jdkType,
                           Field field,
                           TypeBindings parentBindings,
                           TypeHandlerFactory typeHandlerFactory, Class... generics) {
        super(jdkType, field, parentBindings, typeHandlerFactory, generics);

        List<Field> fields = FieldUtils.getAllFields(rawClass);
        for (int i = 0; i < fields.size(); i++) {
            Field subField = fields.get(i);
            Type type = subField.getGenericType();
            TypeHandler typeHandler = getTypeHandlerFactory().handler(
                    (type == null) ? subField.getType() : type, subField, getTypeBindings()
            );

            handlers.add(typeHandler);
            handlers.addAll(typeHandler.getHandlers());

            fieldHandlers.add(typeHandler);
            numSubFields += typeHandler.numSubFields;
        }
        instanceFactory = new InstanceFactory(rawClass);
    }

    @Override
    public void writeValue(Object value, TypeWriter typeWriter, WriteContext context) {
        writeBean(value, typeWriter, context);
    }

    @Override
    public void writeFromField(Object parent, TypeWriter typeWriter, WriteContext context) {
        writeBean(getAccessor().get(parent), typeWriter, context);
    }

    @Override
    public Object readValue(TypeReader typeReader, ReadContext context) {
        return readBean(typeReader, context);
    }

    @Override
    public void readIntoField(Object parent, TypeReader typeReader, ReadContext context) {
        getAccessor().set(parent, readBean(typeReader, context));
    }

    @Override
    public boolean requiresTypeColumn() {
        return false;
    }

    @Override
    public String name() {
        return String.format("%s", rawClass.toString());
    }

    @Override
    protected void fromType(Type type) {
        rawClass = (Class) type;
    }

    @Override
    protected void fromParameterizedClass(Class<?> clazz, Class... types) {
        rawClass = TypeUtil.parameterizedType(clazz, types).getRawClass();
    }

    @Override
    protected void fromParameterizedType(ParameterizedType type) {
        rawClass = TypeUtil.type(type, getParentTypeBindings()).getRawClass();
    }

    @Override
    protected void fromTypeVariable(TypeVariable typeVariable) {
        rawClass = TypeUtil.type(typeVariable, getParentTypeBindings()).getRawClass();
    }

    private void writeBean(Object value, TypeWriter typeWriter, WriteContext context) {
        if (typeWriter.writeNullMarker(value, context)) {
            //advance into fields
            context.incrementColumnIndex();
            for (TypeHandler handler : fieldHandlers) {
                handler.writeFromField(value, typeWriter, context);
            }
        } else {
            context.incrementColumnIndex(numSubFields);
        }
    }

    private Object readBean(TypeReader typeReader, ReadContext context) {
        if (typeReader.readNullMarker(context)) {
            Object bean = instanceFactory.newInstance();
            context.incrementColumnIndex();
            for (TypeHandler handler : fieldHandlers) {
                handler.readIntoField(bean, typeReader, context);
            }
            return bean;
        } else {
            context.incrementColumnIndex(numSubFields);
        }
        return null;
    }
}