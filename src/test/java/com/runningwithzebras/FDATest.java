package com.runningwithzebras;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

import com.runningwithzebras.parsers.json.OpenFDASymptomListParser;
import com.runningwithzebras.rest.OpenFDAApiConsumer;

public class FDATest {
	@Test
	public void testFDAAPI() { 
		OpenFDAApiConsumer consumer=new OpenFDAApiConsumer();
		
		InputStream stream=null;
		
		try {
			stream=consumer.getInputStream();
		}
		catch (Exception ex) {
			assertTrue(false);
		}
		
	}
	
	@Test
	public void testCreateObjectsFromFDAAPI() { 
		OpenFDAApiConsumer consumer=new OpenFDAApiConsumer();
		
		InputStream stream=null;
		
		try {
			stream=consumer.getInputStream();
		}
		catch (Exception ex) {
			assertTrue(false);
		}
		
		ArrayList<Symptom> symptoms=new OpenFDASymptomListParser().ObjectFromJSON(stream);
		
		System.out.println("num symptoms: "+symptoms.size());
		
		for (Symptom symptom:symptoms) System.out.println(symptom.getTerm());
		
	}

}
