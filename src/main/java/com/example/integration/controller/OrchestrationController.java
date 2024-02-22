package com.example.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.integration.gateway.MicroservicesOrchestrationGateway;

@RestController
@RequestMapping("/orchestrate")
public class OrchestrationController {

    private final MicroservicesOrchestrationGateway gateway;

    @Autowired
    public OrchestrationController(MicroservicesOrchestrationGateway gateway) {
        this.gateway = gateway;
    }

    @PostMapping
    public void orchestrate(@RequestBody String requestData) {
        Message<String> message = MessageBuilder.withPayload(requestData).build();
        gateway.orchestrate(message);
    }
}
