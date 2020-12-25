package com.github.edgar615.spring.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  Logger logger = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @GetMapping("/")
  public String hello() {
    logger.trace("A TRACE Message");
    logger.debug("A DEBUG Message");
    logger.info("An INFO Message");
    logger.warn("A WARN Message");
    logger.error("An ERROR Message");
    return "hello";

  }

  @GetMapping(value = "/logLevel/{logLevel}")
  public String changeLogLevel(@PathVariable("logLevel") String logLevel) {
    try {
      LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
      Logger logger = loggerContext.getLogger("com.github.edgar615");
      ((ch.qos.logback.classic.Logger) logger).setLevel(Level.valueOf(logLevel));
    } catch (Exception e) {
      logger.error("changeLogLevel error", e);
      return "fail";
    }
    return "success";
  }
}

