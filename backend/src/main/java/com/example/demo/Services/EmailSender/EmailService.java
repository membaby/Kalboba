package com.example.demo.Services.EmailSender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void SendVerificationCode(String email,String code) throws MessagingException {
        Email notification = new Email();
        notification.setTo(email);
        notification.setSubject("Verification Code");
        notification.setContent(notification.VerifyEmailContent(code));
        Send(notification);
    }
    public void SendAccountCreatedEmail(String email) throws MessagingException {
        Email notification = new Email();
        notification.setTo(email);
        notification.setSubject("Account  Created");
        notification.setContent(notification.AccountCreatedContent());
        Send(notification);

    }
    private void Send(Email email) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(email.getTo());
        helper.setSubject(email.getSubject());
        helper.setText(email.getContent(), true);
        helper.setFrom("doctorkomegy@outlook.com");

        mailSender.send(mimeMessage);
    }



}
