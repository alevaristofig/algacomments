package com.algacomments.api.client.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.algacomments.api.client.CommentMonitoringClient;
import com.algacomments.api.client.RestClientFactory;
import com.algacomments.api.model.CommentInput;
import com.algacomments.api.model.CommentOutput;

@Component
public class CommentMonitoringClientImpl implements CommentMonitoringClient {
	
	private final RestClient restClient;
	
	public CommentMonitoringClientImpl(RestClientFactory factory) {
		this.restClient = factory.commentsMonitoringRestClient();
	}

	@Override
	public CommentOutput monitore(CommentInput input) {
		return null;
	}

	
}
