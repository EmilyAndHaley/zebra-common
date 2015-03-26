package com.runningwithzebras.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ZebraApiConsumer extends AbstractRestApiConsumer {
	
	
	String strSymptoms="seizure+cough";
	String strScore="score%20desc";
	String strFL="score,display_title,associated_gene,symptom";
	int nRows=10;
	
	public ZebraApiConsumer() {
		this.baseAPI = "http://findzebra.compute.dtu.dk/api/call/xml/query?";
	}

	public InputStream getInputStream() throws MalformedURLException, IOException {
		
		String urlString=String.format("%sq=%s&score=%s&fl=%s&rows=%d", baseAPI, strSymptoms, strScore, strFL, nRows);
	
		URL url = new URL(urlString);
		URLConnection connection = url.openConnection();
		return connection.getInputStream();
	}
}
