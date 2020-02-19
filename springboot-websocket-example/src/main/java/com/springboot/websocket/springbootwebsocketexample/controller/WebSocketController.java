package com.springboot.websocket.springbootwebsocketexample.controller;

import com.springboot.websocket.springbootwebsocketexample.model.User;
import com.springboot.websocket.springbootwebsocketexample.model.UserResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public UserResponse sendMessage(@Payload  User user){
        return new UserResponse(user.getName() +" : "+ user.getMessage());
    }

}
