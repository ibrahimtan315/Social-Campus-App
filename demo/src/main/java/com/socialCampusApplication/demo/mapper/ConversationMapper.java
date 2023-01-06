package com.socialCampusApplication.demo.mapper;

import com.socialCampusApplication.demo.client.dto.request.CreateConversationRequest;
import com.socialCampusApplication.demo.client.dto.response.ConversationDto;
import com.socialCampusApplication.demo.model.Conversation;
import org.mapstruct.Mapper;

@Mapper(implementationName = "ConversationMapperImpl", componentModel = "spring")
public interface ConversationMapper {

    Conversation toConversation(ConversationDto conversationDto);

    ConversationDto toConversationDto(Conversation conversation);

    Conversation toConversationFromCreateConversationRequest(CreateConversationRequest conversationRequest);

}
