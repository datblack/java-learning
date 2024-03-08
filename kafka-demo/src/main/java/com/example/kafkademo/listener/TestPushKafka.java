package com.example.kafkademo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestPushKafka {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @PostMapping("/push")
    public void pushMessage(){
        kafkaTemplate.send("test", "Test data" + System.currentTimeMillis());
    }

}
