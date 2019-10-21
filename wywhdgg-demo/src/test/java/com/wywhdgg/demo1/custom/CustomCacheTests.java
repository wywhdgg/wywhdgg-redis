package com.wywhdgg.demo1.custom;

import com.wywhdgg.WywhdggDemoApplication;
import com.wywhdgg.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/***
 *@author dzb
 *@date 2019/10/20 23:31
 *@Description:
 *@version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={WywhdggDemoApplication.class})// 指定启动类
public class CustomCacheTests {

    @Autowired
    private CustomAnnoDemoService customDemoService;

    // get
    @Test
    public void springCacheTest() throws Exception {
        User user = customDemoService.findUserById("wahaha");
        System.out.println(user);
    }

}
