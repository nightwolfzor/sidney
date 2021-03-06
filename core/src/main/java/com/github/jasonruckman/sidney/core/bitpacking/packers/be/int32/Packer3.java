package com.github.jasonruckman.sidney.core.bitpacking.packers.be.int32;

import com.github.jasonruckman.sidney.core.bitpacking.Int32BytePacker;

public final class Packer3 extends Int32BytePacker {

  public Packer3() {
    super(3);
  }

  public final void pack8Values(final int[] in, final int inPos, final byte[] out, final int outPos) {
    out[0 + outPos] = (byte) ((
        //             [765_____]
        //             [210]
        ((in[0 + inPos] & 7) << 5)
            | //             [___432__]
            //                [210]
            ((in[1 + inPos] & 7) << 2)
            | //             [______10]
            //                   [21_]
            ((in[2 + inPos] & 7) >>> 1)) & 255);
    out[1 + outPos] = (byte) ((
        //             [7_______]
        //           [__0]
        ((in[2 + inPos] & 7) << 7)
            | //             [_654____]
            //              [210]
            ((in[3 + inPos] & 7) << 4)
            | //             [____321_]
            //                 [210]
            ((in[4 + inPos] & 7) << 1)
            | //             [_______0]
            //                    [2__]
            ((in[5 + inPos] & 7) >>> 2)) & 255);
    out[2 + outPos] = (byte) ((
        //             [76______]
        //            [_10]
        ((in[5 + inPos] & 7) << 6)
            | //             [__543___]
            //               [210]
            ((in[6 + inPos] & 7) << 3)
            | //             [_____210]
            //                  [210]
            ((in[7 + inPos] & 7))) & 255);
  }

  public final void pack32Values(final int[] in, final int inPos, final byte[] out, final int outPos) {
    out[0 + outPos] = (byte) ((
        //             [765_____]
        //             [210]
        ((in[0 + inPos] & 7) << 5)
            | //             [___432__]
            //                [210]
            ((in[1 + inPos] & 7) << 2)
            | //             [______10]
            //                   [21_]
            ((in[2 + inPos] & 7) >>> 1)) & 255);
    out[1 + outPos] = (byte) ((
        //             [7_______]
        //           [__0]
        ((in[2 + inPos] & 7) << 7)
            | //             [_654____]
            //              [210]
            ((in[3 + inPos] & 7) << 4)
            | //             [____321_]
            //                 [210]
            ((in[4 + inPos] & 7) << 1)
            | //             [_______0]
            //                    [2__]
            ((in[5 + inPos] & 7) >>> 2)) & 255);
    out[2 + outPos] = (byte) ((
        //             [76______]
        //            [_10]
        ((in[5 + inPos] & 7) << 6)
            | //             [__543___]
            //               [210]
            ((in[6 + inPos] & 7) << 3)
            | //             [_____210]
            //                  [210]
            ((in[7 + inPos] & 7))) & 255);
    out[3 + outPos] = (byte) ((
        //             [765_____]
        //             [210]
        ((in[8 + inPos] & 7) << 5)
            | //             [___432__]
            //                [210]
            ((in[9 + inPos] & 7) << 2)
            | //             [______10]
            //                   [21_]
            ((in[10 + inPos] & 7) >>> 1)) & 255);
    out[4 + outPos] = (byte) ((
        //             [7_______]
        //           [__0]
        ((in[10 + inPos] & 7) << 7)
            | //             [_654____]
            //              [210]
            ((in[11 + inPos] & 7) << 4)
            | //             [____321_]
            //                 [210]
            ((in[12 + inPos] & 7) << 1)
            | //             [_______0]
            //                    [2__]
            ((in[13 + inPos] & 7) >>> 2)) & 255);
    out[5 + outPos] = (byte) ((
        //             [76______]
        //            [_10]
        ((in[13 + inPos] & 7) << 6)
            | //             [__543___]
            //               [210]
            ((in[14 + inPos] & 7) << 3)
            | //             [_____210]
            //                  [210]
            ((in[15 + inPos] & 7))) & 255);
    out[6 + outPos] = (byte) ((
        //             [765_____]
        //             [210]
        ((in[16 + inPos] & 7) << 5)
            | //             [___432__]
            //                [210]
            ((in[17 + inPos] & 7) << 2)
            | //             [______10]
            //                   [21_]
            ((in[18 + inPos] & 7) >>> 1)) & 255);
    out[7 + outPos] = (byte) ((
        //             [7_______]
        //           [__0]
        ((in[18 + inPos] & 7) << 7)
            | //             [_654____]
            //              [210]
            ((in[19 + inPos] & 7) << 4)
            | //             [____321_]
            //                 [210]
            ((in[20 + inPos] & 7) << 1)
            | //             [_______0]
            //                    [2__]
            ((in[21 + inPos] & 7) >>> 2)) & 255);
    out[8 + outPos] = (byte) ((
        //             [76______]
        //            [_10]
        ((in[21 + inPos] & 7) << 6)
            | //             [__543___]
            //               [210]
            ((in[22 + inPos] & 7) << 3)
            | //             [_____210]
            //                  [210]
            ((in[23 + inPos] & 7))) & 255);
    out[9 + outPos] = (byte) ((
        //             [765_____]
        //             [210]
        ((in[24 + inPos] & 7) << 5)
            | //             [___432__]
            //                [210]
            ((in[25 + inPos] & 7) << 2)
            | //             [______10]
            //                   [21_]
            ((in[26 + inPos] & 7) >>> 1)) & 255);
    out[10 + outPos] = (byte) ((
        //             [7_______]
        //           [__0]
        ((in[26 + inPos] & 7) << 7)
            | //             [_654____]
            //              [210]
            ((in[27 + inPos] & 7) << 4)
            | //             [____321_]
            //                 [210]
            ((in[28 + inPos] & 7) << 1)
            | //             [_______0]
            //                    [2__]
            ((in[29 + inPos] & 7) >>> 2)) & 255);
    out[11 + outPos] = (byte) ((
        //             [76______]
        //            [_10]
        ((in[29 + inPos] & 7) << 6)
            | //             [__543___]
            //               [210]
            ((in[30 + inPos] & 7) << 3)
            | //             [_____210]
            //                  [210]
            ((in[31 + inPos] & 7))) & 255);
  }

  public final void unpack8Values(final byte[] in, final int inPos, final int[] out, final int outPos) {
    out[0 + outPos] =
        //             [765_____]
        //             [210]
        (((((int) in[0 + inPos]) & 255) >>> 5) & 7);
    out[1 + outPos] =
        //             [___432__]
        //                [210]
        (((((int) in[0 + inPos]) & 255) >>> 2) & 7);
    out[2 + outPos] =
        //             [______10]
        //                   [21_]
        (((((int) in[0 + inPos]) & 255) << 1) & 7)
            | //             [7_______]
            //           [__0]
            (((((int) in[1 + inPos]) & 255) >>> 7) & 7);
    out[3 + outPos] =
        //             [_654____]
        //              [210]
        (((((int) in[1 + inPos]) & 255) >>> 4) & 7);
    out[4 + outPos] =
        //             [____321_]
        //                 [210]
        (((((int) in[1 + inPos]) & 255) >>> 1) & 7);
    out[5 + outPos] =
        //             [_______0]
        //                    [2__]
        (((((int) in[1 + inPos]) & 255) << 2) & 7)
            | //             [76______]
            //            [_10]
            (((((int) in[2 + inPos]) & 255) >>> 6) & 7);
    out[6 + outPos] =
        //             [__543___]
        //               [210]
        (((((int) in[2 + inPos]) & 255) >>> 3) & 7);
    out[7 + outPos] =
        //             [_____210]
        //                  [210]
        (((((int) in[2 + inPos]) & 255)) & 7);
  }

  public final void unpack32Values(final byte[] in, final int inPos, final int[] out, final int outPos) {
    out[0 + outPos] =
        //             [765_____]
        //             [210]
        (((((int) in[0 + inPos]) & 255) >>> 5) & 7);
    out[1 + outPos] =
        //             [___432__]
        //                [210]
        (((((int) in[0 + inPos]) & 255) >>> 2) & 7);
    out[2 + outPos] =
        //             [______10]
        //                   [21_]
        (((((int) in[0 + inPos]) & 255) << 1) & 7)
            | //             [7_______]
            //           [__0]
            (((((int) in[1 + inPos]) & 255) >>> 7) & 7);
    out[3 + outPos] =
        //             [_654____]
        //              [210]
        (((((int) in[1 + inPos]) & 255) >>> 4) & 7);
    out[4 + outPos] =
        //             [____321_]
        //                 [210]
        (((((int) in[1 + inPos]) & 255) >>> 1) & 7);
    out[5 + outPos] =
        //             [_______0]
        //                    [2__]
        (((((int) in[1 + inPos]) & 255) << 2) & 7)
            | //             [76______]
            //            [_10]
            (((((int) in[2 + inPos]) & 255) >>> 6) & 7);
    out[6 + outPos] =
        //             [__543___]
        //               [210]
        (((((int) in[2 + inPos]) & 255) >>> 3) & 7);
    out[7 + outPos] =
        //             [_____210]
        //                  [210]
        (((((int) in[2 + inPos]) & 255)) & 7);
    out[8 + outPos] =
        //             [765_____]
        //             [210]
        (((((int) in[3 + inPos]) & 255) >>> 5) & 7);
    out[9 + outPos] =
        //             [___432__]
        //                [210]
        (((((int) in[3 + inPos]) & 255) >>> 2) & 7);
    out[10 + outPos] =
        //             [______10]
        //                   [21_]
        (((((int) in[3 + inPos]) & 255) << 1) & 7)
            | //             [7_______]
            //           [__0]
            (((((int) in[4 + inPos]) & 255) >>> 7) & 7);
    out[11 + outPos] =
        //             [_654____]
        //              [210]
        (((((int) in[4 + inPos]) & 255) >>> 4) & 7);
    out[12 + outPos] =
        //             [____321_]
        //                 [210]
        (((((int) in[4 + inPos]) & 255) >>> 1) & 7);
    out[13 + outPos] =
        //             [_______0]
        //                    [2__]
        (((((int) in[4 + inPos]) & 255) << 2) & 7)
            | //             [76______]
            //            [_10]
            (((((int) in[5 + inPos]) & 255) >>> 6) & 7);
    out[14 + outPos] =
        //             [__543___]
        //               [210]
        (((((int) in[5 + inPos]) & 255) >>> 3) & 7);
    out[15 + outPos] =
        //             [_____210]
        //                  [210]
        (((((int) in[5 + inPos]) & 255)) & 7);
    out[16 + outPos] =
        //             [765_____]
        //             [210]
        (((((int) in[6 + inPos]) & 255) >>> 5) & 7);
    out[17 + outPos] =
        //             [___432__]
        //                [210]
        (((((int) in[6 + inPos]) & 255) >>> 2) & 7);
    out[18 + outPos] =
        //             [______10]
        //                   [21_]
        (((((int) in[6 + inPos]) & 255) << 1) & 7)
            | //             [7_______]
            //           [__0]
            (((((int) in[7 + inPos]) & 255) >>> 7) & 7);
    out[19 + outPos] =
        //             [_654____]
        //              [210]
        (((((int) in[7 + inPos]) & 255) >>> 4) & 7);
    out[20 + outPos] =
        //             [____321_]
        //                 [210]
        (((((int) in[7 + inPos]) & 255) >>> 1) & 7);
    out[21 + outPos] =
        //             [_______0]
        //                    [2__]
        (((((int) in[7 + inPos]) & 255) << 2) & 7)
            | //             [76______]
            //            [_10]
            (((((int) in[8 + inPos]) & 255) >>> 6) & 7);
    out[22 + outPos] =
        //             [__543___]
        //               [210]
        (((((int) in[8 + inPos]) & 255) >>> 3) & 7);
    out[23 + outPos] =
        //             [_____210]
        //                  [210]
        (((((int) in[8 + inPos]) & 255)) & 7);
    out[24 + outPos] =
        //             [765_____]
        //             [210]
        (((((int) in[9 + inPos]) & 255) >>> 5) & 7);
    out[25 + outPos] =
        //             [___432__]
        //                [210]
        (((((int) in[9 + inPos]) & 255) >>> 2) & 7);
    out[26 + outPos] =
        //             [______10]
        //                   [21_]
        (((((int) in[9 + inPos]) & 255) << 1) & 7)
            | //             [7_______]
            //           [__0]
            (((((int) in[10 + inPos]) & 255) >>> 7) & 7);
    out[27 + outPos] =
        //             [_654____]
        //              [210]
        (((((int) in[10 + inPos]) & 255) >>> 4) & 7);
    out[28 + outPos] =
        //             [____321_]
        //                 [210]
        (((((int) in[10 + inPos]) & 255) >>> 1) & 7);
    out[29 + outPos] =
        //             [_______0]
        //                    [2__]
        (((((int) in[10 + inPos]) & 255) << 2) & 7)
            | //             [76______]
            //            [_10]
            (((((int) in[11 + inPos]) & 255) >>> 6) & 7);
    out[30 + outPos] =
        //             [__543___]
        //               [210]
        (((((int) in[11 + inPos]) & 255) >>> 3) & 7);
    out[31 + outPos] =
        //             [_____210]
        //                  [210]
        (((((int) in[11 + inPos]) & 255)) & 7);
  }
}
