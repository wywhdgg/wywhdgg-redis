package com.wywhdgg.lesson2_othertype;

import com.wywhdgg.WywhdggDemoApplication;
import com.wywhdgg.demo2.CommDataTypeDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={WywhdggDemoApplication.class})// 指定启动类
public class CommTypeTests {
	@Autowired
    private CommDataTypeDemo service;
	
	// 类似：在redis里面存储一个hashmap
    //@Test
    public void hashTest() {
    	service.hash();
    }

    // 列表~ 集合数据存储~ java.util.List，java.util.Stack
    //@Test
    public void list() {
    	service.list();
    }

    // 用set实现（交集 并集）
    //@Test
    public void setTest() {
    	service.set();
    }

    // 游戏排行榜
    @Test
    public void zsetTest() {
    	service.zset();
    }
}

