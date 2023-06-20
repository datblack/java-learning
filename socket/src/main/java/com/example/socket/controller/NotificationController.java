package com.example.socket.controller;

import com.example.socket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {
    private final SimpMessagingTemplate simpleMessageTemplate;

    public NotificationController(SimpMessagingTemplate simpleMessageTemplate) {
        this.simpleMessageTemplate = simpleMessageTemplate;
    }

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message) {
        System.out.println("JOIN: " + message);
        return message;
    }

    @MessageMapping("/private-message")
    public Message recMessage(@Payload Message message) {
        simpleMessageTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);
        System.out.println("CHATTING: " + message);
        return message;
    }
}
