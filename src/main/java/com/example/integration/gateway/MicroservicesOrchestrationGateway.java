package com.example.integration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface MicroservicesOrchestrationGateway {

    @Gateway(requestChannel = "inputChannel")
    void orchestrate(Message<String> message);
}
