package com.itcodai.common;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author zhao_wj
 * @version 1.0
 * @date 2021/7/26 15:01
 */
@Service
public class MsgProducer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, String msg){
        //随便添加电视
        jmsMessagingTemplate.convertAndSend(destination,msg);
    }

}
