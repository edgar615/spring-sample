package com.github.edgar615.spring.commandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCommandlineApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCommandlineApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
       System.out.println(" ***** Greetings from Spring  ***** ");
    }
}
