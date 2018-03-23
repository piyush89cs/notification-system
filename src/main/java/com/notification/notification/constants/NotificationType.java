package com.notification.notification.constants;

public enum NotificationType {
	EMAIL(4, "Email Notifcation"),
	SLACK(8,"Slack Notification");
	
	public int id;
	public String description;
	
	private NotificationType(int id, String description){
		this.id = id;
		this.description = description;
		
	}

}
