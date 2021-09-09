package com.example.activemqproducer.producer.controller;

import com.example.activemqproducer.producer.service.QueueProducerService;
import com.example.activemqproducer.producer.Po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("queue")
public class QueueController {

    @Autowired
    private QueueProducerService mqQueueProducerService;

    @RequestMapping("TestString")
    public String StringQueue(@RequestParam String queueName, @RequestParam String message) {
        mqQueueProducerService.sendStringQueue(queueName, message);
        return "ooo";
    }

    @RequestMapping("TestStringList")
    public String StringListQueue(@RequestParam String queueName) {
        mqQueueProducerService.sendListQueue(queueName);
        return "000";
    }

    @RequestMapping("TestObject")
    public User ObjectQueue(@RequestParam String queueName){
        return mqQueueProducerService.sendObjectQueue(queueName);
    }


}
