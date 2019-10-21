package com.wywhdgg.demo2.pusub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 接收消息通知
 * 借助spring容器接收消息
 */
@Component
@Configuration
public class MsgChannelListenerBySpring {

    // 定义监听器
    @Bean
    public RedisMessageListenerContainer smsMessageListener(RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        //使用黑科技，屏蔽此方法
        container.addMessageListener(new RedisExpiredListener(), new PatternTopic("__key*__:*"));
//        SmsSendListener smsSendListener = new SmsSendListener();
//        container.addMessageListener(smsSendListener, Arrays.asList(new ChannelTopic(PubsubRedisConfig.PUBSUB_CHANNEL_NAME)));
        return container;
    }

    // 定义触发的方法
    class SmsSendListener implements MessageListener {
        @Override
        public void onMessage(Message message, byte[] pattern) {
            System.out.println("借助spring容器收到消息：" + message);
        }
    }
}
