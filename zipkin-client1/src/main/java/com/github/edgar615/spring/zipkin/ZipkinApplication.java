package com.github.edgar615.spring.zipkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
@EnableFeignClients
public class ZipkinApplication {

    @Autowired
    private StoreClient storeClient;

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }

    @RequestMapping("/")
    public Map<String, Object> home() {
        return storeClient.getStores();
    }

}