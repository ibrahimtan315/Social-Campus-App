package com.socialCampusApplication.demo.client.dto.response.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class BaseMessageRequest {

    private Long id;

    private String text;

    private Long userId;

}
