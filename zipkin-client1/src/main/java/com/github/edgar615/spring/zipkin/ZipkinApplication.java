package com.github.edgar615.spring.zipkin;

import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zipkin2.Span;

import java.util.Map;

@SpringBootApplication
@RestController
@EnableFeignClients
@EnableDiscoveryClient
public class ZipkinApplication {

    @Autowired
    private StoreClient storeClient;

//    @Autowired
//    private Tracer tracer;

    private static final Logger LOGGER = LoggerFactory.getLogger(ZipkinApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }

    @RequestMapping("/")
    public Map<String, Object> home() {
        Map<String, Object>  data =  storeClient.getStores();
//        System.out.println(tracer.currentSpan().context().spanId());
        LOGGER.info("xxxx");
        return data;
    }

    //手动埋点
    @RequestMapping("/trace")
    public Map<String, Object> trace() {
        Map<String, Object>  data =  storeClient.getStores();
        // 创建一个 span
//        final Span span = tracer.createSpan("3rd_service");
//        try {
//            span.tag(Span.SPAN_LOCAL_COMPONENT_TAG_NAME, "3rd_service");
//            span.logEvent(Span.CLIENT_SEND);
//            // 这里时调用第三方 API 的代码
//        } finally {
//            span.tag(Span.SPAN_PEER_SERVICE_TAG_NAME, "3rd_service");
//            span.logEvent(Span.CLIENT_RECV);
//            tracer.close(span);
//        }
        return data;
    }

}