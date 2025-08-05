package com.algacomments.api.config.redis;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.convert.RedisCustomConversions;

import com.algacomments.api.config.BytesToCommentIdConverter;
import com.algacomments.api.config.CommentIdToBytesConverter;

@Configuration
public class RedisConfig {
	
	@Bean
	public RedisCustomConversions redisCustomConversions() {
		 return new RedisCustomConversions(Arrays.asList(
	                new CommentIdToBytesConverter(),
	                new BytesToCommentIdConverter()
	        ));
	}
}
