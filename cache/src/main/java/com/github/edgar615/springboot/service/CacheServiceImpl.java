package com.github.edgar615.springboot.service;

import org.springframework.aop.framework.AopContext;
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
  public String method1(int i) {
    System.out.println("method1");
    return i + "";
  }

  @Override
  @Cacheable(cacheNames = "testCache", key = "#p0")
  public String method2(int i) {
    System.out.println("method2");
    return i + "";
  }

  @Override
  public String method3(int i) {
    System.out.println("method3");
    return method2(i);
  }

  @Override
  public String method4(int i) {
    System.out.println("method4");
    return getProxyManager().method2(i);
  }

  private CacheService getProxyManager() {
    return (CacheService) AopContext.currentProxy();
  }
}
