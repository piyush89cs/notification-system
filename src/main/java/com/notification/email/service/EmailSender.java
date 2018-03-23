package com.notification.email.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.notification.notification.request.NotificationMessage;
@Component
public class EmailSender {

	@Autowired
	private JavaMailSender javaMailSender;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	public void sendEmail(NotificationMessage notificationMessage) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = null;

			helper = new MimeMessageHelper(message, true);
			helper.setFrom(notificationMessage.getFrom());
			helper.setTo(notificationMessage.getTo());

			if (notificationMessage.getCc() != null) {
				helper.setCc(notificationMessage.getCc());
			}

			if (notificationMessage.getSubject() != null) {
				helper.setSubject(notificationMessage.getSubject());
			}
			helper.setPriority(2);
			helper.setText(notificationMessage.getMessage(), true);

			javaMailSender.send(message);

		} catch (MessagingException ex) {
			logger.error("Failed to send email", ex);
		} catch (MailException ex) {
			logger.error("Failed to send email", ex);
			throw ex;
		} catch (Exception ex) {
			logger.error("Failed to send email", ex);
			throw ex;
		}
	}
	
}
