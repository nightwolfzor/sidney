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
package com.github.jasonruckman.sidney.core.io.strategies;

import com.github.jasonruckman.sidney.core.io.Decoder;
import com.github.jasonruckman.sidney.core.io.Encoder;
import com.github.jasonruckman.sidney.core.io.StreamReader;
import com.github.jasonruckman.sidney.core.io.StreamWriter;
import com.github.jasonruckman.sidney.core.io.input.Input;
import com.github.jasonruckman.sidney.core.io.output.Output;

import java.io.InputStream;
import java.io.OutputStream;

public class DirectStream {
  public static class DirectStreamColumnLoadStrategy implements ColumnLoadStrategy {
    @Override
    public void load(Decoder decoder, Input input, InputStream stream) {
      ((StreamReader) decoder).read(stream);
    }
  }

  public static class DirectStreamColumnWriteStrategy implements ColumnWriteStrategy {
    @Override
    public void write(Encoder encoder, Output output, OutputStream outputStream) {
      ((StreamWriter) encoder).write(outputStream);
      encoder.reset();
    }
  }
}