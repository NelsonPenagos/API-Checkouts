package com.logistic.service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class EventConsumerConfiguration {

	public static final String EXCHANGE_NAME = "exchange_name";
	public static final String ROUTING_KEY = "routing_key";

	private static final String QUEUE_NAME = "queue_name";

	@Bean
	public TopicExchange eventExchange() {

		return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	public Queue queue() {

		return new Queue(QUEUE_NAME);
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange eventExchange) {

		return BindingBuilder.bind(queue).to(eventExchange).with(ROUTING_KEY);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
