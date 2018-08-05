package com.github.edgar615.spring.gateway.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @RequestMapping(value = "/v1", produces = "text/plain;charset=UTF-8")
  public String v1() {

    return "v1";

  }

  @RequestMapping(value = "/v2", produces = "text/plain;charset=UTF-8")
  public String v2() {
    return "v2";

  }
}

