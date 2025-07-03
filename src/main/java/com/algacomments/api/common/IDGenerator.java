package com.algacomments.api.common;

import java.util.Optional;

import io.hypersistence.tsid.TSID;

public class IDGenerator {

	private static final TSID.Factory tsidFactory;
	
	static {
		Optional.ofNullable(System.getenv("tsid.node"))
			.ifPresent(tsidNode -> System.setProperty("tsid.node", tsidNode));
		
		Optional.ofNullable(System.getenv("tsid.node.count"))
			.ifPresent(tsidNodeCount -> System.setProperty("tsid.node.count", tsidNodeCount));
		
		tsidFactory = TSID.Factory.builder().build();
	}
	
	private IDGenerator() {}
	
	public static TSID generateTSID() {
		return tsidFactory.generate();
	}
	
	
}
