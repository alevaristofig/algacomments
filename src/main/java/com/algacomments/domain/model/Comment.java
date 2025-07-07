package com.algacomments.domain.model;

import org.springframework.data.redis.core.RedisHash;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@RedisHash
public class Comment {

	private CommentId id;
	private String text;	
	private String author;
}
