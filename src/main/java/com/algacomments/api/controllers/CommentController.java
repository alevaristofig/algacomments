package com.algacomments.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algacomments.api.common.IDGenerator;
import com.algacomments.api.model.CommentOutput;
import com.algacomments.domain.model.Comment;
import com.algacomments.domain.model.CommentId;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CommentOutput create(@RequestBody CommentOutput input) {
		
		Comment comment = Comment.builder()
				.id(new CommentId(IDGenerator.generateTSID()))
				.text(input.getText())
				.author(input.getAuthor())
				.build();
		
		return convertToModel(comment);
	}
	
	private CommentOutput convertToModel(Comment comment) {
		return  CommentOutput.builder()
				.id(comment.getId().getValue())
				.text(comment.getText())
				.author(comment.getAuthor())
				.build();
	}
}
