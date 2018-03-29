package com.github.edgar615.spring.feign;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HystrixClientFallback implements HystrixClient  {

    @Override
    public Map<String, Object> getStores() {
        return ImmutableMap.of("foo", "bar");
    }
}