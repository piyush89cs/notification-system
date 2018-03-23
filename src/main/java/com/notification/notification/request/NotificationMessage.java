package com.notification.notification.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.notification.notification.constants.NotificationType;

public class NotificationMessage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String from;
	String to;
	String subject;
	String cc;
	@NotNull
	String message;
	@NotNull
	NotificationType notificationType;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public NotificationType getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}
	
	
}
