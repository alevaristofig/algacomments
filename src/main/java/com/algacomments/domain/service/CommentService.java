package com.algacomments.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algacomments.api.client.impl.CommentMonitoringClientImpl;
import com.algacomments.api.model.CommentCollection;
import com.algacomments.api.model.CommentInput;
import com.algacomments.api.model.CommentModeratedOutuput;
import com.algacomments.api.model.CommentModerationInput;
import com.algacomments.domain.model.Comment;
import com.algacomments.domain.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentMonitoringClientImpl client;
	
	@Autowired
	private CommentRepository repository;
		
	public CommentModeratedOutuput moderar(Comment comment) {
		CommentModerationInput commentInput = new CommentModerationInput();
		
		commentInput.setText(comment.getText());
		commentInput.setCommentId(comment.getId().getValue());
		
		return client.moderated(commentInput);		
	}
	
	public void salvar(Comment comment) {
		//CommentCollection commentCollection = new CommentCollection();
		
		//commentCollection.setId(comment.getId().getValue().toString());
		//commentCollection.setText(comment.getText());
		//commentCollection.setAuthor(comment.getAuthor());
		
		//comment.setId(comment.getId().getValue());
		
		repository.save(comment);
	}

}
