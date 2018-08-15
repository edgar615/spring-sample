package com.github.edgar615.springboot;

import com.google.common.collect.Lists;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.concurrent.TimeUnit;

@SpringBootApplication(scanBasePackages = {"com.github.edgar615.**"})
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableCaching
public class Application {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CacheManager cacheManager() {
    SimpleCacheManager cacheManager = new SimpleCacheManager();
//        cacheManager.setCaches();
    CaffeineCache cache1 = new CaffeineCache("level1", Caffeine.newBuilder().expireAfterWrite
            (10, TimeUnit.SECONDS).build());
    CaffeineCache cache2 = new CaffeineCache("level2", Caffeine.newBuilder().expireAfterWrite
            (60, TimeUnit.SECONDS).build());
    L2Cache l2Cache = new L2Cache("l2Cache", cache1, cache2, true);
    cacheManager.setCaches(Lists.newArrayList(cache1, cache2, l2Cache));
    return cacheManager;
  }

}