package com.github.edgar615.spring.helloworld.service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import com.github.edgar615.spring.helloworld.domain.Device;
import com.github.edgar615.spring.helloworld.domain.DeviceRule;
import com.github.edgar615.util.db.Jdbc;
import com.github.edgar615.util.validation.Rule;
import com.github.edgar615.util.validation.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by Edgar on 2017/10/17.
 *
 * @author Edgar  Date 2017/10/17
 */
@Service
public class DeviceServiceImpl implements DeviceService {

  private final Multimap<String, Rule> insertRules = ArrayListMultimap.create();

  private final Multimap<String, Rule> updateRules = ArrayListMultimap.create();

  @Autowired
  private Jdbc jdbc;

  @PostConstruct
  public void initRule() {
    insertRules.put("barcode", Rule.required());
    insertRules.put("type", Rule.prohibited());
    insertRules.putAll(DeviceRule.maxLengthRule());

    updateRules.put("barcode", Rule.prohibited());
    updateRules.put("type", Rule.prohibited());
    updateRules.putAll(DeviceRule.maxLengthRule());
  }


  @Override
  @Transactional//开始事务
  public void insert(Device device) {
    Validations.validate(device.toMap(), insertRules);
    jdbc.insertAndGeneratedKey(device);
    //其他数据库操作
//    jdbc.insertAndGeneratedKey();
  }
}
