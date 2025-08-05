package com.algacomments.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@RedisHash("comment")
public class Comment {

	@Id
	private CommentId id;
	
	private String text;	
	
	private String author;
}
