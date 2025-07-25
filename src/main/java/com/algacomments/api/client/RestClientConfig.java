package com.algacomments.api.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

	@Bean
	public CommentMonitoringClient commentMonitoringClient(RestClientFactory factory) {
		RestClient restClient = factory.commentsMonitoringRestClient();
		RestClientAdapter adapter = RestClientAdapter.create(restClient);
		
		HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builderFor(adapter).build();
		
		return proxyFactory.createClient(CommentMonitoringClient.class);
	}
}
