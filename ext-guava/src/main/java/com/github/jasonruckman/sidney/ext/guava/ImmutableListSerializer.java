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
package com.github.jasonruckman.sidney.ext.guava;

import com.github.jasonruckman.sidney.core.type.TypeRef;
import com.github.jasonruckman.sidney.core.serde.Contexts;
import com.github.jasonruckman.sidney.core.serde.serializer.Serializer;
import com.github.jasonruckman.sidney.core.serde.serializer.SerializerContext;
import com.google.common.collect.ImmutableList;

public class ImmutableListSerializer<T> extends Serializer<ImmutableList<T>> {
  private Serializer<T> contentSerializer;

  @Override
  public void initialize(TypeRef typeRef, SerializerContext context) {
    contentSerializer = context.serializer(typeRef.getTypeParameters().get(0));
  }

  @Override
  public void writeValue(ImmutableList<T> value, Contexts.WriteContext context) {
    context.getMeta().writeRepetitionCount(value.size());
    for (T o : value) {
      contentSerializer.writeValue(o, context);
    }
  }

  @Override
  public ImmutableList<T> readValue(Contexts.ReadContext context) {
    int size = context.getMeta().readRepetitionCount();
    ImmutableList.Builder<T> builder = ImmutableList.builder();
    for (int i = 0; i < size; i++) {
      builder.add(contentSerializer.readValue(context));
    }
    return builder.build();
  }
}