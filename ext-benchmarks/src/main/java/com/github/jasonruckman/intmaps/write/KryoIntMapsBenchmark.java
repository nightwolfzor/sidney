package com.github.jasonruckman.intmaps.write;

import com.github.jasonruckman.intmaps.IntMapsBenchmark;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.List;
import java.util.Map;

public class KryoIntMapsBenchmark extends IntMapsBenchmark {
  @Override
  @Benchmark
  public byte[] writeKryo() {
    return doWriteKryo();
  }
}
