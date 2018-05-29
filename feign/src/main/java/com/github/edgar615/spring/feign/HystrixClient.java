package com.github.edgar615.spring.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "consul-sample", fallback = HystrixClientFallback.class)
public interface HystrixClient {
    @RequestMapping(method = RequestMethod.GET, value = "/stores")
    Map<String, Object> getStores();

//    @RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
//    Store update(@PathVariable("storeId") Long storeId, Store store);
}