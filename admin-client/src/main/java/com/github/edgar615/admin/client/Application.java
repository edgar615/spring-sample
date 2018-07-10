package com.github.edgar615.admin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.github.edgar615.**"})
@RestController
//@EnableDiscoveryClient
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @RequestMapping("/")
  public String home() {
    return "Hello world";
  }

//  @Configuration
//  public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//      http.authorizeRequests().anyRequest().permitAll()
//              .and().csrf().disable();
//    }
//  }
}