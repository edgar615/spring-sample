package com.github.edgar615.springboot.cache;

import org.springframework.aop.framework.AopContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Edgar on 2018/6/20.
 *
 * @author Edgar  Date 2018/6/20
 */
@Service
public class CacheServiceImpl implements CacheService {

  @Override
  @Cacheable(cacheNames = "redisCache", key = "#p0")
  public String cache(int i) {
    System.out.println("cache");
    return i + "";
  }

  @Override
  @CacheEvict(cacheNames = "redisCache", key = "#p0")
  public void clearCache(int i) {
    System.out.println("clearCache");
  }

  @Override
  @Cacheable(cacheNames = "cache1", key = "#p0")
  public String cache1(int i) {
    System.out.println("cache1");
    return i + "";
  }

  @Override
  @CacheEvict(cacheNames = "cache1", key = "#p0")
  public void clearCache1(int i) {
    System.out.println("clearCache1");
  }

  @Override
  @Cacheable(cacheNames = "cache2", key = "#p0")
  public String cache2(int i) {
    System.out.println("cache2");
    return i + "";
  }

  @Override
  @CacheEvict(cacheNames = "cache2", key = "#p0")
  public void clearCache2(int i) {
    System.out.println("clearCache2");
  }
}
