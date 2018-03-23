package com.notification.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.notification.notification.constants.NotificationType;
import com.notification.notification.service.impl.EmailNotificationService;
import com.notification.notification.service.impl.SlackNotificationService;

@Component
public class NotificationObjectFactory {
	
	@Autowired
	EmailNotificationService emailNotificationService;
	
	@Autowired
	SlackNotificationService slackNotificationService;;
	public NotificationService getNotificationService(NotificationType notificationType){
		switch(notificationType) {
		case EMAIL:
			return emailNotificationService;
		case SLACK:
			return slackNotificationService;
		default:
			return slackNotificationService;
		}
	}
}
