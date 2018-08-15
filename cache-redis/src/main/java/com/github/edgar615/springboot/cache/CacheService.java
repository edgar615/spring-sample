package com.github.edgar615.springboot.cache;

/**
 * Created by Edgar on 2018/6/20.
 *
 * @author Edgar  Date 2018/6/20
 */
public interface CacheService {

  String cache(int i);

  void clearCache(int i);

  String cache1(int i);

  void clearCache1(int i);

  String cache2(int i);

  void clearCache2(int i);
}
