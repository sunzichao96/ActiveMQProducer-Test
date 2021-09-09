package com.example.activemqproducer.producer.service;

import com.example.activemqproducer.producer.Po.User;

public interface QueueProducerService {

    void sendStringQueue(String queueName, String message);

    void sendListQueue(String queueName);

    User sendObjectQueue(String queueName);
}
