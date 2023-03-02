package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.MessagingModel;

public interface IMessagingServicePort {

    void sendMessaging(MessagingModel messagingModel);
    void validateCode(Integer code, Long id);
}
