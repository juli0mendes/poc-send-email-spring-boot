package br.com.juli0mendes.pocsendemail.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailCore {
	
	@Value("${osklen.email.emailto}")
    private String emailTo;
	
	@Value("${osklen.email.subject}")
	private String subject;
	
	@Value("${osklen.email.text}")
	private String text;
	
    private JavaMailSender javaMailSender;
	
	public EmailCore(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(this.emailTo);
        msg.setSubject(this.subject);
        msg.setText(this.text);

        javaMailSender.send(msg);
    }
}
