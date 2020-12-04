package com.github.edgar615.spring.enable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
//@EnableBean
//@EnableCustomBean
//@EnableSomeBeans
//@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//        System.out.println(context.getBean(User.class));
//        System.out.println(context.getBean(Role.class));
//        System.out.println(context.getBean(CustomBean.class));
//        System.out.println(context.getBean("custom"));
//
        System.out.println(context.getBean("aBean1"));
        System.out.println(context.getBean("aBean2"));
    }
}