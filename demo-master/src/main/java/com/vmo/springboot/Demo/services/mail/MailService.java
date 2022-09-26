package com.vmo.springboot.Demo.services.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import java.util.Properties;

@Service
public class MailService extends Authenticator {
    @Autowired
    private JavaMailSender mailSender;
    public String sendEmail(String setTo,String setSubject,String setText) throws MessagingException {

        try {
            // Create a Simple MailMessage.
            SimpleMailMessage message = new SimpleMailMessage();
            //message.setFrom(("hieuntph18781@fpt.edu.vn"));
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
