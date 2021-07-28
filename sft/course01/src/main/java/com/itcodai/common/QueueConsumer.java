package com.itcodai.common;

import com.itcodai.config.ActiveMqConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author zhao_wj
 * @version 1.0
 * @date 2021/7/26 15:11
 */
@Service
public class QueueConsumer {

    @JmsListener(destination = ActiveMqConfig.QUEUE_NAME)
    public void receiveQueueMsg(String msg){
        System.out.println("收到的消息为：" + msg);
    }

}
