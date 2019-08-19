package com.rabbitMq.helloWorld;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
	
	private final static String QUEUE_NAME = "HelloWorldQueue";
	
	public static void main(String[] args) {
		// Factory of new Connections
		ConnectionFactory factoryOfConnections = new ConnectionFactory();
		factoryOfConnections.setHost("localhost");
		
		try (
				Connection connection = factoryOfConnections.newConnection();
				Channel channel = connection.createChannel();
		) {
			
			channel.queueDeclare(
				QUEUE_NAME,			// String				queue 
				false,				// boolean				durable
				false,				// boolean				exclusive
				false,				// boolean				autoDelete
				null);				// Map<String, Object>	arguments
			
			String message = "Hello World!";
			
			channel.basicPublish(
				"",						// String				exchange
				QUEUE_NAME,				// String				routingKey
				null,					// BasicProperties		properties
				message.getBytes());	// byte[]				body
			
			
			System.out.println(" [x] Sent '" + message + "'");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}