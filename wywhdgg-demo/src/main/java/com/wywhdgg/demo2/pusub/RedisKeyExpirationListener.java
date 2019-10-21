package com.wywhdgg.demo2.pusub;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * 监听所有db的过期事件__keyspace@*__:expired"
 * @author lsm
 */
//@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
        System.out.println("---------RedisKeyExpirationListener-----------");
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
        String expiredKey = message.toString();
        System.out.println("--------------expiredKey:==:"+expiredKey);
//        if(expiredKey.startsWith("Order:")){
//            //如果是Order:开头的key，进行处理
//        }
    }
}
