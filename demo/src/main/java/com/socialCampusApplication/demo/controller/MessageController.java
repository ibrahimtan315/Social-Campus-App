package com.socialCampusApplication.demo.controller;

import com.socialCampusApplication.demo.model.Message;
import com.socialCampusApplication.demo.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getAllMessages(@RequestParam Optional<Long> userId){
        return messageService.getAllMessages(userId);
    }

    @GetMapping("/{messageId}")
    public Message getOneMessage(@PathVariable Long messageId){
        return messageService.getOneMessageById(messageId);
    }

    @DeleteMapping("/{messageId}")
    public void deleteMessage(@PathVariable Long messageId){
        messageService.deleteMessage(messageId);
    }

//    @PostMapping
//    public Message createMessage(@RequestBody CreateMessageRequest messageRequest){
//        return messageService.createMessage(messageRequest);
//    }
}
