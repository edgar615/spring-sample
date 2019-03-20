package com.github.edgar615.spring.randomvalue;

import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {


    @Value("${my.secret.password}")
    private String password;

    @Value("${my.secret.intValue}")
    private Integer intValue;

    @Value("${my.secret.intValueRange}")
    private Integer intValueRange;

    @Value("${my.secret.longValue}")
    private Long longValue;

    @Value("${my.secret.longValueRange}")
    private Long longValueRange;

    @Value("${my.secret.uuid}")
    private UUID uuid;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    private void init(){
        System.out.println("Configure Random Property Values using Spring Boot");
        System.out.println("password: " + password);
        System.out.println("intValue: " + intValue);
        System.out.println("intValueRange: " + intValueRange);
        System.out.println("longValue: " + longValue);
        System.out.println("longValueRange: " + longValueRange);
        System.out.println("uuid: " + uuid);
    }

}
