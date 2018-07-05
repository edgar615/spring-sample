package com.github.edgar615.spring.redis;

public interface RedisService {
  void add(User user);

  void delete(String username);

  User get(String username);
}
