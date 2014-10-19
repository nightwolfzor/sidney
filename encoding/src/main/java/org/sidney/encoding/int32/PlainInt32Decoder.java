package org.sidney.encoding.int32;

import org.sidney.encoding.AbstractDecoder;
import org.sidney.encoding.Encoding;

public class PlainInt32Decoder extends AbstractDecoder implements Int32Decoder {
    @Override
    public String supportedEncoding() {
        return Encoding.PLAIN.name();
    }

    @Override
    public int nextInt() {
        return readIntLE();
    }

    @Override
    public int[] nextInts(int num) {
        int[] results = new int[num];
        for (int i = 0; i < num; i++) {
            results[i] = nextInt();
        }
        return results;
    }
}
