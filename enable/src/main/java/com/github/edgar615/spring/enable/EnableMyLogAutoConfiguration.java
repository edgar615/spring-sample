package com.github.edgar615.spring.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(MyLogAutofigurationRegistrar.class)
public @interface EnableMyLogAutoConfiguration {
    String basePackage() default "";
   //设置代理类的实现，默认为使用JDK动态代理
    Class<? extends AbstractMyLogFactoryBean> implClass();// default MyLogFactoryBean.class;
}