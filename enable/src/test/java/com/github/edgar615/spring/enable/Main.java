package com.github.edgar615.spring.enable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {"com.github.edgar615.**"})
@Configuration
@EnableBean
@EnableCustomBean
@EnableSomeBeans
//@EnableAutoConfiguration
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        System.out.println(context.getBean(User.class));
        System.out.println(context.getBean(Role.class));
        System.out.println(context.getBean(CustomBean.class));
        System.out.println(context.getBean("custom"));

        System.out.println(context.getBean("aBean1"));
//        System.out.println(context.getBean("aBean2"));
    }
}