package com.vmo.springboot.Demo;

import com.vmo.springboot.Demo.services.mail.MailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

@SpringBootApplication
@EnableWebMvc
//@EnableScheduling
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
            //new SwaggerConfig();
    }
//    @Bean
//    public JavaMailSender getJavasender() {
//        JavaMailSenderImpl sender = new JavaMailSenderImpl();
//        sender.setHost("smtp.gmail.com");
//       sender.setPort(587);
//        sender.setUsername("veins1104@gmail.com");
//       sender.setPassword("udsfwwjsmaxoslhb");
//       Properties pop = sender.getJavaMailProperties();
//       pop.put("mail.transport.protocol", "smtp");
//       pop.put("mail.smtp.auth", "true");
//       pop.put("mail.smtp.starttls.enable", "true");
//        pop.put("mail.debug", "true");
//    pop.put("mail.smtp.ssl.enable", "true");
//       return sender;
//   }

}
