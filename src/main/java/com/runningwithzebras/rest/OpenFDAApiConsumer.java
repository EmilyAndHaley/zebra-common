package com.runningwithzebras.rest;

public class OpenFDAApiConsumer extends AbstractRestApiConsumer {
	
	// some example API calls TODO: set api parameters with properties then build API string
	
	// get adverse events for Rett Syndrome, return exact event
	String baseAPI3="https://api.fda.gov/drug/event.json?search=receivedate:[20040101+TO+20150101]+AND+patient.drug.drugindication:Rett+Syndrome&count=patient.reaction.reactionmeddrapt.exact";
	
	// get adverse events for hypotension drugs, return date of event
	String baseAPI1="https://api.fda.gov/drug/event.json?search=receivedate:[20040101+TO+20150101]+AND+patient.drug.drugindication:hypertension&count=receivedate";
	
	// get adverse event for 'medicinalproduct' aspirin 
	String baseAPI2="https://api.fda.gov/drug/event.json?search=patient.drug.medicinalproduct:aspirin&count=patient.reaction.reactionmeddrapt.exact";
	
	String baseAPI4 = "https://api.fda.gov/drug/event.json?search=patient.drug.openfda.pharm_class_epc:\"nonsteroidal+anti-inflammatory+drug\"&count=patient.reaction.reactionmeddrapt.exact";
	
	public OpenFDAApiConsumer() {
		this.baseAPI = "https://api.fda.gov/drug/event.json?search=patient.drug.openfda.pharm_class_epc:nonsteroidal+anti-inflammatory+drug&count=patient.reaction.reactionmeddrapt.exact";
	}

	String createURL() {
		return baseAPI;
	}

}
