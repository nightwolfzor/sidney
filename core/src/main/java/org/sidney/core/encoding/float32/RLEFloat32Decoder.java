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
package org.sidney.core.encoding.float32;

import org.sidney.core.encoding.AbstractDecoder;
import org.sidney.core.encoding.Encoding;
import org.sidney.core.encoding.int32.Int32Decoder;

import java.io.IOException;
import java.io.InputStream;

public class RLEFloat32Decoder extends AbstractDecoder implements Float32Decoder {
    private final Int32Decoder valueDecoder = Encoding.DELTABITPACKINGHYBRID.newInt32Decoder();
    private final Int32Decoder runSizeDecoder = Encoding.BITPACKED.newInt32Decoder();
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

    @Override
    public String supportedEncoding() {
        return Encoding.RLE.name();
    }

    @Override
    public void populateBufferFromStream(InputStream inputStream) throws IOException {
        runSize = 0;
        currentRun = 0;

        valueDecoder.populateBufferFromStream(inputStream);
        runSizeDecoder.populateBufferFromStream(inputStream);
    }

    private void loadNextRun() {
        currentRun = Float.intBitsToFloat(valueDecoder.nextInt());
        runSize = runSizeDecoder.nextInt();
    }
}