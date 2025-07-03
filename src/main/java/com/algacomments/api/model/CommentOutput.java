package com.algacomments.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentOutput {

	private String text;
	
	private String author;
}
