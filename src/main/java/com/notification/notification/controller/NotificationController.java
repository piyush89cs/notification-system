package com.notification.notification.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notification.notification.constants.QueueDestinations;
import com.notification.notification.request.NotificationMessage;
import com.notification.notification.response.NotificationResponse;

@RestController
@RequestMapping("/services/rest")
public class NotificationController {
	public static final Logger logger = LoggerFactory.getLogger(NotificationController.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@GetMapping("healthCheck")
	public ResponseEntity<?> healthCheck(){
		return ResponseEntity.ok(new NotificationResponse(true));
	}
	@PostMapping("deliver")
	public ResponseEntity<?> deliverMessage(@RequestBody NotificationMessage notificationMessage){
		jmsTemplate.convertAndSend(QueueDestinations.NOTIFICATION_QUEUE, notificationMessage);
		return ResponseEntity.ok(new NotificationResponse(true));
	}

}
