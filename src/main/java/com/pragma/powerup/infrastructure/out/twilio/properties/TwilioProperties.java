package com.pragma.powerup.infrastructure.out.twilio.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
@Getter
@Setter
@NoArgsConstructor
public class TwilioProperties {
    private String accountSid;
    private String authToken;
    private String trialNumber;
}
