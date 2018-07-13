package com.github.edgar615.spring.zipkin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "consul-sample", url = "localhost:9002")
public interface StoreClient {
    @RequestMapping(method = RequestMethod.GET, value = "/stores")
    Map<String, Object> getStores();
}