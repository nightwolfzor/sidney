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
package com.github.jasonruckman.sidney.core.io.float32;

import com.github.jasonruckman.sidney.core.io.Encoding;
import com.github.jasonruckman.sidney.core.io.input.Input;
import com.github.jasonruckman.sidney.core.io.output.Output;
import com.github.jasonruckman.sidney.core.io.int32.Int32Decoder;
import com.github.jasonruckman.sidney.core.io.int32.Int32Encoder;
import com.github.jasonruckman.sidney.core.io.strategies.*;

public class RLE {
  private static final Encoding VALUE_ENCODING = Encoding.PLAIN;
  private static final Encoding RUN_SIZE_ENCODING = Encoding.PLAIN;

  public static class RLEFloat32Decoder implements Float32Decoder {
    private final Int32Decoder valueDecoder = VALUE_ENCODING.newInt32Decoder();
    private final Int32Decoder runSizeDecoder = RUN_SIZE_ENCODING.newInt32Decoder();
    private int runSize = 0;
    private float currentRun = 0;

    public float nextFloat() {
      if (runSize-- == 0) {
        loadNextRun();
        runSize--;
      }

      return currentRun;
    }

    @Override
    public float[] nextFloats(int num) {
      float[] floats = new float[num];
      for (int i = 0; i < num; i++) {
        floats[i] = nextFloat();
      }
      return floats;
    }

    private void loadNextRun() {
      currentRun = Float.intBitsToFloat(valueDecoder.nextInt());
      runSize = runSizeDecoder.nextInt();
    }

    @Override
    public void initialize(Input input) {
      runSize = 0;
      currentRun = 0;

      valueDecoder.initialize(input);
      runSizeDecoder.initialize(input);
    }

    @Override
    public ColumnLoadStrategy strategy() {
      return new Default.DefaultColumnLoadStrategy();
    }
  }

  public static class RLEFloat32Encoder implements Float32Encoder {
    private final Int32Encoder valueEncoder = VALUE_ENCODING.newInt32Encoder();
    private final Int32Encoder runSizeEncoder = RUN_SIZE_ENCODING.newInt32Encoder();
    private float currentRun = 0;
    private int runSize = 0;
    private boolean isNewRun = true;

    @Override
    public void writeFloat(float value, Output output) {
      if (isNewRun) {
        currentRun = value;
        isNewRun = false;
      } else if (Float.compare(currentRun, value) != 0) {
        flush(output);
        currentRun = value;
      }
      ++runSize;
    }

    @Override
    public void writeFloats(float[] floats, Output output) {
      for (float v : floats) {
        writeFloat(v, output);
      }
    }

    private void flushRun(Output output) {
      int floatBits = Float.floatToIntBits(currentRun);

      valueEncoder.writeInt(floatBits, output);
      runSizeEncoder.writeInt(runSize, output);

      currentRun = 0;
      runSize = 0;
    }

    @Override
    public void reset() {
      valueEncoder.reset();
      runSizeEncoder.reset();
      isNewRun = true;
      currentRun = 0;
      runSize = 0;
    }

    @Override
    public void flush(Output output) {
      flushRun(output);

      valueEncoder.flush(output);
      runSizeEncoder.flush(output);
    }

    @Override
    public ColumnWriteStrategy strategy() {
      return new Default.DefaultColumnWriteStrategy();
    }
  }
}