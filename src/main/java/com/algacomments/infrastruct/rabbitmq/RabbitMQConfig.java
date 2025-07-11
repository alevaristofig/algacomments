package com.algacomments.infrastruct.rabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

@Configuration
public class RabbitMQConfig {

	public static final String FANOUT_EXCHANGE_NAME = "comments-processing.comments-received.v1.e";
	public static final String QUEUE_COMMENTS_PROCESSING = "comments-processing.comments-process.v1.q";
	
	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter(ObjectMapper mapper) {
		return new Jackson2JsonMessageConverter(mapper);
	}
	
	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}
	
	@Bean
	public FanoutExchange exchange() {
		return ExchangeBuilder.fanoutExchange(FANOUT_EXCHANGE_NAME).build();
	}
	
	@Bean
	public Queue queueComment() {
		return QueueBuilder.durable(QUEUE_COMMENTS_PROCESSING).build();
	}
	
	@Bean
	public Binding bindingCommentProcess() {
		return BindingBuilder.bind(queueComment()).to(exchange());
	}
}
