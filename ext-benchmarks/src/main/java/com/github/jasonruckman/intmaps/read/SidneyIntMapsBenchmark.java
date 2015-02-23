package com.github.jasonruckman.intmaps.read;

import com.github.jasonruckman.intmaps.IntMapsBenchmark;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SidneyIntMapsBenchmark extends IntMapsBenchmark {
  @Override
  @Benchmark
  public List<HashMap<Integer, Integer>> readSidney() {
    return doReadSidney();
  }
}
