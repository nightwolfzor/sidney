package org.sidney.core.serde;

import org.sidney.core.ColumnOperations;
import org.sidney.core.column.ColumnIO;
import org.sidney.core.encoding.Encoder;

import java.io.IOException;
import java.io.OutputStream;

public class ColumnWriter extends ColumnOperations {
    public ColumnWriter(TypeHandler typeHandler) {
        super(typeHandler);
    }

    public void writeBoolean(int index, boolean value) {
        ColumnIO columnIO = columnIOs.get(index);
        columnIO.writeBoolean(value);
    }

    public void writeInt(int index, int value) {
        ColumnIO columnIO = columnIOs.get(index);
        columnIO.writeInt(value);
    }

    public void writeLong(int index, long value) {
        ColumnIO columnIO = columnIOs.get(index);
        columnIO.writeLong(value);
    }

    public void writeFloat(int index, float value) {
        ColumnIO columnIO = columnIOs.get(index);
        columnIO.writeFloat(value);
    }

    public void writeDouble(int index, double value) {
        ColumnIO columnIO = columnIOs.get(index);
        columnIO.writeDouble(value);
    }

    public void writeBytes(int index, byte[] bytes) {
        ColumnIO columnIO = columnIOs.get(index);
        columnIO.writeBytes(bytes);
    }

    public void writeString(int index, String value) {
        ColumnIO columnIO = columnIOs.get(index);
        columnIO.writeString(value);
    }

    public void writeNotNull(int index) {
        columnIOs.get(index).writeNotNull();
    }

    public void writeNull(int index) {
        columnIOs.get(index).writeNull();
    }

    public void writeRepetitionCount(int index, int value) {
        columnIOs.get(index).writeRepetitionCount(value);
    }

    public void writeConcreteType(Class<?> type, int index, WriteContext context) {
        columnIOs.get(index).writeConcreteType(type, context);
    }

    public void flushToOutputStream(OutputStream outputStream) throws IOException {
        definitionEncoder.writeToStream(outputStream);
        repetitionEncoder.writeToStream(outputStream);

        for (ColumnIO columnIO : columnIOs) {
            if (columnIO.getEncoders() != null) {
                for (Encoder encoder : columnIO.getEncoders()) {
                    encoder.writeToStream(outputStream);
                }
            }
        }

        outputStream.flush();
        reset();
    }

    public void reset() {
        definitionEncoder.reset();
        repetitionEncoder.reset();

        for (ColumnIO columnIO : columnIOs) {
            for (Encoder encoder : columnIO.getEncoders()) {
                encoder.reset();
            }
        }
    }
}