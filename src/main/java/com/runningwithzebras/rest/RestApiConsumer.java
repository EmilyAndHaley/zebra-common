package com.runningwithzebras.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

public interface RestApiConsumer  {
	void setBaseAPI(String baseAPI);
	
	InputStream getInputStream() throws MalformedURLException, IOException;
	
}
