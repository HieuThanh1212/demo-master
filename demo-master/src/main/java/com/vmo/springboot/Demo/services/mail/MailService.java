package com.vmo.springboot.Demo.services.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class MailService  {
    @Autowired
    public JavaMailSender emailSender;

    public String sendSimpleEmail(String setTo, String setSubject, String setText) {
        try {
            // Create a Simple MailMessage.
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(setTo);
            message.setSubject(setSubject);
            message.setText(setText);

            // Send Message!
            this.emailSender.send(message);
            return "Email Sent!";
        } catch (Exception e) {
            e.printStackTrace();
            return "sent failed";
        }
    }

}
