package net.usermd.grabiecm.mailsender;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSenderImpl {

    @Value("${mail.addressee}")
    private String addressee;
    @Value("${mail.interval}")
    private int interval;

    private JavaMailSender javaMailSender;
    private MailService mailService;

    @Autowired
    public MailSenderImpl(JavaMailSender javaMailSender, MailService mailService) {
        this.javaMailSender = javaMailSender;
        this.mailService = mailService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(this.addressee);

        msg.setSubject(mailService.getTopic());
        msg.setText(mailService.getContent());

        System.out.println("works");
        javaMailSender.send(msg);
    }
}
