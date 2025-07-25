package com.algacomments.api.client;

import java.time.Duration;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RestClientFactory {

	private final RestClient.Builder builder;
	
	public RestClient commentsMonitoringRestClient() {
		return builder.baseUrl("http://localhost:8081")
				.requestFactory(generateClientHttpRequestFactory())
				.defaultStatusHandler(HttpStatusCode::isError, (request,response) -> {
					throw new CommentMonitoringClientBadGatewayException();
				}).build();
	}
	
	private ClientHttpRequestFactory generateClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		
		factory.setReadTimeout(Duration.ofSeconds(5));
		factory.setConnectTimeout(Duration.ofSeconds(3));
		
		return factory;
	}
}
