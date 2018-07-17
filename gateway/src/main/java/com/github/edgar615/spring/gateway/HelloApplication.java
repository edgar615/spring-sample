package com.github.edgar615.spring.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloApplication {
//  @Bean
//  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//    return builder.routes().route(r -> r.path("/baidu")
//            .filters(f ->
//                    f.addResponseHeader("X-AnotherHeader", "baz"))
//            .uri("http://baidu.com:80/"))
//            .route(r -> r.path("/api")
//                    .filters(f ->
//                            f.addResponseHeader("X-AnotherHeader", "baz"))
//                    .uri("lb://consul-sample")).build();
//  }
//
//  @Bean
//  public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient,
//                                                                      DiscoveryLocatorProperties properties) {
//    return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
//  }

  public static void main(String[] args) {
    SpringApplication.run(HelloApplication.class, args);
  }
}

