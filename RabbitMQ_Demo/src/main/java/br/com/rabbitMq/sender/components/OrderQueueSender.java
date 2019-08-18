package br.com.rabbitMq.sender.components;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueSender {
	
	/**
	 * Helper class to access and Send messages to RabbitMQ 
	 *  - Default behavior is synchronous
	 */
	@Autowired
	private RabbitTemplate aRabbitTemplate;
	
	/**
	 * Object that represents a setup Queue
	 */
	@Autowired
	private Queue aQueue;
	
	public void send(String pOrder) {
		/*
		 * Method that receives a Routing Key and a Message.
		 *  - The Routing Key is the Queue Name
		 */
		this.aRabbitTemplate.convertAndSend(
			this.aQueue.getName(), 
			pOrder);
	}
	
}