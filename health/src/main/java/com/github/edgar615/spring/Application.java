package com.github.edgar615.spring;

import io.micrometer.core.annotation.Timed;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.github.edgar615.**"})
@RestController
//@Timed
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Timed("test.index")
  @RequestMapping("/")
  public String home() {
    return "Hello world";
  }

//  @Bean
//  MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
//    return registry -> registry.config().commonTags("region", "us-east-1");
//  }
}