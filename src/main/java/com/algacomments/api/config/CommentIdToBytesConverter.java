package com.algacomments.api.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import com.algacomments.domain.model.CommentId;

@WritingConverter
public class CommentIdToBytesConverter implements Converter<CommentId, byte[]> {

	@Override
	public byte[] convert(CommentId source) {		
		return source.toString().getBytes();
	}

	
}
