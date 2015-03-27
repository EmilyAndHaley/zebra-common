package com.runningwithzebras.rest;

public class OpenFDAApiConsumer extends AbstractRestApiConsumer {

	public OpenFDAApiConsumer() {
		this.baseAPI = "https://api.fda.gov/drug/event.json?search=patient.drug.openfda.pharm_class_epc:\"nonsteroidal+anti-inflammatory+drug\"&count=patient.reaction.reactionmeddrapt.exact";
	}

	String createURL() {
		return baseAPI;
	}

}
