package com.example.socket.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Message {
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;
}
