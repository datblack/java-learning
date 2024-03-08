package com.example.kafkademo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @KafkaListener(topics = "test")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }

}
