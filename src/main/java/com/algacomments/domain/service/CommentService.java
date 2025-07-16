package com.algacomments.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algacomments.api.producer.CommentProducer;
import com.algacomments.domain.model.Comment;
import com.algacomments.domain.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentProducer commentProducer;

	public void notificar(Comment comment) {
		commentProducer.enviar(comment);
	}

}
