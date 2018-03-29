package com.github.edgar615.spring.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication(scanBasePackages = {"com.github.edgar615.**"})
@RestController
@EnableFeignClients
@EnableDiscoveryClient
public class Application {

    @Autowired
    private StoreClient storeClient;

    @Autowired
    private HystrixClient hystrixClient;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public Map<String, Object> home() {
        return storeClient.getStores();
    }

  @RequestMapping("/hystrix")
  public Map<String, Object> hystrix() {
    return hystrixClient.getStores();
  }

//  @Bean
//  MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
//    return registry -> registry.config().commonTags("region", "us-east-1");
//  }
}