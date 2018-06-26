package com.github.edgar615.spring.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyEnableAutoConfig implements ImportSelector {
  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[]{"com.github.edgar615.spring.enable.Role",
            "com.github.edgar615.spring.enable.User"};
  }
}