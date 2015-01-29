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

import org.sidney.core.Accessors;
import org.sidney.core.TypeRef;
import org.sidney.core.serde.ReadContext;
import org.sidney.core.serde.TypeReader;
import org.sidney.core.serde.TypeWriter;
import org.sidney.core.serde.WriteContext;

/**
 * Handles serializing a given type, is responsible for decomposing that type and constructing sub serializers if necessary
 */
public abstract class Serializer<T> {
    private int numFieldsToIncrementBy = 1;
    private Accessors.FieldAccessor accessor;

    public Serializer() {

    }

    /**
     * Indicates the number of fields to increment by if this value is null, includes all subfields + 1
     */
    public int getNumFieldsToIncrementBy() {
        return numFieldsToIncrementBy;
    }

    public abstract void consume(TypeRef typeRef, SerializerContext builder);

    /**
     * Fully consume {@param value}
     * The {@link org.sidney.core.serde.WriteContext#getColumnIndex()} on {@param context} must be incremented to the number of fields + subfields + 1 after the value is consumed
     * For example, if {@param value} is a bean with two int fields, it must be incremented by 4, one for the bean, two for the ints,
     * and one more to advance into the next field
     */
    public abstract void writeValue(Object value, TypeWriter typeWriter, WriteContext context);

    /**
     * Fully consume a field value from the parent, parent is guaranteed to be non-null
     * Follow the same incrementing rules as {@link #writeValue}
     */
    public void writeFromField(Object parent, TypeWriter typeWriter, WriteContext context) {
        writeValue(getAccessor().get(parent), typeWriter, context);
    }

    /**
     * Materialize a value from sub columns, columns must be incremented and read in the same order as they were written
     * in either {@link #writeValue} or {@link #writeFromField}
     *
     * @return a fully materialized value
     */
    public abstract Object readValue(TypeReader typeReader, ReadContext context);

    /**
     * Materialize a value from sub columns, columns must be incremented and read in the same order as they were written
     * in either {@link #writeValue} or {@link #writeFromField} and the materialized value must be written into the field of the parent
     */
    public void readIntoField(Object parent, TypeReader typeReader, ReadContext context) {
        getAccessor().set(parent, readValue(typeReader, context));
    }

    /**
     * Denotes whether or not the value requires serializing the type e.g {@link java.util.Map} so that a reader knows what constructor to use
     *
     * @return whether or not a type column is required
     */
    public abstract boolean requiresTypeColumn();

    void addNumFieldsToIncrementBy(int num) {
        numFieldsToIncrementBy += num;
    }

    /**
     * Get the accessor for this field, if present, otherwise null
     *
     * @return the accessor
     */
    protected final Accessors.FieldAccessor getAccessor() {
        return accessor;
    }

    public void setAccessor(Accessors.FieldAccessor accessor) {
        this.accessor = accessor;
    }
}