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
package com.github.jasonruckman.sidney.core.serde;

import com.github.jasonruckman.sidney.core.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.github.jasonruckman.sidney.core.TestUtils.maybeMakeNull;

public class DataFactory {
  private final Random random = new Random(11L);

  public Random getRandom() {
    return random;
  }

  public boolean newBool() {
    return random.nextBoolean();
  }

  public boolean[] newBools() {
    boolean[] booleans = new boolean[random.nextInt(128)];
    for (int i = 0; i < booleans.length; i++) {
      booleans[i] = newBool();
    }
    return booleans;
  }

  public Boolean[] newBoolRefs() {
    Boolean[] booleans = new Boolean[random.nextInt(128)];
    for (int i = 0; i < booleans.length; i++) {
      booleans[i] = maybeMakeNull(newBool());
    }
    return booleans;
  }

  public byte newByte() {
    return (byte) random.nextInt(255);
  }

  public Byte[] newByteRefs() {
    Byte[] bytes = new Byte[random.nextInt(128)];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = maybeMakeNull(newByte());
    }
    return bytes;
  }

  public short newShort() {
    return (short) random.nextInt(65536);
  }

  public short[] newShorts() {
    short[] shorts = new short[random.nextInt(128)];
    for (int i = 0; i < shorts.length; i++) {
      shorts[i] = newShort();
    }
    return shorts;
  }

  public Short[] newShortRefs() {
    Short[] shorts = new Short[random.nextInt(128)];
    for (int i = 0; i < shorts.length; i++) {
      shorts[i] = maybeMakeNull(newShort());
    }
    return shorts;
  }

  public char newChar() {
    return (char) random.nextInt(65536);
  }

  public char[] newChars() {
    char[] chars = new char[random.nextInt(128)];
    for (int i = 0; i < chars.length; i++) {
      chars[i] = newChar();
    }
    return chars;
  }

  public Character[] newCharRefs() {
    Character[] chars = new Character[random.nextInt(128)];
    for (int i = 0; i < chars.length; i++) {
      chars[i] = maybeMakeNull(newChar());
    }
    return chars;
  }

  public int newInt() {
    return random.nextInt();
  }

  public int[] newInts() {
    int[] ints = new int[random.nextInt(128)];
    for (int i = 0; i < ints.length; i++) {
      ints[i] = newInt();
    }
    return ints;
  }

  public Integer[] newIntRefs() {
    Integer[] ints = new Integer[random.nextInt(128)];
    for (int i = 0; i < ints.length; i++) {
      ints[i] = maybeMakeNull(newInt());
    }
    return ints;
  }

  public long newLong() {
    return random.nextLong();
  }

  public long[] newLongs() {
    long[] longs = new long[random.nextInt(128)];
    for (int i = 0; i < longs.length; i++) {
      longs[i] = newLong();
    }
    return longs;
  }

  public Long[] newLongRefs() {
    Long[] longs = new Long[random.nextInt(128)];
    for (int i = 0; i < longs.length; i++) {
      longs[i] = maybeMakeNull(newLong());
    }
    return longs;
  }

  public float newFloat() {
    return random.nextFloat();
  }

  public float[] newFloats() {
    float[] floats = new float[random.nextInt(128)];
    for (int i = 0; i < floats.length; i++) {
      floats[i] = newFloat();
    }
    return floats;
  }

  public Float[] newFloatRefs() {
    Float[] floats = new Float[random.nextInt(128)];
    for (int i = 0; i < floats.length; i++) {
      floats[i] = maybeMakeNull(newFloat());
    }
    return floats;
  }

  public double newDouble() {
    return random.nextDouble();
  }

  public double[] newDoubles() {
    double[] doubles = new double[random.nextInt(128)];
    for (int i = 0; i < doubles.length; i++) {
      doubles[i] = newDouble();
    }
    return doubles;
  }

  public Double[] newDoubleRefs() {
    Double[] doubles = new Double[random.nextInt(128)];
    for (int i = 0; i < doubles.length; i++) {
      doubles[i] = maybeMakeNull(newDouble());
    }
    return doubles;
  }

  public String newString() {
    int size = random.nextInt(24);
    char[] array = new char[size];
    for (int i = 0; i < size; i++) {
      array[i] = (char) random.nextInt(100);
    }
    return maybeMakeNull(new String(array));
  }

  public byte[] newBytes() {
    int size = random.nextInt(256);
    byte[] bytes = new byte[size];
    random.nextBytes(bytes);
    return maybeMakeNull(bytes);
  }

  public SomeEnum newEnum() {
    return SomeEnum.values()[random.nextInt(2)];
  }

  public AllPrimitives newPrimitives() {
    return maybeMakeNull(new AllPrimitives(
        newBool(), newInt(), newChar(), newShort(), newByte(), newLong(), newFloat(), newDouble(), newBytes(), newString(), newEnum()
    ));
  }

  public AllPrimitiveRefs newPrimitiveRefs() {
    return maybeMakeNull(new AllPrimitiveRefs(
        newBool(), newByte(), newShort(), newChar(), newInt(), newLong(), newFloat(), newDouble()
    ));
  }

  public InheritedAllPrimitives newInheritedAllPrimitives() {
    return maybeMakeNull(new InheritedAllPrimitives(
        newBool(), newInt(), newChar(), newShort(), newByte(), newLong(), newFloat(), newDouble(), newBytes(), newString(), newEnum()
    ));
  }

  public AllPrimitiveArrays newAllArrays() {
    return maybeMakeNull(new AllPrimitiveArrays(
        newBools(), newShorts(), newChars(), newInts(), newLongs(), newFloats(), newDoubles()
    ));
  }

  public AllPrimitiveRefsArrays newAllPrimitiveRefArrays() {
    return maybeMakeNull(new AllPrimitiveRefsArrays(
        newBoolRefs(), newByteRefs(), newShortRefs(), newCharRefs(), newIntRefs(), newLongRefs(), newFloatRefs(), newDoubleRefs()
    ));
  }

  public NestedArray<Integer> newNestedArray() {
    NestedArray<Integer> arr = new NestedArray<>();
    arr.setArray(newIntRefs());
    return maybeMakeNull(arr);
  }

  public NestedMap<Integer, Double> newNestedMap() {
    NestedMap<Integer, Double> map = new NestedMap<>();
    map.setMap(new HashMap<Integer, Double>());
    int[] ints = newInts();
    for (int i = 0; i < ints.length; i++) {
      map.getMap().put(
          i, newDouble()
      );
    }
    return maybeMakeNull(map);
  }

  public GenericsContainer<Integer, Double> newGenericsContainer() {
    return maybeMakeNull(new GenericsContainer<>(
        newNestedArray(), newNestedMap()
    ));
  }

  public Map<AllPrimitiveRefs, AllPrimitiveRefs> newMaps() {
    Map<AllPrimitiveRefs, AllPrimitiveRefs> map = new HashMap<>();
    for (int i = 0; i < newByte(); i++) {
      map.put(
          newPrimitiveRefs(), newPrimitiveRefs()
      );
    }
    return maybeMakeNull(map);
  }

  public SimpleBean newSimpleBean() {
    SimpleBean bean = new SimpleBean();
    bean.setFirst(newInt());
    return bean;
  }
}