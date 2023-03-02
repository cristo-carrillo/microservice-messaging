package com.pragma.powerup.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessagingRequestDto {
    private Long id;
    private String phoneNumber;
    private String message;
}
