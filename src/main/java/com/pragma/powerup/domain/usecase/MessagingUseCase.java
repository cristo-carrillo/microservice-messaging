package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IMessagingServicePort;
import com.pragma.powerup.domain.exception.NumberPhoneFormatException;
import com.pragma.powerup.domain.model.MessagingModel;
import com.pragma.powerup.domain.spi.IMessagingSendPort;

public class MessagingUseCase implements IMessagingServicePort {
    private final IMessagingSendPort messagingSendPort;

    public MessagingUseCase(IMessagingSendPort messagingSendPort) {
        this.messagingSendPort = messagingSendPort;
    }

    @Override
    public void sendMessaging(MessagingModel messagingModel) {
        validatedNumberPhone(messagingModel.getPhoneNumber());
        messagingSendPort.sendMessaging(messagingModel);
    }

    @Override
    public void validateCode(Integer code, Long id) {
        messagingSendPort.validateCode(code, id);
    }

    private void validatedNumberPhone(String number){
        String regexSigne = "^\\+(\\d{12})$";
        if(!number.matches(regexSigne)){
            throw new NumberPhoneFormatException(number);
        }
    }

}
