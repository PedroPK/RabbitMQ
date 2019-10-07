package br.com.rmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderConsumer {

	@RabbitListener(queues = { "${queue.order.name}" })
	public void receive(@Payload String pOrder) {
		log.info("Order: " + pOrder);
	}
}