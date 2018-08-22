package com.github.edgar615.spring.ds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloController {

  @Autowired
  private FirstService firstService;

  @Autowired
  private SecondService secondService;

  @Autowired
  private DynamicService dynamicService;

  private final AtomicInteger seq = new AtomicInteger();

  @RequestMapping(value = "/first", method = RequestMethod.GET)
  public String first() {
    return firstService.count() + "";
  }

  @RequestMapping(value = "/second", method = RequestMethod.GET)
  public String second() {
    return secondService.count() + "";
  }

  @RequestMapping(value = "/dynamic", method = RequestMethod.GET)
  public String dynamic() {
    int num = seq.incrementAndGet();
    if (num % 2 == 0) {
      CustomerContextHolder.setCustomerType(CustomerType.first);
    } else {
      CustomerContextHolder.setCustomerType(CustomerType.second);
    }
    return dynamicService.count() + "";
  }
}