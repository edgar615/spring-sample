package com.github.edgar615.spring.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

//  @Bean
//  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//    return builder.routes()
//            .route(r -> r.path("/webp")
//                    .filters(f ->
//                                     f.addResponseHeader("X-AnotherHeader", "baz"))
//                    .uri("http://httpbin.org:80")
//            )
//            .build();
//  }
//
//  @Bean
//  public RouterFunction<ServerResponse> testFunRouterFunction() {
//    RouterFunction<ServerResponse> route = RouterFunctions.route(
//            RequestPredicates.path("/testfun"),
//            request -> ServerResponse.ok().body(BodyInserters.fromObject("hello")));
//    return route;
//  }
}

