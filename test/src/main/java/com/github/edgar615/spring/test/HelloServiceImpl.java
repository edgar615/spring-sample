package com.github.edgar615.spring.test;

import org.springframework.stereotype.Service;

/**
 * Created by Edgar on 2018/6/20.
 *
 * @author Edgar  Date 2018/6/20
 */
@Service
public class HelloServiceImpl implements HelloService {
  @Override
  public String method1(int i) {
    System.out.println("method1");
    return i + "";
  }

}
