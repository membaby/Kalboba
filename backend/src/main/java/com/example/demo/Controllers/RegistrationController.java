package com.example.demo.Controllers;


import com.example.demo.Entities.AccountEntites.user_account;
import com.example.demo.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Register")
public class RegistrationController {

    private final RegistrationService registrationService;


    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @RequestMapping("/User")
    public String RegisterUser(@RequestBody user_account account) {
        account.setId(null);
        return registrationService.RegistrationMapper(account);
    }

    @RequestMapping("/Verify")
    public String VerifyAccount(@RequestBody user_account account, String code) {
        return registrationService.VerifyAccount(account,code);
    }
}
