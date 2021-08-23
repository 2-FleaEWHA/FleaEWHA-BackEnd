package kr.or.epro.fleaewha.controller;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {


    @MessageMapping("/chat")
    @SendTo("/topic/roomId")
    public Message boradCast(Message message){
        return message;
    }
}