package com.github.edgar615.spring.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

  @Autowired
  private RedisTemplate<Object, Object> redisTemplate;

  public void add(User user) {
    redisTemplate.opsForValue().set(user.getUsername(), user, 100, TimeUnit.SECONDS);
    Map<String, Object> map = new HashMap<>();
    map.put("username", user.getUsername());
    map.put("password", user.getPassword());
    redisTemplate.opsForHash().putAll("h:" + user.getUsername(), map);
  }

  public void delete(String username) {
    redisTemplate.delete(username);
  }

  public User get(String username) {
    return (User) redisTemplate.opsForValue().get(username);
  }
}
