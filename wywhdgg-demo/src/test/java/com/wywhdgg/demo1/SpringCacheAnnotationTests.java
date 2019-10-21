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
public class SpringCacheAnnotationTests {

    @Autowired
    private SpringCacheAnnotationService springCacheAnnotationService;

    // ---------------spring cache注解演示
    // get
    @Test
    public void springCacheTest() throws Exception {
        User user = springCacheAnnotationService.findUserById("hash");
        System.out.println(user);
    }

    // update
    @Test
    public void springCacheTest2() throws Exception {
        springCacheAnnotationService.updateUser(new User("hhhhhhh-2", "hash"));
        User user = springCacheAnnotationService.findUserById("hash");
        System.out.println(user);
    }

    // delete
    @Test
    public void springCacheTest3() throws Exception {
        springCacheAnnotationService.deleteUserById("hash");
    }
}
