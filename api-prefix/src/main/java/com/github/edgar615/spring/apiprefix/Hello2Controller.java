package com.github.edgar615.spring.apiprefix;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

/**
 * Created by Edgar on 2017/10/17.
 *
 * @author Edgar  Date 2017/10/17
 */
@Controller
@RequestMapping("/")
public class Hello2Controller {


  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public Long hello() {
    return Instant.now().getEpochSecond();
  }

}
