package com.socialCampusApplication.demo.client.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ConversationDto {

    private Long id;

    private String topicName;

}
