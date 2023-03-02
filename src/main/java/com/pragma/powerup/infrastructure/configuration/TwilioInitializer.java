package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.infrastructure.out.twilio.properties.TwilioProperties;
import com.twilio.Twilio;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {

    private final TwilioProperties twilioProperties;

    public TwilioInitializer(TwilioProperties twilioConfiguration) {
        this.twilioProperties = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
    }
}
