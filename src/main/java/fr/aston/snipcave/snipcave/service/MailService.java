package fr.aston.snipcave.snipcave.service;

import fr.aston.snipcave.snipcave.exceptions.SpringSnipcaveException;
import fr.aston.snipcave.snipcave.model.NotificationEmail;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(NotificationEmail notification){

        SimpleMailMessage simpleMailMessage =new SimpleMailMessage();
        simpleMailMessage.setTo(notification.getReceiver());
        simpleMailMessage.setSubject(notification.getSubject());
        simpleMailMessage.setText(notification.getBody());
        try {
            javaMailSender.send(simpleMailMessage);
            log.info("Activation email sent!!");
        } catch (MailException e) {
            log.error("Exception occurred when sending mail", e);
            throw new SpringSnipcaveException("Exception occurred when sending mail to " + notification.getReceiver(), e);
        }

    }

}
