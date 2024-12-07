package com.demo_bank_v2.mailMessanger;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.demo_bank_v2.config.MailConfig;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public class MailMassanger {
	
	public static void htmlEmailMessanger(String from, String toMail, String subject, String body) throws MessagingException {
		JavaMailSender sender = MailConfig.getMailConfig();
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper htmlMessage = new MimeMessageHelper(message, true);
		
		htmlMessage.setTo(toMail);
		htmlMessage.setFrom(from);
		htmlMessage.setSubject(subject);
		htmlMessage.setText(body, true);
		
		sender.send(message);
	}

	
}
