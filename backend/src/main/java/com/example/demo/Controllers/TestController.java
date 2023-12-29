package com.example.demo.Controllers;

import com.example.demo.Entities.AccountEntites.Gender;
import com.example.demo.Entities.AccountEntites.User_class;
import com.example.demo.Entities.AccountEntites.user_account;
import com.example.demo.Repositories.AccountRepositories.staffRepository;
import com.example.demo.Repositories.AccountRepositories.user_accountRepository;
import com.example.demo.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/Test")
public class TestController {

    private user_accountRepository user_accountrepository;
    private staffRepository staffrepository;
    private RegistrationService registrationService;
    @Autowired
    public TestController(user_accountRepository user_accountrepository
                        , staffRepository staffrepository
                        , RegistrationService registrationService) {
        this.user_accountrepository = user_accountrepository;
        this.staffrepository = staffrepository;
        this.registrationService = registrationService;
    }

    @GetMapping("/adopterTest")
    public String accountTest() {
        user_account account = new user_account();
        account.setUsername("abdallah.samy.talha@gmail.com");
        account.setPassword("staff");
        account.setEmail("abdallah.samy.talha@gmail.com");
        account.setUser_class(User_class.Adopter);
        account.setEnabled(false);
        account.setFirst_name("staff");
        account.setLast_name("staff");
        account.setPhone_no("123456789");
        account.setAddress("Talha");
        account.setGender(Gender.M);
        account.setBirthdate(new Date(2000, 1, 1));
        return registrationService.VerifyAccount(account,"394686");
    }


}
