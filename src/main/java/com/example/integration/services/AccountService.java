package com.example.integration.services;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public void createAccount(String accountData) {
        // Implementation for creating an account
        System.out.println("Creating account: " + accountData);
    }
}
