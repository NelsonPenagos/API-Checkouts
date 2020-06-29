package com.checkout.service.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.checkout.service.resources.vo.OrderVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
public class Producer {

	public static final String EXCHANGE_NAME = "exchange_name";
	public static final String ROUTING_KEY = "routing_key";

	private static final String QUEUE_NAME = "queue_name";
	private static final boolean IS_DURABLE_QUEUE = false;

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Bean
	Queue queue() {
		return new Queue(QUEUE_NAME, IS_DURABLE_QUEUE);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}

	/**
	 * Method to send Order MQ
	 * @param order
	 */
	public void orderMsg(OrderVO order) {
		try {
			String orderJson = objectMapper.writeValueAsString(order);
			Message message = MessageBuilder.withBody(orderJson.getBytes())
					.setContentType(MessageProperties.CONTENT_TYPE_JSON).build();
			this.rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
}
