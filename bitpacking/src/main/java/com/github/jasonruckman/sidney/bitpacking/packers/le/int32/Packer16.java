package com.github.jasonruckman.sidney.bitpacking.packers.le.int32;

import com.github.jasonruckman.sidney.bitpacking.Int32BytePacker;

public final class Packer16 extends Int32BytePacker {

  public Packer16() {
    super(16);
  }

  public final void pack8Values(final int[] in, final int inPos, final byte[] out, final int outPos) {
    out[0 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[0 + inPos] & 65535))) & 255);
    out[1 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[0 + inPos] & 65535) >>> 8)) & 255);
    out[2 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[1 + inPos] & 65535))) & 255);
    out[3 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[1 + inPos] & 65535) >>> 8)) & 255);
    out[4 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[2 + inPos] & 65535))) & 255);
    out[5 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[2 + inPos] & 65535) >>> 8)) & 255);
    out[6 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[3 + inPos] & 65535))) & 255);
    out[7 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[3 + inPos] & 65535) >>> 8)) & 255);
    out[8 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[4 + inPos] & 65535))) & 255);
    out[9 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[4 + inPos] & 65535) >>> 8)) & 255);
    out[10 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[5 + inPos] & 65535))) & 255);
    out[11 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[5 + inPos] & 65535) >>> 8)) & 255);
    out[12 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[6 + inPos] & 65535))) & 255);
    out[13 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[6 + inPos] & 65535) >>> 8)) & 255);
    out[14 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[7 + inPos] & 65535))) & 255);
    out[15 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[7 + inPos] & 65535) >>> 8)) & 255);
  }

  public final void pack32Values(final int[] in, final int inPos, final byte[] out, final int outPos) {
    out[0 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[0 + inPos] & 65535))) & 255);
    out[1 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[0 + inPos] & 65535) >>> 8)) & 255);
    out[2 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[1 + inPos] & 65535))) & 255);
    out[3 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[1 + inPos] & 65535) >>> 8)) & 255);
    out[4 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[2 + inPos] & 65535))) & 255);
    out[5 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[2 + inPos] & 65535) >>> 8)) & 255);
    out[6 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[3 + inPos] & 65535))) & 255);
    out[7 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[3 + inPos] & 65535) >>> 8)) & 255);
    out[8 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[4 + inPos] & 65535))) & 255);
    out[9 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[4 + inPos] & 65535) >>> 8)) & 255);
    out[10 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[5 + inPos] & 65535))) & 255);
    out[11 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[5 + inPos] & 65535) >>> 8)) & 255);
    out[12 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[6 + inPos] & 65535))) & 255);
    out[13 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[6 + inPos] & 65535) >>> 8)) & 255);
    out[14 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[7 + inPos] & 65535))) & 255);
    out[15 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[7 + inPos] & 65535) >>> 8)) & 255);
    out[16 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[8 + inPos] & 65535))) & 255);
    out[17 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[8 + inPos] & 65535) >>> 8)) & 255);
    out[18 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[9 + inPos] & 65535))) & 255);
    out[19 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[9 + inPos] & 65535) >>> 8)) & 255);
    out[20 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[10 + inPos] & 65535))) & 255);
    out[21 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[10 + inPos] & 65535) >>> 8)) & 255);
    out[22 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[11 + inPos] & 65535))) & 255);
    out[23 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[11 + inPos] & 65535) >>> 8)) & 255);
    out[24 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[12 + inPos] & 65535))) & 255);
    out[25 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[12 + inPos] & 65535) >>> 8)) & 255);
    out[26 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[13 + inPos] & 65535))) & 255);
    out[27 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[13 + inPos] & 65535) >>> 8)) & 255);
    out[28 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[14 + inPos] & 65535))) & 255);
    out[29 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[14 + inPos] & 65535) >>> 8)) & 255);
    out[30 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[15 + inPos] & 65535))) & 255);
    out[31 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[15 + inPos] & 65535) >>> 8)) & 255);
    out[32 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[16 + inPos] & 65535))) & 255);
    out[33 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[16 + inPos] & 65535) >>> 8)) & 255);
    out[34 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[17 + inPos] & 65535))) & 255);
    out[35 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[17 + inPos] & 65535) >>> 8)) & 255);
    out[36 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[18 + inPos] & 65535))) & 255);
    out[37 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[18 + inPos] & 65535) >>> 8)) & 255);
    out[38 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[19 + inPos] & 65535))) & 255);
    out[39 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[19 + inPos] & 65535) >>> 8)) & 255);
    out[40 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[20 + inPos] & 65535))) & 255);
    out[41 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[20 + inPos] & 65535) >>> 8)) & 255);
    out[42 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[21 + inPos] & 65535))) & 255);
    out[43 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[21 + inPos] & 65535) >>> 8)) & 255);
    out[44 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[22 + inPos] & 65535))) & 255);
    out[45 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[22 + inPos] & 65535) >>> 8)) & 255);
    out[46 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[23 + inPos] & 65535))) & 255);
    out[47 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[23 + inPos] & 65535) >>> 8)) & 255);
    out[48 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[24 + inPos] & 65535))) & 255);
    out[49 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[24 + inPos] & 65535) >>> 8)) & 255);
    out[50 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[25 + inPos] & 65535))) & 255);
    out[51 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[25 + inPos] & 65535) >>> 8)) & 255);
    out[52 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[26 + inPos] & 65535))) & 255);
    out[53 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[26 + inPos] & 65535) >>> 8)) & 255);
    out[54 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[27 + inPos] & 65535))) & 255);
    out[55 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[27 + inPos] & 65535) >>> 8)) & 255);
    out[56 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[28 + inPos] & 65535))) & 255);
    out[57 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[28 + inPos] & 65535) >>> 8)) & 255);
    out[58 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[29 + inPos] & 65535))) & 255);
    out[59 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[29 + inPos] & 65535) >>> 8)) & 255);
    out[60 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[30 + inPos] & 65535))) & 255);
    out[61 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[30 + inPos] & 65535) >>> 8)) & 255);
    out[62 + outPos] = (byte) ((
        //                          [76543210]
        //                  [________76543210]
        ((in[31 + inPos] & 65535))) & 255);
    out[63 + outPos] = (byte) ((
        //                          [76543210]
        //                          [54321098________]
        ((in[31 + inPos] & 65535) >>> 8)) & 255);
  }

  public final void unpack8Values(final byte[] in, final int inPos, final int[] out, final int outPos) {
    out[0 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[0 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[1 + inPos]) & 255) << 8) & 65535);
    out[1 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[2 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[3 + inPos]) & 255) << 8) & 65535);
    out[2 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[4 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[5 + inPos]) & 255) << 8) & 65535);
    out[3 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[6 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[7 + inPos]) & 255) << 8) & 65535);
    out[4 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[8 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[9 + inPos]) & 255) << 8) & 65535);
    out[5 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[10 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[11 + inPos]) & 255) << 8) & 65535);
    out[6 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[12 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[13 + inPos]) & 255) << 8) & 65535);
    out[7 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[14 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[15 + inPos]) & 255) << 8) & 65535);
  }

  public final void unpack32Values(final byte[] in, final int inPos, final int[] out, final int outPos) {
    out[0 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[0 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[1 + inPos]) & 255) << 8) & 65535);
    out[1 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[2 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[3 + inPos]) & 255) << 8) & 65535);
    out[2 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[4 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[5 + inPos]) & 255) << 8) & 65535);
    out[3 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[6 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[7 + inPos]) & 255) << 8) & 65535);
    out[4 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[8 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[9 + inPos]) & 255) << 8) & 65535);
    out[5 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[10 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[11 + inPos]) & 255) << 8) & 65535);
    out[6 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[12 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[13 + inPos]) & 255) << 8) & 65535);
    out[7 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[14 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[15 + inPos]) & 255) << 8) & 65535);
    out[8 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[16 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[17 + inPos]) & 255) << 8) & 65535);
    out[9 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[18 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[19 + inPos]) & 255) << 8) & 65535);
    out[10 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[20 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[21 + inPos]) & 255) << 8) & 65535);
    out[11 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[22 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[23 + inPos]) & 255) << 8) & 65535);
    out[12 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[24 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[25 + inPos]) & 255) << 8) & 65535);
    out[13 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[26 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[27 + inPos]) & 255) << 8) & 65535);
    out[14 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[28 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[29 + inPos]) & 255) << 8) & 65535);
    out[15 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[30 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[31 + inPos]) & 255) << 8) & 65535);
    out[16 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[32 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[33 + inPos]) & 255) << 8) & 65535);
    out[17 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[34 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[35 + inPos]) & 255) << 8) & 65535);
    out[18 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[36 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[37 + inPos]) & 255) << 8) & 65535);
    out[19 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[38 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[39 + inPos]) & 255) << 8) & 65535);
    out[20 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[40 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[41 + inPos]) & 255) << 8) & 65535);
    out[21 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[42 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[43 + inPos]) & 255) << 8) & 65535);
    out[22 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[44 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[45 + inPos]) & 255) << 8) & 65535);
    out[23 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[46 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[47 + inPos]) & 255) << 8) & 65535);
    out[24 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[48 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[49 + inPos]) & 255) << 8) & 65535);
    out[25 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[50 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[51 + inPos]) & 255) << 8) & 65535);
    out[26 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[52 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[53 + inPos]) & 255) << 8) & 65535);
    out[27 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[54 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[55 + inPos]) & 255) << 8) & 65535);
    out[28 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[56 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[57 + inPos]) & 255) << 8) & 65535);
    out[29 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[58 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[59 + inPos]) & 255) << 8) & 65535);
    out[30 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[60 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[61 + inPos]) & 255) << 8) & 65535);
    out[31 + outPos] =
        //                          [76543210]
        //                  [________76543210]
        (((((int) in[62 + inPos]) & 255)) & 65535)
            | //                          [76543210]
            //                          [54321098________]
            (((((int) in[63 + inPos]) & 255) << 8) & 65535);
  }
}
