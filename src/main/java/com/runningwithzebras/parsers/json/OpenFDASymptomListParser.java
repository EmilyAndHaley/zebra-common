package com.runningwithzebras.parsers.json;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.json.*;

import com.runningwithzebras.Symptom;

public class OpenFDASymptomListParser implements
		JsonParser<InputStream, ArrayList<Symptom>> {

	public ArrayList<Symptom> ObjectFromJSON(InputStream stream) {

		StringWriter writer = new StringWriter();

		try {
			IOUtils.copy(stream, writer);
		} catch (Exception e) {
			return null;
		}
		
		String fdaString = writer.toString();

		JSONObject obj = new JSONObject(fdaString);

		JSONArray arr = obj.getJSONArray("results");

		ArrayList<Symptom> symptoms = new ArrayList<Symptom>();
		for (int i = 0; i < arr.length(); i++) {
			String term = arr.getJSONObject(i).getString("term");
			symptoms.add(new Symptom(term, 0));
		}

		return symptoms;
	}
}
