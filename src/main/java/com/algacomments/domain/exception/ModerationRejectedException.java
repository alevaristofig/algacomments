package com.algacomments.domain.exception;

public class ModerationRejectedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public ModerationRejectedException(String message) {
		super(message);
	}
}
