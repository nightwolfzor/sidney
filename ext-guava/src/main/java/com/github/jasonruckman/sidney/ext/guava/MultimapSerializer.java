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

import com.github.jasonruckman.sidney.core.AbstractSid;
import com.github.jasonruckman.sidney.core.serde.factory.InstanceFactory;
import com.github.jasonruckman.sidney.core.serde.factory.InstanceFactoryCache;
import com.github.jasonruckman.sidney.core.type.TypeRef;
import com.github.jasonruckman.sidney.core.serde.*;
import com.github.jasonruckman.sidney.core.serde.serializer.Serializer;
import com.github.jasonruckman.sidney.core.serde.serializer.SerializerContext;
import com.google.common.collect.*;

import java.util.Collection;
import java.util.Map;

public class MultimapSerializer<K, V> extends Serializer<Multimap<K, V>> {
  private Serializer<K> keySerializer;
  private Serializer<V> valueSerializer;
  private InstanceFactoryCache cache;

  public static void registerMaps(AbstractSid sid) {
    sid.addSerializer(Multimap.class, MultimapSerializer.class);
    sid.addInstanceFactory(ArrayListMultimap.class, new InstanceFactory<ArrayListMultimap>() {
      @Override
      public ArrayListMultimap newInstance() {
        return ArrayListMultimap.create();
      }
    });
    sid.addInstanceFactory(LinkedListMultimap.class, new InstanceFactory<LinkedListMultimap>() {
      @Override
      public LinkedListMultimap newInstance() {
        return LinkedListMultimap.create();
      }
    });
    sid.addInstanceFactory(LinkedHashMultimap.class, new InstanceFactory<LinkedHashMultimap>() {
      @Override
      public LinkedHashMultimap newInstance() {
        return LinkedHashMultimap.create();
      }
    });
    sid.addInstanceFactory(TreeMultimap.class, new InstanceFactory<TreeMultimap>() {
      @Override
      public TreeMultimap newInstance() {
        return TreeMultimap.create();
      }
    });
    sid.addInstanceFactory(HashMultimap.class, new InstanceFactory<HashMultimap>() {
      @Override
      public HashMultimap newInstance() {
        return HashMultimap.create();
      }
    });
  }

  @Override
  public void initialize(TypeRef typeRef, SerializerContext context) {
    keySerializer = context.serializer(typeRef.param(0));
    valueSerializer = context.serializer(typeRef.param(1));
    cache = new InstanceFactoryCache(getFactories());
  }

  @Override
  public void writeValue(Multimap<K, V> value, Contexts.WriteContext context) {
    Map<K, Collection<V>> map = value.asMap();
    context.getMeta().writeConcreteType(value.getClass());
    context.getMeta().writeRepetitionCount(map.size());
    for (Map.Entry<K, Collection<V>> entry : map.entrySet()) {
      keySerializer.writeValue(entry.getKey(), context);
      context.getMeta().writeRepetitionCount(entry.getValue().size());
      for (V v : entry.getValue()) {
        valueSerializer.writeValue(v, context);
      }
    }
  }

  @Override
  public Multimap<K, V> readValue(Contexts.ReadContext context) {
    Multimap<K, V> multimap = (Multimap<K, V>) cache.newInstance(context.getMeta().readConcreteType());
    int num = context.getMeta().readRepetitionCount();
    for (int i = 0; i < num; i++) {
      K key = keySerializer.readValue(context);
      int size = context.getMeta().readRepetitionCount();
      for (int j = 0; j < size; j++) {
        multimap.put(key, valueSerializer.readValue(context));
      }
    }
    return multimap;
  }

  @Override
  public boolean requiresTypeColumn() {
    return true;
  }
}