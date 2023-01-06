package com.socialCampusApplication.demo.service;

import com.socialCampusApplication.demo.client.dto.request.CreateConversationRequest;
import com.socialCampusApplication.demo.client.dto.response.ConversationDto;
import com.socialCampusApplication.demo.exception.ConversationNotFoundException;
import com.socialCampusApplication.demo.mapper.ConversationMapper;
import com.socialCampusApplication.demo.model.Conversation;
import com.socialCampusApplication.demo.repository.ConversationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ConversationService {

    private ConversationRepository conversationRepository;

    private ConversationMapper conversationMapper;

    public ConversationService(ConversationRepository conversationRepository, ConversationMapper conversationMapper) {
        this.conversationRepository = conversationRepository;
        this.conversationMapper = conversationMapper;
    }

    public ConversationDto createConversation(CreateConversationRequest conversationRequest){
        Conversation conversation = conversationMapper.toConversationFromCreateConversationRequest(conversationRequest);

        return conversationMapper.toConversationDto(conversationRepository.save(conversation));
    }

    public void deleteConversation(Long id){
        conversationRepository.deleteById(id);
    }

    @Transactional
    public ConversationDto getConversationDtoById(Long id){
        Optional<Conversation> conversationOptional = conversationRepository.findById(id);

        return conversationOptional.map(conversationMapper::toConversationDto)
                .orElseThrow(()-> new ConversationNotFoundException("Conversation couldn't be found by id: " + id));
    }

}
