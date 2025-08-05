package com.algacomments.api.config;

import java.nio.charset.StandardCharsets;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import com.algacomments.domain.model.CommentId;

import io.hypersistence.tsid.TSID;

@ReadingConverter
public class BytesToCommentIdConverter implements Converter<byte[], CommentId> {

	@Override
	public CommentId convert(byte[] source) {		
		return new CommentId(new String(source));
		//return new CommentId(TSID.from(new String(source,StandardCharsets.UTF_8)));
	}

}
