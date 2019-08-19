package com.rabbitMq.helloWorld;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Receiver {
	
	private final static String QUEUE_NAME = "HelloWorldQueue";
	
	public static void main(String[] args) {
		ConnectionFactory factoryOfConnections = new ConnectionFactory();
		factoryOfConnections.setHost("localhost");
		
		try {
			Connection	connection	= factoryOfConnections.newConnection();
			
			Channel		channel		= connection.createChannel();
			channel.queueDeclare(
				QUEUE_NAME,
				false,
				false,
				false,
				null
			);
			
			System.out.println(" [*] Waiting for Messagens. To Exit, press CTRL + C.");
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}