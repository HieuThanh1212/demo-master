package com.vmo.springboot.Demo.services.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(String setTo, String setSubject, String setText) throws MessagingException {
        try {
            // Create a Simple MailMessage.
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(setTo);
            message.setSubject(setSubject);
            message.setText(setText);

            // Send Message!
            this.mailSender.send(message);
            return "Email Sent!";
        } catch (Exception e) {
            e.printStackTrace();
            return "sent failed";
        }
    }

}
