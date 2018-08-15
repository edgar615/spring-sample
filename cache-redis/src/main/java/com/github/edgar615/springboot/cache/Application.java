package com.github.edgar615.springboot.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(scanBasePackages = {"com.github.edgar615.**"})
@Configuration
@EnableCaching
public class Application {

  public static void main(String[] args) throws Exception {
    ApplicationContext context = SpringApplication.run(Application.class, args);
    CacheManager cacheManager = context.getBean(CacheManager.class);
    System.out.println(cacheManager);
    System.out.println(cacheManager.getCacheNames());
  }

//  @Bean
//  public CacheManager customCacheManager(RedisConnectionFactory redisConnectionFactory) {
//    RedisCacheManager redisCacheManager = new RedisCacheManager(RedisCacheWriter
//
// .nonLockingRedisCacheWriter(
//
// redisConnectionFactory),
//                                                                RedisCacheConfiguration
//                                                                        .defaultCacheConfig(),
//                                                                false, "redisCache");
//    redisCacheManager.initializeCaches();
//    CompositeCacheManager compositeCacheManager
//            = new CompositeCacheManager(new SimpleCacheManager(),
//                                        redisCacheManager);
//    compositeCacheManager.setFallbackToNoOpCache(true);
//    compositeCacheManager.afterPropertiesSet();
//    return compositeCacheManager;
//  }

  //自定义过期时间
  @Bean
  public CacheManager customCacheManager(RedisConnectionFactory redisConnectionFactory,
                                         RedisCacheConfig redisCacheConfig) {
    System.out.println(redisCacheConfig.getSpec());
    Map<String, RedisCacheConfiguration> initialCacheConfigurations = new HashMap<>();
    for (String cacheName : redisCacheConfig.getSpec().keySet()) {
      RedisCacheConfiguration configuration = redisCacheConfiguration(redisCacheConfig.getSpec
              ().get(cacheName));
      initialCacheConfigurations.put(cacheName, configuration);
    }
    RedisCacheManager redisCacheManager = new RedisCacheManager(RedisCacheWriter
                                                                        .nonLockingRedisCacheWriter(
                                                                                redisConnectionFactory),
                                                                RedisCacheConfiguration
                                                                        .defaultCacheConfig(),
                                                                initialCacheConfigurations,
                                                                false);
    redisCacheManager.initializeCaches();
    CompositeCacheManager compositeCacheManager
            = new CompositeCacheManager(new SimpleCacheManager(),
                                        redisCacheManager);
    compositeCacheManager.setFallbackToNoOpCache(true);
    compositeCacheManager.afterPropertiesSet();
    return compositeCacheManager;
  }

  RedisCacheConfiguration redisCacheConfiguration(RedisCacheSpec spec) {
    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
    if (spec.getTimeToLive() > 0) {
      config = config.entryTtl(Duration.ofMillis(spec.getTimeToLive()));
    }
    if (spec.getKeyPrefix() != null) {
      config = config.prefixKeysWith(spec.getKeyPrefix());
    }
    if (!spec.isCacheNullValues()) {
      config = config.disableCachingNullValues();
    }
    if (!spec.isUseKeyPrefix()) {
      config = config.disableKeyPrefix();
    }
    return config;
  }

}