package com.example.demo.DTOs;

import com.example.demo.Entities.AccountEntites.Gender;
import com.example.demo.Entities.AccountEntites.User_class;
import lombok.Builder;
import lombok.Value;

import java.sql.Date;

@Builder
@Value
public class user_accountDTO {
    int id;
    String email;
    String username;
    String password;
    boolean enabled;
    User_class user_class;
    Gender gender;
    String first_name;
    String last_name;
    String phone_no;
    String address;
    Date birthdate;
}
