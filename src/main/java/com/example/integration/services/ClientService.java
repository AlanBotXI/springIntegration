package com.example.integration.services;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public void createClient(String clientData) {
        // Implementation for creating a client
        System.out.println("Creating client: " + clientData);
    }
}
