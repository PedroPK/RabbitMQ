package br.com.rabbitMq.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SenderApplicationConfig {
	
	@Value("${queue.order.name}")
	private String orderQueue;
	
	@Bean
	public Queue getQueue() {
		return new Queue(orderQueue, true);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SenderApplicationConfig.class, args);
	}

}
