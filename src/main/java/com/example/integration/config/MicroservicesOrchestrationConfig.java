package com.example.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.messaging.MessageChannel;

import com.example.integration.services.AccountService;
import com.example.integration.services.ClientService;

@Configuration
public class MicroservicesOrchestrationConfig {	

	@Bean
    IntegrationFlow orchestrateClientAndAccountFlow(
            ClientService clientService,
            AccountService accountService
    ) {
        return IntegrationFlow.from("inputChannel")
                .<String, String>transform(String::toUpperCase) // Add a simple transformation for testing
                .publishSubscribeChannel(subflow -> subflow
                        .subscribe(flow -> flow.handle(clientService, "createClient"))
                        .subscribe(flow -> flow.handle(accountService, "createAccount"))
                )
                .get();
    }

    @Bean
    MessageChannel inputChannel() {
        return new DirectChannel();
    }
	
}
