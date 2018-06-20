package com.github.edgar615.springboot;

import com.github.edgar615.springboot.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Autowired
  private CacheService cacheService;

  @RequestMapping(value = "/method1/{id}", method = RequestMethod.GET)
  public String method1(@PathVariable("id") int id) {
    return cacheService.method1(id);
  }

  @RequestMapping(value = "/method2/{id}", method = RequestMethod.GET)
  public String method2(@PathVariable("id") int id) {
    return cacheService.method2(id);
  }

  @RequestMapping(value = "/method3/{id}", method = RequestMethod.GET)
  public String method3(@PathVariable("id") int id) {
    return cacheService.method3(id);
  }

  @RequestMapping(value = "/method4/{id}", method = RequestMethod.GET)
  public String method4(@PathVariable("id") int id) {
    return cacheService.method4(id);
  }
}