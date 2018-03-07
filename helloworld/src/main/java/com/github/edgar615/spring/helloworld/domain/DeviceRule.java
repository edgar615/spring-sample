package com.github.edgar615.spring.helloworld.domain;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.github.edgar615.util.validation.Rule;

/**
* This class is generated by Jdbc code generator.
*
* Table : device
*
* @author Jdbc Code Generator Date 2018-03-07
*/
public class DeviceRule {

    /**
    * 根据数据库生成的最长长度校验
    *
    * @return Multimap<String, Rule>
    */
    public static Multimap<String, Rule> maxLengthRule() {
        Multimap<String, Rule> rules = ArrayListMultimap.create();
         rules.put("username",  Rule.maxLength(60));
         rules.put("name",  Rule.maxLength(64));
         rules.put("barcode",  Rule.maxLength(19));
         rules.put("macAddress",  Rule.maxLength(12));
         rules.put("encryptKey",  Rule.maxLength(16));
         rules.put("location",  Rule.maxLength(16));
         rules.put("manufacturerName",  Rule.maxLength(64));
         rules.put("description",  Rule.maxLength(1024));
         rules.put("productVersion",  Rule.maxLength(32));
         rules.put("zigbeeVersion",  Rule.maxLength(32));
         rules.put("zigbeeMacAddress",  Rule.maxLength(16));
         rules.put("mainFeature",  Rule.maxLength(2));
         rules.put("wifiVersion",  Rule.maxLength(32));
         rules.put("serverAddress",  Rule.maxLength(128));
         rules.put("publicIp",  Rule.maxLength(32));
         rules.put("ext",  Rule.maxLength(1024));
         return rules;
    }

    /**
    * 根据数据库生成的必填项校验。
    * 在实际接口开发中，有些必填项是没有的，例如自动生成的主键开始会设置为null
    *
    * @return Multimap<String, Rule>
    */
    public static Multimap<String, Rule> requiredRule() {
        Multimap<String, Rule> rules = ArrayListMultimap.create();
        
        rules.put("deviceId", Rule.required());
        rules.put("companyCode", Rule.required());
        rules.put("encryptKey", Rule.required());
        return rules;
    }

   /* START Do not remove/edit this line. CodeGenerator will preserve any code between start and end tags.*/
	/* END Do not remove/edit this line. CodeGenerator will preserve any code between start and end tags.*/
}