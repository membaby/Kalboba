package com.example.demo.Controllers;

import com.example.demo.Entities.AccountEntites.user_account;
import com.example.demo.Services.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogInController {

    private final LogInService loginService;


    @Autowired
    public LogInController(LogInService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/Login")
    public user_account LogInUser(@RequestBody user_account account) {
        return loginService.LogInUser(account.getUsername(), account.getPassword());
    }
}
