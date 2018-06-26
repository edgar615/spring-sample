package com.github.edgar615.spring.helloworld.domain;

import java.util.List;
import java.util.Map;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.github.edgar615.util.db.Persistent;

/**
* This class is generated by Jdbc code generator.
*
* Table : device
* remarks: 设备表
*
* @author Jdbc Code Generator Date 2018-03-07
*/
public class Device implements Persistent<Integer> {

    private static final long serialVersionUID = 1L;
    
    /**
    * Column : device_id
    * remarks: 
    * default: 
    * isNullable: false
    * isAutoInc: true
    * isPrimary: true
    * type: 4
    * size: 10
    */
    private Integer deviceId;
    
    /**
    * Column : user_id
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 4
    * size: 10
    */
    private Integer userId;
    
    /**
    * Column : parent_id
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 4
    * size: 10
    */
    private Integer parentId;
    
    /**
    * Column : username
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 12
    * size: 60
    */
    private String username;
    
    /**
    * Column : is_virtual
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: -7
    * size: 1
    */
    private Boolean isVirtual;
    
    /**
    * Column : company_code
    * remarks: 
    * default: 
    * isNullable: false
    * isAutoInc: false
    * isPrimary: false
    * type: 4
    * size: 10
    */
    private Integer companyCode;
    
    /**
    * Column : name
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 12
    * size: 64
    */
    private String name;
    
    /**
    * Column : barcode
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 1
    * size: 19
    */
    private String barcode;
    
    /**
    * Column : mac_address
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 1
    * size: 12
    */
    private String macAddress;
    
    /**
    * Column : encrypt_key
    * remarks: 
    * default: 
    * isNullable: false
    * isAutoInc: false
    * isPrimary: false
    * type: 1
    * size: 16
    */
    private String encryptKey;
    
    /**
    * Column : type
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 4
    * size: 10
    */
    private Integer type;
    
    /**
    * Column : state
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 4
    * size: 10
    */
    private Integer state;
    
    /**
    * Column : location
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 12
    * size: 16
    */
    private String location;
    
    /**
    * Column : device_code
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 4
    * size: 10
    */
    private Integer deviceCode;
    
    /**
    * Column : manufacturer_code
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 4
    * size: 10
    */
    private Integer manufacturerCode;
    
    /**
    * Column : manufacturer_name
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 12
    * size: 64
    */
    private String manufacturerName;
    
    /**
    * Column : description
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 12
    * size: 1024
    */
    private String description;
    
    /**
    * Column : product_version
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 12
    * size: 32
    */
    private String productVersion;
    
    /**
    * Column : zigbee_version
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 12
    * size: 32
    */
    private String zigbeeVersion;
    
    /**
    * Column : zigbee_mac_address
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 1
    * size: 16
    */
    private String zigbeeMacAddress;
    
    /**
    * Column : main_feature
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 1
    * size: 2
    */
    private String mainFeature;
    
    /**
    * Column : wifi_firm
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 4
    * size: 10
    */
    private Integer wifiFirm;
    
    /**
    * Column : wifi_version
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 12
    * size: 32
    */
    private String wifiVersion;
    
    /**
    * Column : server_address
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 12
    * size: 128
    */
    private String serverAddress;
    
    /**
    * Column : public_ip
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 1
    * size: 32
    */
    private String publicIp;
    
    /**
    * Column : is_online
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: -7
    * size: 1
    */
    private Boolean isOnline;
    
    /**
    * Column : add_on
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 4
    * size: 10
    */
    private Integer addOn;
    
    /**
    * Column : ext
    * remarks: 
    * default: 
    * isNullable: true
    * isAutoInc: false
    * isPrimary: false
    * type: 12
    * size: 1024
    */
    private String ext;
    
    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public Boolean getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Boolean isVirtual) {
        this.isVirtual = isVirtual;
    }
    
    public Integer getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(Integer companyCode) {
        this.companyCode = companyCode;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
    
    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }
    
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public Integer getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(Integer deviceCode) {
        this.deviceCode = deviceCode;
    }
    
    public Integer getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(Integer manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }
    
    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }
    
    public String getZigbeeVersion() {
        return zigbeeVersion;
    }

    public void setZigbeeVersion(String zigbeeVersion) {
        this.zigbeeVersion = zigbeeVersion;
    }
    
    public String getZigbeeMacAddress() {
        return zigbeeMacAddress;
    }

    public void setZigbeeMacAddress(String zigbeeMacAddress) {
        this.zigbeeMacAddress = zigbeeMacAddress;
    }
    
    public String getMainFeature() {
        return mainFeature;
    }

    public void setMainFeature(String mainFeature) {
        this.mainFeature = mainFeature;
    }
    
    public Integer getWifiFirm() {
        return wifiFirm;
    }

    public void setWifiFirm(Integer wifiFirm) {
        this.wifiFirm = wifiFirm;
    }
    
    public String getWifiVersion() {
        return wifiVersion;
    }

    public void setWifiVersion(String wifiVersion) {
        this.wifiVersion = wifiVersion;
    }
    
    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }
    
    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
        this.publicIp = publicIp;
    }
    
    public Boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }
    
    public Integer getAddOn() {
        return addOn;
    }

    public void setAddOn(Integer addOn) {
        this.addOn = addOn;
    }
    
    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper("Device")
            .add("deviceId",  deviceId)
            .add("userId",  userId)
            .add("parentId",  parentId)
            .add("username",  username)
            .add("isVirtual",  isVirtual)
            .add("companyCode",  companyCode)
            .add("name",  name)
            .add("barcode",  barcode)
            .add("macAddress",  macAddress)
            .add("encryptKey",  encryptKey)
            .add("type",  type)
            .add("state",  state)
            .add("location",  location)
            .add("deviceCode",  deviceCode)
            .add("manufacturerCode",  manufacturerCode)
            .add("manufacturerName",  manufacturerName)
            .add("description",  description)
            .add("productVersion",  productVersion)
            .add("zigbeeVersion",  zigbeeVersion)
            .add("zigbeeMacAddress",  zigbeeMacAddress)
            .add("mainFeature",  mainFeature)
            .add("wifiFirm",  wifiFirm)
            .add("wifiVersion",  wifiVersion)
            .add("serverAddress",  serverAddress)
            .add("publicIp",  publicIp)
            .add("isOnline",  isOnline)
            .add("addOn",  addOn)
            .add("ext",  ext)
           .toString();
    }

    @Override
    public List<String> fields() {
      return Lists.newArrayList("deviceId",
						"userId",
						"parentId",
						"username",
						"isVirtual",
						"companyCode",
						"name",
						"barcode",
						"macAddress",
						"encryptKey",
						"type",
						"state",
						"location",
						"deviceCode",
						"manufacturerCode",
						"manufacturerName",
						"description",
						"productVersion",
						"zigbeeVersion",
						"zigbeeMacAddress",
						"mainFeature",
						"wifiFirm",
						"wifiVersion",
						"serverAddress",
						"publicIp",
						"isOnline",
						"addOn",
						"ext");
    }
    
    @Override
    public String primaryField() {
        return "deviceId";
    }

    @Override
    public Integer id () {
    return deviceId;
    }

    @Override
    public void setId(Integer id) {
        this.deviceId = id;
    }

    @Override
    public void setGeneratedKey(Number key) {
    
        this.deviceId = key.intValue();
    
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("deviceId",  deviceId);
        map.put("userId",  userId);
        map.put("parentId",  parentId);
        map.put("username",  username);
        map.put("isVirtual",  isVirtual);
        map.put("companyCode",  companyCode);
        map.put("name",  name);
        map.put("barcode",  barcode);
        map.put("macAddress",  macAddress);
        map.put("encryptKey",  encryptKey);
        map.put("type",  type);
        map.put("state",  state);
        map.put("location",  location);
        map.put("deviceCode",  deviceCode);
        map.put("manufacturerCode",  manufacturerCode);
        map.put("manufacturerName",  manufacturerName);
        map.put("description",  description);
        map.put("productVersion",  productVersion);
        map.put("zigbeeVersion",  zigbeeVersion);
        map.put("zigbeeMacAddress",  zigbeeMacAddress);
        map.put("mainFeature",  mainFeature);
        map.put("wifiFirm",  wifiFirm);
        map.put("wifiVersion",  wifiVersion);
        map.put("serverAddress",  serverAddress);
        map.put("publicIp",  publicIp);
        map.put("isOnline",  isOnline);
        map.put("addOn",  addOn);
        map.put("ext",  ext);
        return map;
    }

    @Override
    public void fromMap(Map<String, Object> map) {

    }

   /* START Do not remove/edit this line. CodeGenerator will preserve any code between start and end tags.*/
	/* END Do not remove/edit this line. CodeGenerator will preserve any code between start and end tags.*/


}