package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInService {
    @Autowired
    public LogInService() {
    }

    public boolean LogInUser() {
        // TODO implement here
        return false;
    }

    private boolean AccountExists() {
        // TODO implement here
        return false;
    }

    private boolean PasswordMatches() {
        // TODO implement here
        return false;
    }
}
