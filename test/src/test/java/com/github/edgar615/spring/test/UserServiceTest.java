package com.github.edgar615.spring.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

public class UserServiceTest {

  @Mock
  private UserDao userDao;

  private UserServiceImpl userService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    userService = new UserServiceImpl();
    userService.setUserDao(userDao);
  }

  @Test
  public void testInsert() {
    when(userDao.insert(anyString())).thenReturn(1);
    int result = userService.insert(UUID.randomUUID().toString());
    verify(userDao, only()).insert(anyString());
    Assert.assertEquals(1, result);
  }

}