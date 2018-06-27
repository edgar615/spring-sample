package com.github.edgar615.spring.apiprefix;

import static springfox.documentation.builders.PathSelectors.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/11.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
  private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerConfig.class);

  @Bean
  public Docket api() {
    List parameters = new ArrayList<>();
    parameters.add(new ParameterBuilder()
                           .name("token")
                           .description("token")
                           .modelRef(new ModelRef("string"))
                           .parameterType("query")
                           .required(false)
                           .build());
    return new Docket(DocumentationType.SWAGGER_2)
            .globalOperationParameters(parameters)
            .groupName("api")
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(regex("^((?!/error).)*$"))
            .build()
            .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("API")
            .termsOfServiceUrl("http://springfox.io")
            .contact("springfox")
            .license("Apache License Version 2.0")
            .version("2.0")
            .build();
  }
}