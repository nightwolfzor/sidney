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
package com.github.jasonruckman.sidney.core.util;

import sun.misc.Unsafe;

public class UnsafeLongs {
  private static Unsafe unsafe = UnsafeUtil.unsafe();

  public static void copyLongsToBytes(
      long[] sourceArray, long sourcePos, byte[] destinationArray, long destinationPos, long length
  ) {
    unsafe.copyMemory(
        sourceArray, UnsafeUtil.longArrayBaseOffset + sourcePos, destinationArray,
        UnsafeUtil.byteArrayBaseOffset + destinationPos, length
    );
  }

  public static void copyBytesToLongs(
      byte[] sourceArray, long sourcePos, long[] destinationArray, long destinationPos, long length
  ) {
    unsafe.copyMemory(
        sourceArray, UnsafeUtil.byteArrayBaseOffset + sourcePos, destinationArray, UnsafeUtil.longArrayBaseOffset + (destinationPos * 8), length
    );
  }
}