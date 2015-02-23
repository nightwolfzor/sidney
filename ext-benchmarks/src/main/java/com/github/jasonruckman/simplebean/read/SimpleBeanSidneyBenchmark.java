package com.github.jasonruckman.simplebean.read;

import com.github.jasonruckman.model.SimpleBean;
import com.github.jasonruckman.simplebean.SimpleBeanBenchmark;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.List;

public class SimpleBeanSidneyBenchmark extends SimpleBeanBenchmark {
  @Override
  @Benchmark
  public List<SimpleBean> readSidney() {
    return doReadSidney();
  }
}
