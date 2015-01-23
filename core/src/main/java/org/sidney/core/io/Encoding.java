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
package org.sidney.core.io;

import org.sidney.core.UnsupportedEncodingException;
import org.sidney.core.io.bool.BitPacking;
import org.sidney.core.io.bool.BoolDecoder;
import org.sidney.core.io.bool.BoolEncoder;
import org.sidney.core.io.bool.EWAHBitmap;
import org.sidney.core.io.bytes.ByteArrayDecoder;
import org.sidney.core.io.bytes.ByteArrayEncoder;
import org.sidney.core.io.bytes.BytesDecoder;
import org.sidney.core.io.bytes.BytesEncoder;
import org.sidney.core.io.float32.Float32Decoder;
import org.sidney.core.io.float32.Float32Encoder;
import org.sidney.core.io.float32.RLE;
import org.sidney.core.io.float64.Float64Decoder;
import org.sidney.core.io.float64.Float64Encoder;
import org.sidney.core.io.int32.DeltaBitPacking;
import org.sidney.core.io.int32.Int32Decoder;
import org.sidney.core.io.int32.Int32Encoder;
import org.sidney.core.io.int32.Plain;
import org.sidney.core.io.int64.GroupVarInt;
import org.sidney.core.io.int64.Int64Decoder;
import org.sidney.core.io.int64.Int64Encoder;
import org.sidney.core.io.string.DeltaLength;
import org.sidney.core.io.string.StringDecoder;
import org.sidney.core.io.string.StringEncoder;
import org.sidney.core.serde.Type;

public enum Encoding {
    PLAIN {
        @Override
        public BoolEncoder newBoolEncoder() {
            return new org.sidney.core.io.bool.Plain.PlainBoolEncoder();
        }

        @Override
        public BoolDecoder newBoolDecoder() {
            return new org.sidney.core.io.bool.Plain.PlainBoolDecoder();
        }

        @Override
        public Int32Encoder newInt32Encoder() {
            return new Plain.PlainInt32Encoder();
        }

        @Override
        public Int32Decoder newInt32Decoder() {
            return new Plain.PlainInt32Decoder();
        }

        @Override
        public Int64Encoder newInt64Encoder() {
            return new org.sidney.core.io.int64.Plain.PlainInt64Encoder();
        }

        @Override
        public Int64Decoder newInt64Decoder() {
            return new org.sidney.core.io.int64.Plain.PlainInt64Decoder();
        }

        @Override
        public Float32Encoder newFloat32Encoder() {
            return new org.sidney.core.io.float32.Plain.PlainFloat32Encoder();
        }

        @Override
        public Float32Decoder newFloat32Decoder() {
            return new org.sidney.core.io.float32.Plain.PlainFloat32Decoder();
        }

        @Override
        public Float64Encoder newFloat64Encoder() {
            return new org.sidney.core.io.float64.Plain.PlainFloat64Encoder();
        }

        @Override
        public Float64Decoder newFloat64Decoder() {
            return new org.sidney.core.io.float64.Plain.PlainFloat64Decoder();
        }

        @Override
        public StringEncoder newStringEncoder() {
            return new org.sidney.core.io.string.Plain.PlainStringEncoder();
        }

        @Override
        public StringDecoder newStringDecoder() {
            return new org.sidney.core.io.string.Plain.PlainStringDecoder();
        }

        @Override
        public BytesEncoder newBytesEncoder() {
            return new ByteArrayEncoder();
        }

        @Override
        public BytesDecoder newBytesDecoder() {
            return new ByteArrayDecoder();
        }
    },
    BITPACKED {
        @Override
        public Int32Encoder newInt32Encoder() {
            return new org.sidney.core.io.int32.BitPacking.BitPackingInt32Encoder();
        }

        @Override
        public Int32Decoder newInt32Decoder() {
            return new org.sidney.core.io.int32.BitPacking.BitPackingInt32Decoder();
        }

        @Override
        public BoolEncoder newBoolEncoder() {
            return new BitPacking.BitPackingBoolEncoder();
        }

        @Override
        public BoolDecoder newBoolDecoder() {
            return new BitPacking.BitPackingBoolDecoder();
        }
    },
    DELTABITPACKINGHYBRID {
        @Override
        public Int32Encoder newInt32Encoder() {
            return new DeltaBitPacking.DeltaBitPackingInt32Encoder();
        }

        @Override
        public Int32Decoder newInt32Decoder() {
            return new DeltaBitPacking.DeltaBitPackingInt32Decoder();
        }
    },
    BITMAP {
        @Override
        public BoolEncoder newBoolEncoder() {
            return new EWAHBitmap.EWAHBitmapBoolEncoder();
        }

        @Override
        public BoolDecoder newBoolDecoder() {
            return new EWAHBitmap.EWAHBitmapBoolDecoder();
        }
    },
    GROUPVARINT {
        @Override
        public Int64Encoder newInt64Encoder() {
            return new GroupVarInt.GroupVarInt64Encoder();
        }

        @Override
        public Int64Decoder newInt64Decoder() {
            return new GroupVarInt.GroupVarInt64Decoder();
        }
    },
    DELTALENGTH {
        @Override
        public StringEncoder newStringEncoder() {
            return new DeltaLength.DeltaLengthStringEncoder();
        }
    },
    RLE {
        @Override
        public Int32Encoder newInt32Encoder() {
            return new org.sidney.core.io.int32.RLE.RLEInt32Encoder();
        }

        @Override
        public Int32Decoder newInt32Decoder() {
            return new org.sidney.core.io.int32.RLE.RLEInt32Decoder();
        }

        @Override
        public Int64Encoder newInt64Encoder() {
            return new org.sidney.core.io.int64.RLE.RLEInt64Encoder();
        }

        @Override
        public Int64Decoder newInt64Decoder() {
            return new org.sidney.core.io.int64.RLE.RLEInt64Decoder();
        }

        @Override
        public Float32Encoder newFloat32Encoder() {
            return new RLE.RLEFloat32Encoder();
        }

        @Override
        public Float32Decoder newFloat32Decoder() {
            return new RLE.RLEFloat32Decoder();
        }

        @Override
        public StringEncoder newStringEncoder() {
            return new org.sidney.core.io.string.RLE.RLEStringEncoder();
        }

        @Override
        public StringDecoder newStringDecoder() {
            return new org.sidney.core.io.string.RLE.RLEStringDecoder();
        }
    };

    public BoolEncoder newBoolEncoder() {
        throw new UnsupportedEncodingException(
                this, Type.BOOLEAN
        );
    }

    public BoolDecoder newBoolDecoder() {
        throw new UnsupportedEncodingException(
                this, Type.BOOLEAN
        );
    }

    public Int32Encoder newInt32Encoder() {
        throw new UnsupportedEncodingException(
                this, Type.INT32
        );
    }

    public Int32Decoder newInt32Decoder() {
        throw new UnsupportedEncodingException(
                this, Type.INT32
        );
    }

    public Int64Encoder newInt64Encoder() {
        throw new UnsupportedEncodingException(
                this, Type.INT64
        );
    }

    public Int64Decoder newInt64Decoder() {
        throw new UnsupportedEncodingException(
                this, Type.INT64
        );
    }

    public Float32Encoder newFloat32Encoder() {
        throw new UnsupportedEncodingException(
                this, Type.FLOAT32
        );
    }

    public Float32Decoder newFloat32Decoder() {
        throw new UnsupportedEncodingException(
                this, Type.FLOAT32
        );
    }

    public Float64Encoder newFloat64Encoder() {
        throw new UnsupportedEncodingException(
                this, Type.FLOAT64
        );
    }

    public Float64Decoder newFloat64Decoder() {
        throw new UnsupportedEncodingException(
                this, Type.FLOAT64
        );
    }

    public BytesEncoder newBytesEncoder() {
        throw new UnsupportedEncodingException(
                this, Type.BINARY
        );
    }

    public BytesDecoder newBytesDecoder() {
        throw new UnsupportedEncodingException(
                this, Type.BINARY
        );
    }

    public StringEncoder newStringEncoder() {
        throw new UnsupportedEncodingException(
                this, Type.STRING
        );
    }

    public StringDecoder newStringDecoder() {
        throw new UnsupportedEncodingException(
                this, Type.STRING
        );
    }
}