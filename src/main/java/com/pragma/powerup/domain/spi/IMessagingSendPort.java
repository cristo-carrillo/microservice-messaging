package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.MessagingModel;

public interface IMessagingSendPort {
    void sendMessaging(MessagingModel messagingModel);
    void validateCode(Integer code, Long id);
}
