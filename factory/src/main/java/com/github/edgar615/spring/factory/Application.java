package com.github.edgar615.spring.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.github.edgar615.**"})
@Configuration
public class Application {

  public static void main(String[] args) throws Exception {
    List<MyService> classes = SpringFactoriesLoader.loadFactories(MyService.class, Application.class.getClassLoader());
    System.out.println(classes);
    ApplicationContext context = SpringApplication.run(Application.class, args);
    System.out.println(context.getBean(MyService.class));
  }

}