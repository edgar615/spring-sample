package com.github.edgar615.springboot.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

  @Autowired
  private CacheService cacheService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String cache(@PathVariable("id") int id) {
    cacheService.cache(id);
    return id + "";
  }

  @RequestMapping(value = "/{id}/clear", method = RequestMethod.GET)
  public String clearLevel(@PathVariable("id") int id) {
    cacheService.clearCache(id);
    return id + "";
  }

  @RequestMapping(value = "/cache1/{id}", method = RequestMethod.GET)
  public String cache1(@PathVariable("id") int id) {
    cacheService.cache1(id);
    return id + "";
  }

  @RequestMapping(value = "/cache1/{id}/clear", method = RequestMethod.GET)
  public String clear1(@PathVariable("id") int id) {
    cacheService.clearCache1(id);
    return id + "";
  }

  @RequestMapping(value = "/cache2/{id}", method = RequestMethod.GET)
  public String cache2(@PathVariable("id") int id) {
    cacheService.cache2(id);
    return id + "";
  }

  @RequestMapping(value = "/cache2/{id}/clear", method = RequestMethod.GET)
  public String clear2(@PathVariable("id") int id) {
    cacheService.clearCache2(id);
    return id + "";
  }
}