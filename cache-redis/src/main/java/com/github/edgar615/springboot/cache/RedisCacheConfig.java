package com.github.edgar615.springboot.cache;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created by Edgar on 2018/8/15.
 *
 * @author Edgar  Date 2018/8/15
 */
@Configuration
@ConfigurationProperties(prefix = "spring.cache.redis")
public class RedisCacheConfig {
  private Map<String, RedisCacheSpec> spec;

  public Map<String, RedisCacheSpec> getSpec() {
    return spec;
  }

  public void setSpec(
          Map<String, RedisCacheSpec> spec) {
    this.spec = spec;
  }
}
