<<<<<<< HEAD:demo/src/main/java/com/example/demo/tayma/mail/EmailService.java
package com.example.demo.tayma.mail;

=======
package com.example.demo.mail;
/*
>>>>>>> e944f10b738061c10593560335e716ad80a8456c:demo/src/main/java/com/example/demo/mail/EmailService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }
}
*/