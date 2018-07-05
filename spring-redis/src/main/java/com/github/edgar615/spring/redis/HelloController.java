package com.github.edgar615.spring.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class HelloController {

  @Autowired
  private RedisService redisService;

  @PostMapping
  public String add(@RequestBody User user) {
    redisService.add(user);
    return "0";
  }

  @DeleteMapping("/{username}")
  public String delete(@PathVariable("username") String username) {
     redisService.delete(username);
     return "0";
  }

  @GetMapping("/{username}")
  public User GET(@PathVariable("username") String username) {
    return redisService.get(username);
  }

}