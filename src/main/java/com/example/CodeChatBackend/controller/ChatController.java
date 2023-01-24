package com.example.CodeChatBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import com.example.CodeChatBackend.controller.model.Message;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // To message privately listen to /app/message
    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message recievePublicMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/private-message")
    public Message recievePrivateMessage(@Payload Message message) {

        // To message privately listen to /user/username/private
        simpMessagingTemplate.convertAndSendToUser(message.getRecieverName(), "/private", message );
        return message;
    }
}
