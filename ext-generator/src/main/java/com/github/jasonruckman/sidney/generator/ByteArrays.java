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
package com.github.jasonruckman.sidney.generator;

import java.util.Random;

public class ByteArrays {
  public static interface ByteArrayGenerator {
    byte[] next();
  }

  public static class RandomByteArrayGenerator extends Generator implements ByteArrayGenerator {
    private final Random random = new Random(11L);

    @Override
    public byte[] next() {
      byte[] bytes = new byte[random.nextInt(128)];
      random.nextBytes(bytes);
      return bytes;
    }
  }
}