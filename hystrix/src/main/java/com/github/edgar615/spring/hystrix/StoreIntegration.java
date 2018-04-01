package com.github.edgar615.spring.hystrix;

import com.google.common.collect.ImmutableMap;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StoreIntegration {

    @HystrixCommand(fallbackMethod = "defaultStores")
    public Map<String, Object> getStores(Map<String, Object> parameters) {
//        return ImmutableMap.of("foo", "bar");
        throw new RuntimeException("ops");
    }

    public Map<String, Object> defaultStores(Map<String, Object> parameters) {
        return ImmutableMap.of("foo", "error");
    }
}