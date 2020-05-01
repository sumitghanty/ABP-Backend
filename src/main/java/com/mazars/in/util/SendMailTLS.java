package com.mazars.in.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendMailTLS {
	private static final Logger logger = LoggerFactory.getLogger(SendMailTLS.class);
	public static void sendMail(String mailId,String cc,String subject,String body) {

		final String username = "emamitande@gmail.com";
		final String password = "emami123";
		logger.info("mailId"+mailId);

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		// LOCAL SERVER
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		//FOR DEVELOPMENT SERVER
		//props.put("mail.smtp.host", "10.16.7.25");
		//props.put("mail.smtp.port", "25");
		
		//FOR DEVELOPMENT SERVER
				//Session session = Session.getInstance(props,null);
				
				
		// FOR LOCALSERVER
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			
			// LOCAL SERVER
			message.setFrom(new InternetAddress("murchanahazarika@gmail.com"));
			
			//FOR DEVELOPMENT
			//message.setFrom(new InternetAddress("dev.travelmanagement@emamigroup.com"));
			
			//FOR QUALITY
			//message.setFrom(new InternetAddress("quality.travelmanagement@emamigroup.com"));
			
			//FOR  PRODUCTION
			//message.setFrom(new InternetAddress("travelmanagement@emamigroup.com"));
			
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(mailId));
			message.setRecipients(Message.RecipientType.CC,
					InternetAddress.parse(cc));
			message.setSubject(subject);
			message.setText("Dear Recepient,"
				+ "\n\n "+body);

			Transport.send(message);

			logger.info("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}