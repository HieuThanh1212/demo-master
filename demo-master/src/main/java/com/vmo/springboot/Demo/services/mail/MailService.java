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
    private JavaMailSender mailSender;

    public String sendmail(String setTo,String setSubject,String setText) throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("veins1104@gmail.com", "pkurbxvrttznkemf");
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("veins1104@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("veins1104@gmail.com"));
        msg.setSubject(setSubject);
        msg.setText(setText);
        msg.setText(setTo);

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();




        return "ok";
    }



}
