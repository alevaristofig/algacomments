package com.algacomments.api.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class CommentMonitoringClientBadGatewayException extends RuntimeException {

}
