package com.vmo.springboot.Demo.services.mail;

import com.vmo.springboot.Demo.services.ReceivableServiceIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail,String body,String subject,String attechment) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("veins1104@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystem = new FileSystemResource(new File(attechment));
        mimeMessageHelper.addAttachment(fileSystem.getFilename(),fileSystem);
        mailSender.send(mimeMessage);
        System.out.println("sent ......");
    }

}
