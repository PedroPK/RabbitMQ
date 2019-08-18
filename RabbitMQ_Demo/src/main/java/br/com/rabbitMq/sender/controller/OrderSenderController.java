package br.com.rabbitMq.sender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rabbitMq.sender.components.OrderQueueSender;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/orders")
@Slf4j
public class OrderSenderController {
	
	@Autowired
	private OrderQueueSender aOrderQueueSender;
	
	@RequestMapping(method=RequestMethod.POST)
	public void send(
		@RequestBody
		String pOrder
	) {
		log.info("Order will be send");
		
		this.aOrderQueueSender.send(pOrder);
		
		log.info("Order was sent");
	}
	
}