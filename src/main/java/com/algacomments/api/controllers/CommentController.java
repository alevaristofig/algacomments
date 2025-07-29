package com.algacomments.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.algacomments.api.common.IDGenerator;
import com.algacomments.api.model.CommentOutput;
import com.algacomments.domain.model.Comment;
import com.algacomments.domain.model.CommentId;
import com.algacomments.domain.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
	
	@Autowired
	private CommentService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody CommentOutput input) {
		
		if(input.getAuthor() == null || input.getAuthor().isBlank() ||
		   input.getText() == null || input.getAuthor().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		Comment comment = Comment.builder()
				.id(new CommentId(IDGenerator.generateTSID()))
				.text(input.getText())
				.author(input.getAuthor())
				.build();
		
		
	}
	
	private CommentOutput convertToModel(Comment comment) {
		return  CommentOutput.builder()
				.id(comment.getId().getValue())
				.text(comment.getText())
				.author(comment.getAuthor())
				.build();
	}
}
