package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.entity.ChatMessage;
import com.example.entity.User;
import com.example.repository.ChatMessageRepository;
import com.example.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/send")
    public ChatMessage sendMessage(@RequestBody ChatMessage message, @RequestParam String receiverUsername) {
        String senderUsername = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User sender = userRepository.findByUsername(senderUsername);
        User receiver = userRepository.findByUsername(receiverUsername);
        message.setSender(sender);
        message.setReceiver(receiver);
        return chatMessageRepository.save(message);
    }

    @GetMapping("/messages")
    public List<ChatMessage> getMessages() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return chatMessageRepository.findByReceiverUsername(username);
    }
}
