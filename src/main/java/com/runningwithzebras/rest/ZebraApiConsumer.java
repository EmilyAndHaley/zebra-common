package com.runningwithzebras.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ZebraApiConsumer extends AbstractRestApiConsumer {

	ArrayList<String> listSymptoms = new ArrayList<String>();

	String strScore = "score desc";
	String strFL = "score,display_title,associated_gene,symptom";
	int numResults = 10;

	public ZebraApiConsumer() {
		this.baseAPI = "http://findzebra.compute.dtu.dk/api/call/xml/query?";
	}

	public InputStream getInputStream() throws MalformedURLException,
			IOException {

		String urlString = String.format("%sq=%s&score=%s&fl=%s&rows=%d",
				baseAPI, makeSymptomString(), strScore, strFL, numResults);
		urlString = urlString.replace(" ", "%20");

		URL url = new URL(urlString);
		URLConnection connection = url.openConnection();
		return connection.getInputStream();
	}

	public void setNumResults(int numResults) {
		this.numResults = numResults;
	}

	public void addSymptom(String symptom) {
		listSymptoms.add(symptom);
	}

	String makeSymptomString() {
		String strSymptoms = listSymptoms.get(0);

		for (int i = 1; i < listSymptoms.size(); i++) {
			strSymptoms += '+' + listSymptoms.get(i);
		}

		return strSymptoms;
	}
}
