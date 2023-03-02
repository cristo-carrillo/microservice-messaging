package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.MessagingRequestDto;
import com.pragma.powerup.application.handler.IMessagingHandler;
import com.pragma.powerup.application.mapper.IMessagingRequestMapper;
import com.pragma.powerup.domain.api.IMessagingServicePort;
import com.pragma.powerup.domain.model.MessagingModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MessagingHandler implements IMessagingHandler {

    private final IMessagingServicePort messagingServicePort;
    private final IMessagingRequestMapper messagingRequestMapper;
    @Override
    public void sendMessaging(MessagingRequestDto messagingRequestDto) {
        MessagingModel messagingModel = messagingRequestMapper.toMessageModel(messagingRequestDto);
        messagingServicePort.sendMessaging(messagingModel);
    }

    @Override
    public void validateCode(Integer code, Long id) {
        messagingServicePort.validateCode(code, id);
    }


}
