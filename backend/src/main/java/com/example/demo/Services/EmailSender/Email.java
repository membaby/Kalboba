package com.example.demo.Services.EmailSender;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Email {
    private String to;
    private String subject;
    private String content;

    public String VerifyEmailContent_PD(String email, String code){
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: 'Arial', sans-serif; }"
                + "  .header { background-color: #242c3c; color: white; padding: 10px; text-align: center; }"
                + "  .content { padding: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='header'>"
                + "    <h2>⚠️ Email Verification ⚠️</h2>"
                + "  </div>"
                + "  <div class='content'>"
                + "    <p>Dear user,</p>"
                + "    <p>Thank you for signing up! Please verify your account by visiting <a href='http://localhost:3000/verification?email="+email+"'>this link</a>.</p>"
                + "    <p>Your verification code is "+code+"</p>"
                + "    <p>the code will expire in 24 hours</p>"
                + "  </div>"
                + "</body>"
                + "</html>";
        return htmlContent;
    }

    public String AccountCreatedContent_Patient(){
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: 'Arial', sans-serif; }"
                + "  .header { background-color: #242c3c; color: white; padding: 10px; text-align: center; }"
                + "  .content { padding: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='header'>"
                + "    <h2>\uD83C\uDF89 Account Created \uD83C\uDF89</h2>"
                + "  </div>"
                + "  <div class='content'>"
                + "    <p>Dear user,</p>"
                + "    <p>Congratulations! Your account has been successfully created with our system. Welcome to the community!</p>"
                + "    <p>Feel free to explore our platform and make the most of your experience. If you have any questions or need assistance, don't hesitate to contact us.</p>"
                + "    <p>Best regards,</p>"
                + "    <p>The Doctorkom Team</p>"
                + "  </div>"
                + "</body>"
                + "</html>";
        return htmlContent;
    }

    public String VerifyEmailContent(String code) {
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: 'Arial', sans-serif; }"
                + "  .header { background-color: #242c3c; color: white; padding: 10px; text-align: center; }"
                + "  .content { padding: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='header'>"
                + "    <h2>⚠️ Email Verification ⚠️</h2>"
                + "  </div>"
                + "  <div class='content'>"
                + "    <p>Dear user,</p>"
                + "    <p>Thank you for signing up! Please verify your account.</p>"
                + "    <p>Your verification code is "+code+"</p>"
                + "    <p>the code will expire in 24 hours</p>"
                + "  </div>"
                + "</body>"
                + "</html>";
        return htmlContent;
    }

    public String AccountCreatedContent() {
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: 'Arial', sans-serif; }"
                + "  .header { background-color: #242c3c; color: white; padding: 10px; text-align: center; }"
                + "  .content { padding: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='header'>"
                + "    <h2>\uD83C\uDF89 Account Created \uD83C\uDF89</h2>"
                + "  </div>"
                + "  <div class='content'>"
                + "    <p>Dear user,</p>"
                + "    <p>Congratulations! Your account has been successfully created with our system. Welcome to the community!</p>"
                + "    <p>Feel free to explore our platform and make the most of your experience. If you have any questions or need assistance, don't hesitate to contact us.</p>"
                + "    <p>Best regards,</p>"
                + "    <p>The Petfecto Team</p>"
                + "  </div>"
                + "</body>"
                + "</html>";
        return htmlContent;
    }
}