package com.algacomments.api.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import com.algacomments.domain.model.CommentId;

@ReadingConverter
public class BytesToCommentIdConverter implements Converter<byte[], CommentId> {

	@Override
	public CommentId convert(byte[] source) {		
		return new CommentId(new String(source));
	}

}
