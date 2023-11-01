package com.example.twitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
public class TwitterConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new ClientRegistrationRepository() {
            @Override
            public ClientRegistration findByRegistrationId(String registrationId) {
                if ("twitter".equals(registrationId)) {
                    return ClientRegistration
                            .withRegistrationId("twitter")
                            .clientId("tCxYOnwyEEyN7rSFhSw6epMeQ")
                            .clientSecret("r0Km1Aqd1l90kKDm66Whuto1cQrZE1JitPXo5HItejNV3h4qiK")
                            .tokenUri("https://api.twitter.com/oauth2/token")
                            .build();
                }
                return null;
            }
        };
    }
}
