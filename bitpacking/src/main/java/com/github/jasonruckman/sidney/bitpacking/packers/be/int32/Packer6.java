package com.github.jasonruckman.sidney.bitpacking.packers.be.int32;

import com.github.jasonruckman.sidney.bitpacking.Int32BytePacker;

public final class Packer6 extends Int32BytePacker {

  public Packer6() {
    super(6);
  }

  public final void pack8Values(final int[] in, final int inPos, final byte[] out, final int outPos) {
    out[0 + outPos] = (byte) ((
        //                [765432__]
        //                [543210]
        ((in[0 + inPos] & 63) << 2)
            | //                [______10]
            //                      [54____]
            ((in[1 + inPos] & 63) >>> 4)) & 255);
    out[1 + outPos] = (byte) ((
        //                [7654____]
        //              [__3210]
        ((in[1 + inPos] & 63) << 4)
            | //                [____3210]
            //                    [5432__]
            ((in[2 + inPos] & 63) >>> 2)) & 255);
    out[2 + outPos] = (byte) ((
        //                [76______]
        //            [____10]
        ((in[2 + inPos] & 63) << 6)
            | //                [__543210]
            //                  [543210]
            ((in[3 + inPos] & 63))) & 255);
    out[3 + outPos] = (byte) ((
        //                [765432__]
        //                [543210]
        ((in[4 + inPos] & 63) << 2)
            | //                [______10]
            //                      [54____]
            ((in[5 + inPos] & 63) >>> 4)) & 255);
    out[4 + outPos] = (byte) ((
        //                [7654____]
        //              [__3210]
        ((in[5 + inPos] & 63) << 4)
            | //                [____3210]
            //                    [5432__]
            ((in[6 + inPos] & 63) >>> 2)) & 255);
    out[5 + outPos] = (byte) ((
        //                [76______]
        //            [____10]
        ((in[6 + inPos] & 63) << 6)
            | //                [__543210]
            //                  [543210]
            ((in[7 + inPos] & 63))) & 255);
  }

  public final void pack32Values(final int[] in, final int inPos, final byte[] out, final int outPos) {
    out[0 + outPos] = (byte) ((
        //                [765432__]
        //                [543210]
        ((in[0 + inPos] & 63) << 2)
            | //                [______10]
            //                      [54____]
            ((in[1 + inPos] & 63) >>> 4)) & 255);
    out[1 + outPos] = (byte) ((
        //                [7654____]
        //              [__3210]
        ((in[1 + inPos] & 63) << 4)
            | //                [____3210]
            //                    [5432__]
            ((in[2 + inPos] & 63) >>> 2)) & 255);
    out[2 + outPos] = (byte) ((
        //                [76______]
        //            [____10]
        ((in[2 + inPos] & 63) << 6)
            | //                [__543210]
            //                  [543210]
            ((in[3 + inPos] & 63))) & 255);
    out[3 + outPos] = (byte) ((
        //                [765432__]
        //                [543210]
        ((in[4 + inPos] & 63) << 2)
            | //                [______10]
            //                      [54____]
            ((in[5 + inPos] & 63) >>> 4)) & 255);
    out[4 + outPos] = (byte) ((
        //                [7654____]
        //              [__3210]
        ((in[5 + inPos] & 63) << 4)
            | //                [____3210]
            //                    [5432__]
            ((in[6 + inPos] & 63) >>> 2)) & 255);
    out[5 + outPos] = (byte) ((
        //                [76______]
        //            [____10]
        ((in[6 + inPos] & 63) << 6)
            | //                [__543210]
            //                  [543210]
            ((in[7 + inPos] & 63))) & 255);
    out[6 + outPos] = (byte) ((
        //                [765432__]
        //                [543210]
        ((in[8 + inPos] & 63) << 2)
            | //                [______10]
            //                      [54____]
            ((in[9 + inPos] & 63) >>> 4)) & 255);
    out[7 + outPos] = (byte) ((
        //                [7654____]
        //              [__3210]
        ((in[9 + inPos] & 63) << 4)
            | //                [____3210]
            //                    [5432__]
            ((in[10 + inPos] & 63) >>> 2)) & 255);
    out[8 + outPos] = (byte) ((
        //                [76______]
        //            [____10]
        ((in[10 + inPos] & 63) << 6)
            | //                [__543210]
            //                  [543210]
            ((in[11 + inPos] & 63))) & 255);
    out[9 + outPos] = (byte) ((
        //                [765432__]
        //                [543210]
        ((in[12 + inPos] & 63) << 2)
            | //                [______10]
            //                      [54____]
            ((in[13 + inPos] & 63) >>> 4)) & 255);
    out[10 + outPos] = (byte) ((
        //                [7654____]
        //              [__3210]
        ((in[13 + inPos] & 63) << 4)
            | //                [____3210]
            //                    [5432__]
            ((in[14 + inPos] & 63) >>> 2)) & 255);
    out[11 + outPos] = (byte) ((
        //                [76______]
        //            [____10]
        ((in[14 + inPos] & 63) << 6)
            | //                [__543210]
            //                  [543210]
            ((in[15 + inPos] & 63))) & 255);
    out[12 + outPos] = (byte) ((
        //                [765432__]
        //                [543210]
        ((in[16 + inPos] & 63) << 2)
            | //                [______10]
            //                      [54____]
            ((in[17 + inPos] & 63) >>> 4)) & 255);
    out[13 + outPos] = (byte) ((
        //                [7654____]
        //              [__3210]
        ((in[17 + inPos] & 63) << 4)
            | //                [____3210]
            //                    [5432__]
            ((in[18 + inPos] & 63) >>> 2)) & 255);
    out[14 + outPos] = (byte) ((
        //                [76______]
        //            [____10]
        ((in[18 + inPos] & 63) << 6)
            | //                [__543210]
            //                  [543210]
            ((in[19 + inPos] & 63))) & 255);
    out[15 + outPos] = (byte) ((
        //                [765432__]
        //                [543210]
        ((in[20 + inPos] & 63) << 2)
            | //                [______10]
            //                      [54____]
            ((in[21 + inPos] & 63) >>> 4)) & 255);
    out[16 + outPos] = (byte) ((
        //                [7654____]
        //              [__3210]
        ((in[21 + inPos] & 63) << 4)
            | //                [____3210]
            //                    [5432__]
            ((in[22 + inPos] & 63) >>> 2)) & 255);
    out[17 + outPos] = (byte) ((
        //                [76______]
        //            [____10]
        ((in[22 + inPos] & 63) << 6)
            | //                [__543210]
            //                  [543210]
            ((in[23 + inPos] & 63))) & 255);
    out[18 + outPos] = (byte) ((
        //                [765432__]
        //                [543210]
        ((in[24 + inPos] & 63) << 2)
            | //                [______10]
            //                      [54____]
            ((in[25 + inPos] & 63) >>> 4)) & 255);
    out[19 + outPos] = (byte) ((
        //                [7654____]
        //              [__3210]
        ((in[25 + inPos] & 63) << 4)
            | //                [____3210]
            //                    [5432__]
            ((in[26 + inPos] & 63) >>> 2)) & 255);
    out[20 + outPos] = (byte) ((
        //                [76______]
        //            [____10]
        ((in[26 + inPos] & 63) << 6)
            | //                [__543210]
            //                  [543210]
            ((in[27 + inPos] & 63))) & 255);
    out[21 + outPos] = (byte) ((
        //                [765432__]
        //                [543210]
        ((in[28 + inPos] & 63) << 2)
            | //                [______10]
            //                      [54____]
            ((in[29 + inPos] & 63) >>> 4)) & 255);
    out[22 + outPos] = (byte) ((
        //                [7654____]
        //              [__3210]
        ((in[29 + inPos] & 63) << 4)
            | //                [____3210]
            //                    [5432__]
            ((in[30 + inPos] & 63) >>> 2)) & 255);
    out[23 + outPos] = (byte) ((
        //                [76______]
        //            [____10]
        ((in[30 + inPos] & 63) << 6)
            | //                [__543210]
            //                  [543210]
            ((in[31 + inPos] & 63))) & 255);
  }

  public final void unpack8Values(final byte[] in, final int inPos, final int[] out, final int outPos) {
    out[0 + outPos] =
        //                [765432__]
        //                [543210]
        (((((int) in[0 + inPos]) & 255) >>> 2) & 63);
    out[1 + outPos] =
        //                [______10]
        //                      [54____]
        (((((int) in[0 + inPos]) & 255) << 4) & 63)
            | //                [7654____]
            //              [__3210]
            (((((int) in[1 + inPos]) & 255) >>> 4) & 63);
    out[2 + outPos] =
        //                [____3210]
        //                    [5432__]
        (((((int) in[1 + inPos]) & 255) << 2) & 63)
            | //                [76______]
            //            [____10]
            (((((int) in[2 + inPos]) & 255) >>> 6) & 63);
    out[3 + outPos] =
        //                [__543210]
        //                  [543210]
        (((((int) in[2 + inPos]) & 255)) & 63);
    out[4 + outPos] =
        //                [765432__]
        //                [543210]
        (((((int) in[3 + inPos]) & 255) >>> 2) & 63);
    out[5 + outPos] =
        //                [______10]
        //                      [54____]
        (((((int) in[3 + inPos]) & 255) << 4) & 63)
            | //                [7654____]
            //              [__3210]
            (((((int) in[4 + inPos]) & 255) >>> 4) & 63);
    out[6 + outPos] =
        //                [____3210]
        //                    [5432__]
        (((((int) in[4 + inPos]) & 255) << 2) & 63)
            | //                [76______]
            //            [____10]
            (((((int) in[5 + inPos]) & 255) >>> 6) & 63);
    out[7 + outPos] =
        //                [__543210]
        //                  [543210]
        (((((int) in[5 + inPos]) & 255)) & 63);
  }

  public final void unpack32Values(final byte[] in, final int inPos, final int[] out, final int outPos) {
    out[0 + outPos] =
        //                [765432__]
        //                [543210]
        (((((int) in[0 + inPos]) & 255) >>> 2) & 63);
    out[1 + outPos] =
        //                [______10]
        //                      [54____]
        (((((int) in[0 + inPos]) & 255) << 4) & 63)
            | //                [7654____]
            //              [__3210]
            (((((int) in[1 + inPos]) & 255) >>> 4) & 63);
    out[2 + outPos] =
        //                [____3210]
        //                    [5432__]
        (((((int) in[1 + inPos]) & 255) << 2) & 63)
            | //                [76______]
            //            [____10]
            (((((int) in[2 + inPos]) & 255) >>> 6) & 63);
    out[3 + outPos] =
        //                [__543210]
        //                  [543210]
        (((((int) in[2 + inPos]) & 255)) & 63);
    out[4 + outPos] =
        //                [765432__]
        //                [543210]
        (((((int) in[3 + inPos]) & 255) >>> 2) & 63);
    out[5 + outPos] =
        //                [______10]
        //                      [54____]
        (((((int) in[3 + inPos]) & 255) << 4) & 63)
            | //                [7654____]
            //              [__3210]
            (((((int) in[4 + inPos]) & 255) >>> 4) & 63);
    out[6 + outPos] =
        //                [____3210]
        //                    [5432__]
        (((((int) in[4 + inPos]) & 255) << 2) & 63)
            | //                [76______]
            //            [____10]
            (((((int) in[5 + inPos]) & 255) >>> 6) & 63);
    out[7 + outPos] =
        //                [__543210]
        //                  [543210]
        (((((int) in[5 + inPos]) & 255)) & 63);
    out[8 + outPos] =
        //                [765432__]
        //                [543210]
        (((((int) in[6 + inPos]) & 255) >>> 2) & 63);
    out[9 + outPos] =
        //                [______10]
        //                      [54____]
        (((((int) in[6 + inPos]) & 255) << 4) & 63)
            | //                [7654____]
            //              [__3210]
            (((((int) in[7 + inPos]) & 255) >>> 4) & 63);
    out[10 + outPos] =
        //                [____3210]
        //                    [5432__]
        (((((int) in[7 + inPos]) & 255) << 2) & 63)
            | //                [76______]
            //            [____10]
            (((((int) in[8 + inPos]) & 255) >>> 6) & 63);
    out[11 + outPos] =
        //                [__543210]
        //                  [543210]
        (((((int) in[8 + inPos]) & 255)) & 63);
    out[12 + outPos] =
        //                [765432__]
        //                [543210]
        (((((int) in[9 + inPos]) & 255) >>> 2) & 63);
    out[13 + outPos] =
        //                [______10]
        //                      [54____]
        (((((int) in[9 + inPos]) & 255) << 4) & 63)
            | //                [7654____]
            //              [__3210]
            (((((int) in[10 + inPos]) & 255) >>> 4) & 63);
    out[14 + outPos] =
        //                [____3210]
        //                    [5432__]
        (((((int) in[10 + inPos]) & 255) << 2) & 63)
            | //                [76______]
            //            [____10]
            (((((int) in[11 + inPos]) & 255) >>> 6) & 63);
    out[15 + outPos] =
        //                [__543210]
        //                  [543210]
        (((((int) in[11 + inPos]) & 255)) & 63);
    out[16 + outPos] =
        //                [765432__]
        //                [543210]
        (((((int) in[12 + inPos]) & 255) >>> 2) & 63);
    out[17 + outPos] =
        //                [______10]
        //                      [54____]
        (((((int) in[12 + inPos]) & 255) << 4) & 63)
            | //                [7654____]
            //              [__3210]
            (((((int) in[13 + inPos]) & 255) >>> 4) & 63);
    out[18 + outPos] =
        //                [____3210]
        //                    [5432__]
        (((((int) in[13 + inPos]) & 255) << 2) & 63)
            | //                [76______]
            //            [____10]
            (((((int) in[14 + inPos]) & 255) >>> 6) & 63);
    out[19 + outPos] =
        //                [__543210]
        //                  [543210]
        (((((int) in[14 + inPos]) & 255)) & 63);
    out[20 + outPos] =
        //                [765432__]
        //                [543210]
        (((((int) in[15 + inPos]) & 255) >>> 2) & 63);
    out[21 + outPos] =
        //                [______10]
        //                      [54____]
        (((((int) in[15 + inPos]) & 255) << 4) & 63)
            | //                [7654____]
            //              [__3210]
            (((((int) in[16 + inPos]) & 255) >>> 4) & 63);
    out[22 + outPos] =
        //                [____3210]
        //                    [5432__]
        (((((int) in[16 + inPos]) & 255) << 2) & 63)
            | //                [76______]
            //            [____10]
            (((((int) in[17 + inPos]) & 255) >>> 6) & 63);
    out[23 + outPos] =
        //                [__543210]
        //                  [543210]
        (((((int) in[17 + inPos]) & 255)) & 63);
    out[24 + outPos] =
        //                [765432__]
        //                [543210]
        (((((int) in[18 + inPos]) & 255) >>> 2) & 63);
    out[25 + outPos] =
        //                [______10]
        //                      [54____]
        (((((int) in[18 + inPos]) & 255) << 4) & 63)
            | //                [7654____]
            //              [__3210]
            (((((int) in[19 + inPos]) & 255) >>> 4) & 63);
    out[26 + outPos] =
        //                [____3210]
        //                    [5432__]
        (((((int) in[19 + inPos]) & 255) << 2) & 63)
            | //                [76______]
            //            [____10]
            (((((int) in[20 + inPos]) & 255) >>> 6) & 63);
    out[27 + outPos] =
        //                [__543210]
        //                  [543210]
        (((((int) in[20 + inPos]) & 255)) & 63);
    out[28 + outPos] =
        //                [765432__]
        //                [543210]
        (((((int) in[21 + inPos]) & 255) >>> 2) & 63);
    out[29 + outPos] =
        //                [______10]
        //                      [54____]
        (((((int) in[21 + inPos]) & 255) << 4) & 63)
            | //                [7654____]
            //              [__3210]
            (((((int) in[22 + inPos]) & 255) >>> 4) & 63);
    out[30 + outPos] =
        //                [____3210]
        //                    [5432__]
        (((((int) in[22 + inPos]) & 255) << 2) & 63)
            | //                [76______]
            //            [____10]
            (((((int) in[23 + inPos]) & 255) >>> 6) & 63);
    out[31 + outPos] =
        //                [__543210]
        //                  [543210]
        (((((int) in[23 + inPos]) & 255)) & 63);
  }
}
