package com.notification.notification.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.notification.notification.request.NotificationMessage;
import com.notification.notification.service.NotificationObjectFactory;

@Component
public class MessageDeliveryProcessor {

	@Autowired
	NotificationObjectFactory notificationObjectFactory;

	@JmsListener(destination = "notificationQueue", containerFactory = "jmsTransFactory", concurrency = "1")
	public void processMessage(NotificationMessage notificationMessage) {
		notificationObjectFactory.getNotificationService(notificationMessage.getNotificationType())
				.deliverMessage(notificationMessage);
	}

}
