package com.example.demo.Controllers;

import com.example.demo.DTOs.user_accountDTO;
import com.example.demo.DTOsMappers.user_accountMapper;
import com.example.demo.Entities.AccountEntites.user_account;
import com.example.demo.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/Register")
public class RegistrationController {

    private RegistrationService registrationService;
    private user_accountMapper user_accountmapper;

    @Autowired
    public RegistrationController(RegistrationService registrationService,
                                  user_accountMapper user_accountmapper) {
        this.registrationService = registrationService;
        this.user_accountmapper = user_accountmapper;
    }

    @RequestMapping("/User")
    public String RegisterUser(@RequestBody user_account account) {
        return registrationService.RegistrationMapper(account);
    }

    @RequestMapping("/Verify")
    public String VerifyAccount(user_accountDTO account, String code) {
        user_account accountEntity = user_accountmapper.toEntity(account);
        return registrationService.VerifyAccount(accountEntity, code);
    }
}
