package com.notification.notification.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.notification.email.service.EmailSender;
import com.notification.notification.request.NotificationMessage;
import com.notification.notification.service.NotificationService;

@Component
public class EmailNotificationService implements NotificationService{

	@Autowired
	EmailSender emailSender;
	public static final Logger logger = LoggerFactory.getLogger(EmailNotificationService.class);
	public void deliverMessage(NotificationMessage notificationMessage) {
		logger.error("Inside EmailNotificationService");
		emailSender.sendEmail(notificationMessage);
		
	}
}
