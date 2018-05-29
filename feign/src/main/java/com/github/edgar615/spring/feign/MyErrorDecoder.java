package com.github.edgar615.spring.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static feign.FeignException.errorStatus;

@Configuration
public class MyErrorDecoder implements ErrorDecoder {

  @Override
  public Exception decode(String methodKey, Response response) {
    return new HystrixBadRequestException("xxxxxx");
//    System.out.println(methodKey);
//    System.out.println(response);
//    return errorStatus(methodKey, response);
  }
}