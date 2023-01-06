package com.socialCampusApplication.demo.controller;

import com.socialCampusApplication.demo.client.dto.request.CreateConversationRequest;
import com.socialCampusApplication.demo.client.dto.response.ConversationDto;
import com.socialCampusApplication.demo.service.ConversationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/conversations")
public class ConversationController {

    private final ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    // conversation creating
    @PostMapping
    public ResponseEntity<ConversationDto> createConversation(@Valid @RequestBody CreateConversationRequest conversationRequest){
        return ResponseEntity.ok(conversationService.createConversation(conversationRequest));
    }


    // conversation deleting
    @DeleteMapping("/{id}")
    public void deleteConversation(@PathVariable Long id){
        conversationService.deleteConversation(id);
    }

    // display conversation
    @GetMapping("/{id}")
    public ResponseEntity<ConversationDto> getConversationById(@PathVariable Long id){
        return ResponseEntity.ok(conversationService.getConversationDtoById(id));
    }



}
