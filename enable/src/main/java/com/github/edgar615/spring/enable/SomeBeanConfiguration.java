package com.github.edgar615.spring.enable;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

//@Configuration 使用了这个注解就会自动创建，但是官方例子却有这个注解，还未搞清楚原因
public class SomeBeanConfiguration {

  @Bean
  public String aBean1() {
    return "aBean1";
  }

  @Bean
  @ConditionalOnProperty(name = "aBean2.enabled", matchIfMissing = true)
  public String aBean2() {
    return "aBean2";
  }
}