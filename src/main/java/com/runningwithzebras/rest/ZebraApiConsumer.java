package com.runningwithzebras.rest;

import java.util.ArrayList;

public class ZebraApiConsumer extends AbstractRestApiConsumer {

	ArrayList<String> listSymptoms = new ArrayList<String>();

	String strScore = "score desc";
	String strFL = "score,display_title,associated_gene,symptom";
	int numResults = 10;

	public ZebraApiConsumer() {
		this.baseAPI = "http://findzebra.compute.dtu.dk/api/call/xml/query?";
	}

	String createURL() {
		return String.format("%sq=%s&score=%s&fl=%s&rows=%d",
				baseAPI, makeSymptomString(), strScore, strFL, numResults);
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
