package com.demo_bank_v2.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailConfig {

	
		@Bean
		public static JavaMailSenderImpl getMailConfig() {
			JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();
			
			Properties props = emailConfig.getJavaMailProperties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail,smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.debug", "true");
			
			
			emailConfig.setHost("localhost");
			emailConfig.setPort(25);
			emailConfig.setUsername("user1@newcompany.com");
			emailConfig.setPassword("password123");
			
			return emailConfig;
		}
}