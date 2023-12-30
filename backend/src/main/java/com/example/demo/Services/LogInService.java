package com.example.demo.Services;

import com.example.demo.Entities.AccountEntites.user_account;
import com.example.demo.Repositories.AccountRepositories.user_accountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInService {
    private user_accountRepository accountRepository;
    @Autowired
    public LogInService(user_accountRepository accountRepository
                        ) {
        this.accountRepository = accountRepository;
    }


    public user_account LogInUser(String emailOrUsername, String password) {
        if (EmailExists(emailOrUsername)) {
            user_account account = accountRepository.findByEmail(emailOrUsername);
            if (account.getPassword().equals(password)) {
                return account;
            }
            else {
                return null;
            }
        }
        else if (UsernameExists(emailOrUsername)) {
            user_account account = accountRepository.findByUsername(emailOrUsername);
            if (account.getPassword().equals(password)) {
                return account;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    private boolean EmailExists(String emailOrUsername) {
        user_account account = accountRepository.findByEmail(emailOrUsername);
        return account != null;
    }

    private boolean UsernameExists(String emailOrUsername) {
        user_account account = accountRepository.findByUsername(emailOrUsername);
        return account != null;
    }

}
