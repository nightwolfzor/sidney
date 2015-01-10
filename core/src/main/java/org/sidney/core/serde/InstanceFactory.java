package org.sidney.core.serde;

import java.lang.reflect.Constructor;

public class InstanceFactory {
    private Constructor constructor;

    public InstanceFactory(Class type) {
        try {
            this.constructor = type.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public Object newInstance() {
        try {
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
