package com.algacomments.api.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.algacomments.domain.model.Comment;
import com.algacomments.infrastruct.rabbitmq.RabbitMQConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CommentProducer {
	
	private final RabbitTemplate rabbitTemplate;

	public void enviar(Comment comment) {
		log.info(String.format("A mensagem %s foi produzida", comment.toString()));
		
		String exchange = RabbitMQConfig.FANOUT_EXCHANGE_NAME;
		String routeKey = "";
		
		rabbitTemplate.convertAndSend(exchange, routeKey, comment);
	}
}
