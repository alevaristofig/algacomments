package com.algacomments.api.model;

import io.hypersistence.tsid.TSID;
import lombok.Data;

@Data
public class CommentModerationInput {

	private String text;
	
	private TSID commentId;
}
