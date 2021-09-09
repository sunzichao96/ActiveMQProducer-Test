package com.example.activemqproducer.producer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.activemqproducer.producer.mapper.UserMapper;
import com.example.activemqproducer.producer.Po.User;
import com.example.activemqproducer.producer.service.QueueProducerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class QueueProducerServiceImpl implements QueueProducerService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private UserMapper userMapper;

    /**
     * 发送字符串消息队列
     *
     * @param queueName 队列名称    StringQueueTest
     * @param message   字符串
     */
    @Override
    public void sendStringQueue(String queueName, String message) {
        for (int i = 1; i <= 5; i++) {
            log.info("第" + i + "次produce消息。。。");
            this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(queueName), message + i);
        }
    }

    /**
     * 发送字符串List消息队列
     *
     * @param queueName 队列名称    StringQueueListTest
     */
    @Override
    public void sendListQueue(String queueName) {
        List<String> messageList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            messageList.add("list----" + i);
        }
        log.info("发送StringListQueue。。。");
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(queueName), messageList);
    }

    /**
     * 发送对象消息队列
     *
     * @param queueName 队列名称    ObjectQueueTest
     */
    @Override
    public User sendObjectQueue(String queueName) {
        User user = userMapper.selectById(1);
        String userString = JSONObject.toJSONString(user);
        this.jmsMessagingTemplate.convertAndSend(queueName,userString);
        return user;
    }

}
