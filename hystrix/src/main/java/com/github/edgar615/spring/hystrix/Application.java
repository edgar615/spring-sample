package com.github.edgar615.spring.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(scanBasePackages = {"com.github.edgar615.**"})
@RestController
@EnableCircuitBreaker
@EnableHystrixDashboard
public class Application {

    @Autowired
    private StoreIntegration storeIntegration;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public Map<String, Object> home() {
        return storeIntegration.getStores(new HashMap<>());
    }

}