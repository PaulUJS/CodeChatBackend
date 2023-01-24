package com.example.CodeChatBackend.controller.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    private String senderName;
    private String recieverName;
    private String message;
    private Status status;
}
