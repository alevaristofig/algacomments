package com.algacomments.api.client;

import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import com.algacomments.api.model.CommentInput;
import com.algacomments.api.model.CommentOutput;

@HttpExchange("/api/moderate")
public interface CommentMonitoringClient {

	@PostExchange
	CommentOutput monitore(CommentInput input);
}
