package com.algacomments.api.model;

import io.hypersistence.tsid.TSID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentOutput {

	private TSID id;
	private String text;	
	private String author;
}
