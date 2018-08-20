package com.github.edgar615.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

  @Autowired
  private HelloService helloService;

  @RequestMapping(value = "/method1/{id}", method = RequestMethod.GET)
  public Map<String, Object> method1(@PathVariable("id") int id) {
    Map<String, Object> map = new HashMap<>();
    String result = helloService.method1(id);
    map.put("result", result);
    return map;
  }
}