package com.github.edgar615.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Edgar on 2018/8/20.
 *
 * @author Edgar  Date 2018/8/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {
  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

  @Before
  public void setupMockMvc(){
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build(); //初始化MockMvc对象
//    session = new MockHttpSession();
//    User user =new User("root","root");
//    session.setAttribute("user",user); //拦截器那边会判断用户是否登录，所以这里注入一个用户
  }

  @Test
  public void test() throws Exception{
//    String json="{\"author\":\"HAHAHAA\",\"title\":\"Spring\",\"url\":\"http://tengj.top/\"}";
    mockMvc.perform(MockMvcRequestBuilders.get("/method1/1")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
//                    .param("id", "1")
//                        .content(json.getBytes()) //传json参数
//                        .session(session)
    )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
    .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists());
  }

}
