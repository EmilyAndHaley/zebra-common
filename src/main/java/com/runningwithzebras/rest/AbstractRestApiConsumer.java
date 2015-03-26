package com.runningwithzebras.rest;

public abstract class AbstractRestApiConsumer implements RestApiConsumer {
	String baseAPI;
	
	public void setBaseAPI(String baseAPI) {
		this.baseAPI=baseAPI;
	}
}
