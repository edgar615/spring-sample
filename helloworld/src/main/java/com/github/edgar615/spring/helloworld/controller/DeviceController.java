package com.github.edgar615.spring.helloworld.controller;

import com.google.common.base.Strings;

import com.github.edgar615.spring.helloworld.domain.Device;
import com.github.edgar615.util.db.Jdbc;
import com.github.edgar615.util.db.Pagination;
import com.github.edgar615.util.exception.DefaultErrorCode;
import com.github.edgar615.util.exception.SystemException;
import com.github.edgar615.util.search.Example;
import com.github.edgar615.util.spring.web.ResponseMessage;
import com.github.edgar615.spring.helloworld.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Edgar on 2017/10/17.
 *
 * @author Edgar  Date 2017/10/17
 */
@RestController
public class DeviceController {

  //jdbc仅支持对单表进行简单的CRUD操作，如果需要复杂的sql，需要使用JdbcTemplate
  @Autowired
  private Jdbc jdbc;

  @Autowired
  private DeviceService deviceService;

  @RequestMapping(value = "/devices", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public ModelAndView addDevice(@RequestBody Device device) {
    deviceService.insert(device);
//    jdbc.insertAndGeneratedKey(device);
    //insertAndGeneratedKey会将自动生成的主键赋值到device对象
    //jdbc.insert(device)不会讲主键赋值到device对象
    return ResponseMessage.asModelAndView(device.getDeviceId());
  }

  @RequestMapping(value = "/devices/{deviceId}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.ACCEPTED)
  public ModelAndView modifyDevice(@PathVariable("deviceId") int deviceId,
                                   @RequestBody Device device) {
    int result = jdbc.updateById(device, deviceId);
    //updateById根据主键更新
    // updateByCriteria根据条件更新
    return ResponseMessage.asModelAndView(result);
  }


  @RequestMapping(value = "/devices/{deviceId}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.ACCEPTED)
  public ModelAndView deleteDevice(@PathVariable("deviceId") int deviceId) {
    int result = jdbc.deleteById(Device.class, deviceId);
    //deleteById根据主键删除
    //deleteByCriteria根据条件删除
    return ResponseMessage.asModelAndView(result);
  }

  @RequestMapping(value = "/devices/{deviceId}", method = RequestMethod.GET)
  public Device get(@PathVariable("deviceId") int deviceId) {
    //findById根据主键查询
    //findFirstByExample根据条件取第一个
    //如果需要获取device对应的map，可以通过device.toMap()返回
    return jdbc.findById(Device.class, deviceId);
  }

  @RequestMapping(value = "/devices", method = RequestMethod.GET)
  public List<Device> list(
          @RequestParam(value = "companyCode", required = false) Integer companyCode,
          @RequestParam(value = "start", defaultValue = "0") int start,
          @RequestParam(value = "limit", defaultValue = "10") int limit,
          @RequestParam(value = "type", required = false) Integer type,
          @RequestParam(name = "q", required = false) String query) {
    Example example = Example.create().asc("addOn");
    //asc(addOn)按add-on生序排序
    //desc按add-on降序排序
//    orderBy("addOn,-type")，先按add-on生序，再按type降序
    if (!Strings.isNullOrEmpty(query)) {
      //更复杂的查询，需要按照查询规则定义，暂时用不到，可以删除
      // 如果要用，参考REST API规范中的搜索章节
      example.addQuery(query);
    }
    if (companyCode != null) {
      example.equalsTo("companyCode", companyCode);// company_code = ?的查询
    }
//    example.notEqualsTo("companyCode", 0) company_code<> ?的查询
//    example.isNull("companyCode") company_code is null的查询
//    example.isNotNull("companyCode") company_code is not null的查询
//    example.lessThan("companyCode", 0) company_code < 0的查询
//    example.lessThanOrEqualTo("companyCode", 0) company_code <=0的查询
//    example.greaterThan("companyCode", 0) company_code > 0的查询
//    example.greaterThanOrEqualTo("companyCode", 0) company_code >=的查询
//    example.between("companyCode", 0, 100) company_code >= 0 and company_code <= 100的信号线
//    example.endsWtih("macAddress", "EF") mac_address like '%EF'的查询
//    example.startsWith("macAddress", "EF") mac_address like 'EF%'的查询
//    example.contains("macAddress", "EF") mac_address like '%EF%'的查询
//    example.in("type", Lists.newArrayList(1, 2,3)) type in (1, 2, 3)的查询
//    example.notIn("type", Lists.newArrayList(1, 2,3)) type not in (1, 2, 3)的查询
    //不带start ,limit参数表示查询所有

    return jdbc.findByExample(Device.class, example, start, limit);
  }

  @RequestMapping(value = "/devices/page", method = RequestMethod.GET)
  public Pagination<Device> page(
          @RequestParam(value = "companyCode", required = false) Integer companyCode,
          @RequestParam(value = "page", defaultValue = "1") int page,
          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
          @RequestParam(value = "type", required = false) Integer type) {
    Example example = Example.create().asc("addOn");
    if (companyCode != null) {
      example.equalsTo("companyCode", companyCode);// company_code = ?的查询
    }

    Pagination<Device> pagination = jdbc.pagination(Device.class, example, page, pageSize);
    //如果要将Pagination转换为map
//    Pagination<Map> pagination1 = Paginations.transformToMap(pagination)
//    Pagination<Map> pagination1 = Paginations.transformToMap(pagination, m -> {
//      m.put("foo", "bar");
//    });
    return pagination;
  }

  @RequestMapping(value = "/devices/checkmac", method = RequestMethod.GET)
  public ModelAndView checkMac(
          @RequestParam(value = "macAddress", required = true) String macAddress) {
    Example example = Example.create()
            .equalsTo("macAddress", macAddress);
    int count = jdbc.countByCriteria(Device.class, example);
    if (count > 0) {
      throw SystemException.create(DefaultErrorCode.ALREADY_EXISTS);
    }

    return ResponseMessage.asModelAndView(1);
  }
}
