package com.example.demo.Services;

import com.example.demo.Entities.AccountEntites.*;
import com.example.demo.Entities.RecordsEntities.verification;
import com.example.demo.Repositories.AccountRepositories.*;
import com.example.demo.Repositories.RecordsRepositories.verificationRepository;
import com.example.demo.Services.EmailSender.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class RegistrationService {
    private user_accountRepository accountRepository;
    private adopterRepository adopterrepository;
    private staffRepository staffrepository;
    private managerRepository managerrepository;
    private sys_adminRepository sys_adminrepository;
    private com.example.demo.Repositories.RecordsRepositories.verificationRepository verificationRepository;
    private EmailService emailService;


    @Autowired
    public RegistrationService(
            user_accountRepository accountRepository,
            adopterRepository adopterRepository,
            staffRepository staffRepository,
            managerRepository managerRepository,
            sys_adminRepository sys_adminRepository,
            verificationRepository verificationRepository,
            EmailService emailService
    ) {
        this.accountRepository = accountRepository;
        this.adopterrepository = adopterRepository;
        this.staffrepository = staffRepository;
        this.managerrepository = managerRepository;
        this.sys_adminrepository = sys_adminRepository;
        this.verificationRepository = verificationRepository;
        this.emailService = emailService;

    }

    public String RegistrationMapper(user_account account) {
        if (AccountExists(account.getEmail(),account.getUsername())) {
            return "Account Already Exists";
        }
        else {
            User_class user = account.getUser_class();
            if (user == User_class.Adopter) {
                return RegisterAdopter(account);
            }
            else if (user == User_class.Admin) {
                return RegisterAdmin(account);
            }
            else if (user == User_class.Staff) {
                return RegisterStaff(account);
            }
            else if (user == User_class.Manager) {
                return RegisterManager(account);
            }
            else {
                return "Invalid User Type";
            }
        }
    }



    public String RegisterAdopter(user_account account){
        String verificationCode = generateVerificationCode();
        account.setEnabled(false);
        adopter newAdopter = new adopter();
        newAdopter.setAccount(account);
        newAdopter.setAbout("Empty");
        adopterrepository.save(newAdopter);
        verification newVerification = new verification();
        newVerification.setAccount(account);
        newVerification.setOtp(verificationCode);
        //set time stamp + 24 hours
        newVerification.setTime_stamp(new Timestamp(System.currentTimeMillis() + 86400000));
        verificationRepository.save(newVerification);
        try {
            emailService.SendVerificationCode(account.getEmail(), verificationCode);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "Adopter Registered";
    }

    public String RegisterAdmin(user_account account) {
        String verificationCode = generateVerificationCode();
        account.setEnabled(false);
        sys_admin newAdmin = new sys_admin();
        newAdmin.setAccount(account);
        sys_adminrepository.save(newAdmin);
        verification newVerification = new verification();
        newVerification.setAccount(account);
        newVerification.setOtp(verificationCode);
        //set time stamp + 24 hours
        newVerification.setTime_stamp(new Timestamp(System.currentTimeMillis() + 86400000));
        verificationRepository.save(newVerification);
        try {
            emailService.SendVerificationCode(account.getEmail(), verificationCode);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "Admin Registered";
    }

    public String RegisterStaff(user_account account) {
        String verificationCode = generateVerificationCode();
        account.setEnabled(false);
        staff newStaff = new staff();
        newStaff.setAccount(account);
        staffrepository.save(newStaff);
        verification newVerification = new verification();
        newVerification.setAccount(account);
        newVerification.setOtp(verificationCode);
        //set time stamp + 24 hours
        newVerification.setTime_stamp(new Timestamp(System.currentTimeMillis() + 86400000));
        verificationRepository.save(newVerification);
        try {
            emailService.SendVerificationCode(account.getEmail(), verificationCode);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "Staff Registered";
    }

    public String RegisterManager(user_account account) {
        String verificationCode = generateVerificationCode();
        account.setEnabled(false);
        manager newManager = new manager();
        newManager.setAccount(account);
        managerrepository.save(newManager);
        verification newVerification = new verification();
        newVerification.setAccount(account);
        newVerification.setOtp(verificationCode);
        //set time stamp + 24 hours
        newVerification.setTime_stamp(new Timestamp(System.currentTimeMillis() + 86400000));
        verificationRepository.save(newVerification);
        try {
            emailService.SendVerificationCode(account.getEmail(), verificationCode);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "Manager Registered";
    }

    public String VerifyAccount(String emailAddress, String code) {
        user_account newAccount = accountRepository.findByEmail(emailAddress);
        verification verification = verificationRepository.findByAccount(newAccount);
        if (verification == null) {
            return "Account Not Found";
        }
        else if (verification.getOtp().equals(code)) {
                newAccount.setEnabled(true);
                accountRepository.save(newAccount);
                verificationRepository.delete(verification);
                try {
                    emailService.SendAccountCreatedEmail(emailAddress);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return "Account Verified";
        }
        else {
            return "Invalid Verification Code";
        }
    }

    private boolean AccountExists(String email, String username) {
        return accountRepository.existsByEmail(email) || accountRepository.existsByUsername(username);
    }

    private String generateVerificationCode() {
        //generate verification code from 100000 to 999999
        return String.valueOf((int) (Math.random() * (999999 - 100000 + 1) + 100000));
    }
}
