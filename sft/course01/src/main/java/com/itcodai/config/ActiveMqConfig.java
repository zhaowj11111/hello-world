package com.itcodai.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Destination;

/**
 * @author zhao_wj
 * @version 1.0
 * @date 2021/7/25 17:32
 */
@Configuration
public class ActiveMqConfig {

    /**
     * 发布/订阅模式队列名称
     */
    public static final String TOPIC_NAME = "activemq.topic";
    /**
     * 点对点模式队列名称
     */
    public static final String QUEUE_NAME = "activemq.queue";

    @Bean
    public Destination topic() {
        return new ActiveMQTopic(TOPIC_NAME);
    }

    @Bean
    public Destination queue() {
        return new ActiveMQQueue(QUEUE_NAME);
    }
}
