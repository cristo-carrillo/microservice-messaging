package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IMessagingServicePort;
import com.pragma.powerup.domain.spi.IMessagingSendPort;
import com.pragma.powerup.domain.usecase.MessagingUseCase;
import com.pragma.powerup.infrastructure.out.twilio.adapter.TwilioAdapter;
import com.pragma.powerup.infrastructure.out.twilio.properties.TwilioProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final TwilioProperties twilioConfiguration;
    @Bean
    public IMessagingSendPort messagingSendPort(){
        return new TwilioAdapter(twilioConfiguration);
    }
    @Bean
    public IMessagingServicePort messagingServicePort(){
        return new MessagingUseCase(messagingSendPort());
    }

}