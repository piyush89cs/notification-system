package com.notification.notification.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.notification.notification.request.NotificationMessage;
import com.notification.notification.service.NotificationService;

@Component
public class SlackNotificationService implements NotificationService {

	public static final Logger logger = LoggerFactory.getLogger(SlackNotificationService.class);
	
	public void deliverMessage(NotificationMessage notificationMessage) {
		logger.error("Inside SlackNotificationService");
	}
}
