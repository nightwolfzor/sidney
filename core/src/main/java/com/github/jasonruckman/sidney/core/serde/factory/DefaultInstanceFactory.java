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
package com.github.jasonruckman.sidney.core.serde.factory;

import com.esotericsoftware.reflectasm.ConstructorAccess;

public class DefaultInstanceFactory<T> implements InstanceFactory<T> {
  private ConstructorAccess<T> access;

  public DefaultInstanceFactory(Class<T> type) {
    access = ConstructorAccess.get(type);
  }

  /**
   * Create a new instance of the given type using the default constructor
   */
  @Override
  public T newInstance() {
    try {
      return access.newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}