package com.wywhdgg.demo1;

import com.wywhdgg.WywhdggDemoApplication;
import com.wywhdgg.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={WywhdggDemoApplication.class})// 指定启动类
public class ProfilesTests {
    @Autowired
    private SpringCacheTemplateService exampleService;

    // ------- spring redistemplate功能演示
    @Test
    public void setTest() {
        exampleService.setByCache("hash", "hahhhhh");
        exampleService.setByCache("a", "1");
        exampleService.setByCache("foo", "bar");
    }

    @Test
    public void getTest() throws Exception {
        User user = exampleService.findUser("hash");
        System.out.println(user);
    }


}
