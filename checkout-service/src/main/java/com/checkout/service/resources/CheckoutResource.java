package com.checkout.service.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkout.service.producer.Producer;
import com.checkout.service.resources.vo.OrderVO;

@RestController
@RequestMapping("/api")
public class CheckoutResource {

	@Autowired
	Producer producer;
	
	/**
	 * Method to send message RabbitMQ
	 * @param orderVO
	 * @return
	 */
	@RequestMapping("/checkout")
	public String sendMsg(@RequestBody OrderVO orderVO) {
		producer.orderMsg(orderVO);
		return "Funciona";
	}
}
