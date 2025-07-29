package com.algacomments.api.client.impl;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.algacomments.api.client.CommentMonitoringClient;
import com.algacomments.api.client.RestClientFactory;
import com.algacomments.api.model.CommentInput;
import com.algacomments.api.model.CommentModeratedOutuput;

@Component
public class CommentMonitoringClientImpl implements CommentMonitoringClient {
	
	private final RestClient restClient;
	
	public CommentMonitoringClientImpl(RestClientFactory factory) {
		this.restClient = factory.commentsMonitoringRestClient();
	}

	@Override
	public CommentModeratedOutuput monitore(CommentInput input) {
		return restClient.post()
					.uri("/api/moderate")
					.contentType(MediaType.APPLICATION_JSON)
					.body(input)
					.retrieve()
					.body(CommentModeratedOutuput.class);
	}

	
}
