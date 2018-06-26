package com.github.edgar615.spring.enable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by Edgar on 2018/6/26.
 *
 * @author Edgar  Date 2018/6/26
 */
public class CustomEnableAutoConfig implements ImportBeanDefinitionRegistrar {
  @Override
  public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                      BeanDefinitionRegistry registry) {
    registry.registerBeanDefinition("custom", createBeanDefinition(CustomBean.class));
  }

  private GenericBeanDefinition createBeanDefinition(Class<?> beanClass) {
    GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
    beanDefinition.setBeanClass(beanClass);
    beanDefinition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_NO);
    return beanDefinition;
  }
}
