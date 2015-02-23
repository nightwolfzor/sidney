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
package com.github.jasonruckman.sidney.core.io.bool;

import com.github.jasonruckman.sidney.core.io.input.Input;
import com.github.jasonruckman.sidney.core.io.output.Output;
import com.github.jasonruckman.sidney.core.io.strategies.*;

/**
 * Encodes bools as single bits, packed 32 to a long
 */
public class BitPacking {
  public static class BitPackingBoolDecoder implements BoolDecoder {
    private int currentBitIndex = 0;
    private long word = 0;
    private Input input;

    @Override
    public boolean nextBool() {
      boolean result = (word & (1L << currentBitIndex)) > 0;

      if (++currentBitIndex == 32) {
        loadNextWord();
      }

      return result;
    }

    @Override
    public boolean[] nextBools(int num) {
      boolean[] booleans = new boolean[num];
      for (int i = 0; i < num; i++) {
        booleans[i] = nextBool();
      }
      return booleans;
    }

    private void loadNextWord() {
      word = input.readLong();
      currentBitIndex = 0;
    }

    @Override
    public void initialize(Input input) {
      this.input = input;
      loadNextWord();
    }

    @Override
    public ColumnLoadStrategy strategy() {
      return new Default.DefaultColumnLoadStrategy();
    }
  }

  public static class BitPackingBoolEncoder implements BoolEncoder {
    private int currentBitIndex = 0;
    private long word = 0;
    @Override
    public void writeBool(boolean value, Output output) {
      if (value) {
        word |= (1L << currentBitIndex);
      }

      if (++currentBitIndex == 32) {
        flushWord(output);
      }
    }

    @Override
    public void writeBools(boolean[] values, Output output) {
      for (boolean b : values) {
        writeBool(b, output);
      }
    }

    @Override
    public void reset() {
      currentBitIndex = 0;
      word = 0;
    }

    @Override
    public void flush(Output output) {
      flushWord(output);
    }

    @Override
    public ColumnWriteStrategy strategy() {
      return new Default.DefaultColumnWriteStrategy();
    }

    private void flushWord(Output output) {
      output.writeLong(word);
      currentBitIndex = 0;
      word = 0;
    }
  }
}