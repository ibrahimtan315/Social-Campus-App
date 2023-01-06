package com.socialCampusApplication.demo.client.dto.response.base;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class BaseConversationRequest {

    @NotBlank(message = "Topic name con not be empty")
    private String topicName;

}
