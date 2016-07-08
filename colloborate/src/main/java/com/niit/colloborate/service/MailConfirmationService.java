package com.niit.colloborate.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailConfirmationService {

	@Autowired
	private SimpleMailMessage emailTemplate;

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	public void setEmailTemplate(SimpleMailMessage emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendMail(String un,String pass,String mail) {

		String fromEmail = emailTemplate.getFrom();
		String emailSubject = emailTemplate.getSubject();

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

			helper.setFrom(fromEmail);
			helper.setTo(mail);
			helper.setSubject(emailSubject);
			helper.setText("Welcome "+un+",\n\n"+"	You can now log in with the following credentials,\n\nUsername : "+un+"\n\nPassword : "+pass+"\n\n\nRegards,\nJustColloborate.com");

			/*
			  uncomment the following lines for attachment FileSystemResource
			  file = new FileSystemResource("attachment.jpg");
			  helper.addAttachment(file.getFilename(), file);
			 */

			javaMailSender.send(mimeMessage);
			System.out.println("Mail sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	
	
	}

}
