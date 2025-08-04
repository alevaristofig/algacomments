package com.algacomments.domain.service;

import org.springframework.stereotype.Service;

import com.algacomments.api.model.CommentInput;
import com.algacomments.domain.model.Comment;

@Service
public class CommentService {
		
	public void moderar(Comment comment) {
		CommentInput commentInput = new CommentInput();
		
		commentInput.setText(comment.getText());
		commentInput.setAuthor(null);
	}

}
