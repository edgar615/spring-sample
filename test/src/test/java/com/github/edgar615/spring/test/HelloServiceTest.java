package com.github.edgar615.spring.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Edgar on 2018/8/20.
 *
 * @author Edgar  Date 2018/8/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {

  @Autowired
  private HelloService helloService;

  @Test
  @Transactional
//  @Rollback(false)
  public void test() {
    String result = helloService.method1(1);
    Assert.assertNotNull(result);
  }

}
