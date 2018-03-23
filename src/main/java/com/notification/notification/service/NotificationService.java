package com.notification.notification.service;

import com.notification.notification.request.NotificationMessage;

public interface NotificationService {
	
	public void deliverMessage(NotificationMessage notificationMessage);

}
