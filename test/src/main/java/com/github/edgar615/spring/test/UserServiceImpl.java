package com.github.edgar615.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Edgar on 2018/8/20.
 *
 * @author Edgar  Date 2018/8/20
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public int insert(String username) {
    return userDao.insert(username);
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}
