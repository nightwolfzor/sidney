/**
 * Copyright 2014 Jason Ruckman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sidney.core.serde.serializer;

import org.sidney.core.TypeRef;
import org.sidney.core.serde.*;

import java.util.Map;

public class MapSerializer extends Serializer<Map> {
    private Serializer keySerializer;
    private Serializer valueSerializer;
    private InstanceFactoryCache cache = new InstanceFactoryCache();

    @Override
    public void consume(TypeRef typeRef, SerializerContext builder) {
        keySerializer = builder.serializer(typeRef.getTypeParameters().get(0), this);
        valueSerializer = builder.serializer(typeRef.getTypeParameters().get(1), this);

        addNumFieldsToIncrementBy(keySerializer.getNumFieldsToIncrementBy());
        addNumFieldsToIncrementBy(valueSerializer.getNumFieldsToIncrementBy());
    }

    @Override
    public void writeValue(Object value, TypeWriter typeWriter, WriteContext context) {
        writeMap((Map) value, typeWriter, context);
    }

    @Override
    public Object readValue(TypeReader typeReader, ReadContext context) {
        return readMap(typeReader, context);
    }

    @Override
    public boolean requiresTypeColumn() {
        return true;
    }

    private void writeMap(Map map, TypeWriter typeWriter, WriteContext context) {
        if (typeWriter.writeNullMarkerAndType(map, context)) {
            context.getColumnWriter().writeRepetitionCount(context.getColumnIndex(), map.size());
            //bump index forward to key
            context.incrementColumnIndex();
            int valueIndex = context.getColumnIndex();
            for (Object e : map.entrySet()) {
                context.setColumnIndex(valueIndex); //for each entry, make sure we are starting at the root
                Map.Entry entry = (Map.Entry) e;
                keySerializer.writeValue(entry.getKey(), typeWriter, context);
                valueSerializer.writeValue(entry.getValue(), typeWriter, context);
            }
        } else {
            context.incrementColumnIndex(getNumFieldsToIncrementBy() + 1);
        }
    }

    private Map readMap(TypeReader typeReader, ReadContext context) {
        if (typeReader.readNullMarker(context)) {
            Map map = (Map) cache.newInstance(typeReader.readConcreteType(context));
            int size = typeReader.readRepetitionCount(context);
            context.incrementColumnIndex();
            int idx = context.getColumnIndex();
            for (int i = 0; i < size; i++) {
                context.setColumnIndex(idx);
                map.put(keySerializer.readValue(typeReader, context), valueSerializer.readValue(typeReader, context));
            }
            return map;
        }
        context.incrementColumnIndex(getNumFieldsToIncrementBy() + 1);
        return null;
    }
}