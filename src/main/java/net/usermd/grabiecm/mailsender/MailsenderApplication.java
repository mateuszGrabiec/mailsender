package net.usermd.grabiecm.mailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.MailSender;

@SpringBootApplication
public class MailsenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailsenderApplication.class, args);
    }

}
