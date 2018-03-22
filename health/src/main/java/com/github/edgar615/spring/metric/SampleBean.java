package com.github.edgar615.spring.metric;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class SampleBean {

  private final Counter counter;

  public SampleBean(MeterRegistry registry) {
    this.counter = registry.counter("received.messages");
  }

  public void handleMessage(String message) {
    this.counter.increment();
    // handle message implementation
  }

}