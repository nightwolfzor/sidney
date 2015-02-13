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

import com.github.jasonruckman.sidney.core.SidneyConf;
import com.github.jasonruckman.sidney.core.io.Columns;
import com.github.jasonruckman.sidney.core.io.Decoder;
import com.github.jasonruckman.sidney.core.serde.serializer.ColumnOperations;

import java.io.IOException;
import java.io.InputStream;

public class ColumnReader extends ColumnOperations {
  private final SidneyConf conf;

  public ColumnReader(SidneyConf conf) {
    this.conf = conf;
  }

  public boolean readBool(int index) {
    return columnIOs.get(index).readBoolean();
  }

  public int readInt(int index) {
    return columnIOs.get(index).readInt();
  }

  public long readLong(int index) {
    return columnIOs.get(index).readLong();
  }

  public float readFloat(int index) {
    return columnIOs.get(index).readFloat();
  }

  public double readDouble(int index) {
    return columnIOs.get(index).readDouble();
  }

  public String readString(int index) {
    return columnIOs.get(index).readString();
  }

  public byte[] readBytes(int index) {
    return columnIOs.get(index).readBytes();
  }

  public boolean readNullMarker(int index) {
    return columnIOs.get(index).readNullMarker();
  }

  public int readRepetitionCount(int index) {
    return columnIOs.get(index).readRepetitionCount();
  }

  public Class readConcreteType(int index, ReadContext context) {
    return columnIOs.get(index).readConcreteType(context);
  }

  public int readDefinition(int index) {
    return columnIOs.get(index).readDefinition();
  }

  public void loadFromInputStream(InputStream inputStream) throws IOException {
    for (Columns.ColumnIO columnIO : columnIOs) {
      columnIO.getEncoding().readFromStream(inputStream);

      for (Decoder decoder : columnIO.getDecoders()) {
        decoder.readFromStream(inputStream);
      }
    }
  }

  @Override
  public SidneyConf getConf() {
    return conf;
  }
}