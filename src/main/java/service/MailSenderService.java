package services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import data.Mail;

public class MailSenderService {
	
	public void send(Mail email){
		String username = "megafono.app@gmail.com";
		String password = "vacrilealu";
		
		
		String host = "smtp.gmail.com";
		String port = "587";
		
		Properties p = System.getProperties();

		p.setProperty("mail.smtp.host", host);
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.port", port);

		
		
		Session session =  Session.getInstance(p,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		
		try{
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
		message.setSubject(email.getSubject());
		message.setText(email.getBody());
		
		Transport.send(message);
		
		System.out.println("Submitted successfully");
		}catch (MessagingException e){
			throw new RuntimeException(e);
		}
	}
}
