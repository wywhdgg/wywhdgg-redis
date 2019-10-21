package com.wywhdgg.demo1;

import com.wywhdgg.WywhdggDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * WeiboFollowers
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={WywhdggDemoApplication.class})// 指定启动类
public class WeiboFollowersTests {
    @Autowired
    WeiboFollowerService followerService;

    @Test
    public void followers() {
        long followerNum = followerService.addFollowers("hash");
        System.out.println("路转粉，收获妹子一枚：" + followerNum);

//        followerNum = followerService.subFollowers("hash");
//        System.out.println("粉转路，妹子离我而去：" + followerNum);

//        followerService.followersFromCache("hash");
//        System.out.println("粉转路，妹子离我而去：" + followerNum);
    }
}

