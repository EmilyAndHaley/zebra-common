package com.runningwithzebras;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.runningwithzebras.parsers.dom.ZebraListParser;
import com.runningwithzebras.rest.ZebraApiConsumer;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;

public class RestTest {

	@Test
	public void testRest() {
		ZebraApiConsumer consumer = new ZebraApiConsumer();
		int numResults = 10;

		consumer.setNumResults(numResults);
		consumer.addSymptom("Cough");

		InputStream stream;
		try {
			stream = consumer.getInputStream();

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder;
			Document doc;

			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(stream);

			String root = doc.getDocumentElement().getNodeName();

			assertEquals("response", root);
		} catch (Exception ex) {
			assert (false);
		}
	}

	@Test
	public void testZebraRest() {
		ZebraApiConsumer consumer = new ZebraApiConsumer();

		int numResults = 20;

		consumer.setNumResults(numResults);
		consumer.addSymptom("Cough");
		consumer.addSymptom("Seizure");

		InputStream stream;
		try {
			stream = consumer.getInputStream();

			ZebraListParser listParser = new ZebraListParser();

			ArrayList<Zebra> zebraList = listParser.ObjectFromDOM(stream);

			System.out.println("zebra size: " + zebraList.size());
			assertEquals(zebraList.size(), numResults);

			for (Zebra zebra : zebraList) {
				System.out.println("zeb: " + zebra.getDisplayTitle());
			}

		} catch (Exception ex) {
			System.out.println("Exception!! " + ex);
			assert (false);
		}

	}

}
