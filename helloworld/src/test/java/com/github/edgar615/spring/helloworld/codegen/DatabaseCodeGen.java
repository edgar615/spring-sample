package com.github.edgar615.spring.helloworld.codegen;

import com.github.edgar615.jdbc.codegen.gen.CodegenOptions;
import com.github.edgar615.jdbc.codegen.gen.Generator;

/**
 * Created by Administrator on 2015/6/9.
 */
public class DatabaseCodeGen {

  public static void main(String[] args) throws Exception {
    CodegenOptions options = new CodegenOptions().setUsername("root")
            .setPassword("123456")
            .addGenTable("device")
            .setIgnoreColumnsStr("created_on,updated_on")
            .setGenRule(true)
            .setJdbcUrl(
                    "jdbc:mysql://test.ihorn.com.cn:3306/device")
            .setSrcFolderPath("helloworld/src/main/java")
            .setDomainPackage("com.github.edgar615.spring.helloworld.domain");

    new Generator(options).generate();

  }

}