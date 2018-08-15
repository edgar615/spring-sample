package com.github.edgar615.springboot;

import com.github.edgar615.springboot.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/l2")
public class L2CacheController {

  @Autowired
  private CacheService cacheService;

  @RequestMapping(value = "/level1/{id}", method = RequestMethod.GET)
  public String level1(@PathVariable("id") int id) {
    return cacheService.level1(id);
  }

  @RequestMapping(value = "/level2/{id}", method = RequestMethod.GET)
  public String level2(@PathVariable("id") int id) {
    return cacheService.level2(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String level(@PathVariable("id") int id) {
    return cacheService.level(id);
  }

  @RequestMapping(value = "/level1/{id}/clear", method = RequestMethod.GET)
  public String clearLevel1(@PathVariable("id") int id) {
     cacheService.clearLevel1(id);
    return id + "";
  }
  @RequestMapping(value = "/level2/{id}/clear", method = RequestMethod.GET)
  public String clearLevel2(@PathVariable("id") int id) {
    cacheService.clearLevel1(id);
    return id + "";
  }
  @RequestMapping(value = "/{id}/clear", method = RequestMethod.GET)
  public String clearLevel(@PathVariable("id") int id) {
    cacheService.clearLevel(id);
    return id + "";
  }

}