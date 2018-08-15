package com.github.edgar615.springboot.service;

/**
 * Created by Edgar on 2018/6/20.
 *
 * @author Edgar  Date 2018/6/20
 */
public interface CacheService {

  String method1(int i);

  String method2(int i);

  String method3(int i);

  String method4(int i);

  String level1(int id);

  void clearLevel1(int id);

  String level2(int id);

  void clearLevel2(int id);

  String level(int id);

  void clearLevel(int id);
}
