package com.github.edgar615.spring.consul;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication(scanBasePackages = {"com.github.edgar615.**"})
@RestController
public class Application {

    @Value("${server.port}")
    private int port;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    @RequestMapping("/stores")
    public Map<String, Object> stores() {
        return ImmutableMap.of("foo", port);
    }


//  @Bean
//  MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
//    return registry -> registry.config().commonTags("region", "us-east-1");
//  }
}