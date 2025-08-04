package com.algacomments.api.model;

import lombok.Data;

@Data
public class CommentModerationInput {

	private String text;
	
	private String author;
}
