package net.usermd.grabiecm.mailsender.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MailSenderImpl {

    @Value("${mail.addressee}")
    private String addressee;

    private JavaMailSender javaMailSender;
    private MailService mailService;

    @Autowired
    public MailSenderImpl(JavaMailSender javaMailSender, MailService mailService) {
        this.javaMailSender = javaMailSender;
        this.mailService = mailService;
    }

    @Scheduled(cron="${mail.interval}")
    public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(this.addressee);

        msg.setSubject(mailService.getTopic());
        msg.setText(mailService.getContent());

        //System.out.println("works");
        javaMailSender.send(msg);
    }
}
