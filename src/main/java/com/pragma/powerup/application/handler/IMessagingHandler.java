package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.MessagingRequestDto;

public interface IMessagingHandler {
    void sendMessaging(MessagingRequestDto messagingRequestDto);
    void validateCode(Integer code, Long id);
}
