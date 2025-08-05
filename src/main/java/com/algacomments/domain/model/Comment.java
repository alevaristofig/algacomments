package com.algacomments.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("comment")
public class Comment {
	
	@Id
	private CommentId id;
	
	private String text;	
	
	private String author;
}
