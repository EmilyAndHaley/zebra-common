package com.runningwithzebras.parsers.dom;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;

import com.runningwithzebras.Zebra;

public class ZebraParser implements DomParser<Element, Zebra> {
	public Zebra ObjectFromDOM(Element e) {

		try {
			XPath xPath = XPathFactory.newInstance().newXPath();

			String ex = "./str[@name='display_title']";

			Element display_title = (Element) xPath.compile(ex).evaluate(e,
					XPathConstants.NODE);
			String strDisplayTitle = display_title.getFirstChild()
					.getNodeValue();
	
			ex = "./arr[@name='symptom']";
			e = (Element) xPath.compile(ex).evaluate(e, XPathConstants.NODE);

			for (int j = 0; j < e.getChildNodes().getLength(); j++) {
				Element currentInner = (Element) e.getChildNodes().item(j);
				// System.out.println("   "+j+": "+currentInner.getFirstChild().getNodeValue());
			}

			return new Zebra(strDisplayTitle, null, null, null, null, null);
		} catch (XPathExpressionException ex) {
			return null;
		}
	}
}
