package br.com.rabbitMq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/*
 * Once tue Consumer has to be mapped into Spring container,
 * it has to receive the @Component annotation
 *
 * The @Slf4f is a Lombok annotation, allowing us to Log with less effort 
 */
@Component
@Slf4j
public class OrderConsumer {
	
	/**
	 * The @RabbitListener annotation marks this method as a Listener
	 * 
	 * The @Payload annotation informs that a parameter is going to 
	 * receive the Message Body. 
	 *  - If the method was only one parameter, this annotation is not necessary
	 * 
	 * @param pFileBody
	 */
	@RabbitListener(queues = {"$queue.order.name"})
	public void receive(
		@Payload 
		String pFileBody
	) {
		log.info(pFileBody);
	}
	
}