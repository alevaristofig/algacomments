package com.algacomments.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Comment {

	private CommentId id;
	private String text;	
	private String author;
}
