package com.github.edgar615.spring.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring MVC的异常处理类.
 *
 * @author Edgar
 * @version 1.0
 */
@ControllerAdvice
public class ExceptionHandlerController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);



  /**
   * Exception.
   * http状态码为400
   *
   * @param ex Exception
   * @return ModelAndView
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ModelAndView handleException(Exception ex, HttpServletRequest request,
                                      HttpServletResponse response) {
    System.out.println(ex.getClass());
    System.out.println(ex.getCause());
    ex.getCause().printStackTrace();
    ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
    mav.addObject("code", 999);
    mav.addObject("message", "xxxx");
    return mav;
  }


}