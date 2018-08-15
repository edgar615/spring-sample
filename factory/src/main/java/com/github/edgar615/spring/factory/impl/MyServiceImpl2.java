package com.github.edgar615.spring.factory.impl;

import com.github.edgar615.spring.factory.MyService;

public class MyServiceImpl2 implements MyService {
  @Override
  public void handle() {
    System.out.println("2");
  }
}
