package com.pragma.powerup.infrastructure.out.twilio.adapter;

import com.pragma.powerup.domain.model.MessagingModel;
import com.pragma.powerup.domain.spi.IMessagingSendPort;
import com.pragma.powerup.infrastructure.exception.CodeIdNotFoundException;
import com.pragma.powerup.infrastructure.out.twilio.properties.TwilioProperties;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service("twilio")
@RequiredArgsConstructor
public class TwilioAdapter implements IMessagingSendPort {
    private final TwilioProperties twilioConfiguration;
    Map<Long, Integer> otpMap = new HashMap<>();

    @Override
    public void sendMessaging(MessagingModel messagingModel) {
        PhoneNumber to = new PhoneNumber(messagingModel.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
        Integer otp = generateOTP();
        String message = messagingModel.getMessage() + ": " + otp;
        MessageCreator creator = Message.creator(
                to,
                from,
                message
        );
        otpMap.put(messagingModel.getId(), otp);
        creator.create();
    }

    @Override
    public void validateCode(Integer code, Long id) {
        final String MESSAGE_ERROR = "code : "+otpMap.get(id);
        if (!otpMap.containsKey(id)) {
            throw new CodeIdNotFoundException(MESSAGE_ERROR);
        }
        if (!otpMap.get(id).equals(code)) {
            throw new CodeIdNotFoundException(MESSAGE_ERROR);
        }
        otpMap.remove(id);
    }

    private Integer generateOTP() {
        return new Random().nextInt(999999);
    }
}
