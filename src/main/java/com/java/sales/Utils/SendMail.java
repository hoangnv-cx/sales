package com.java.sales.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class SendMail {

	@Autowired
	private JavaMailSender javaMailSender;
	public void sendEmailTest(String to,String subject,String content) {
		
		 SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(to);

	        msg.setSubject(subject);
	        msg.setText(content);

	        javaMailSender.send(msg);
	}
	
}
