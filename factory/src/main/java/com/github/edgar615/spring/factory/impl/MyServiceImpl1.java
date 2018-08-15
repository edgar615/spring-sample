package com.github.edgar615.spring.factory.impl;

import com.github.edgar615.spring.factory.MyService;

public class MyServiceImpl1 implements MyService {
  @Override
  public void handle() {
    System.out.println("1");
  }
}
