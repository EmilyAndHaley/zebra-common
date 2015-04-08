package com.runningwithzebras.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public abstract class AbstractRestApiConsumer implements RestApiConsumer {
	String baseAPI;

	public void setBaseAPI(String baseAPI) {
		this.baseAPI = baseAPI;
	}

	public InputStream getInputStream() throws MalformedURLException,
			IOException {

		String urlString= createURL();
		urlString = urlString.replace(" ", "%20");
		
		URLEncoder.encode(urlString, "UTF-8");

		URL url = new URL(urlString);
		URLConnection connection = url.openConnection();
		return connection.getInputStream();
	}
	
	abstract String createURL();
}
