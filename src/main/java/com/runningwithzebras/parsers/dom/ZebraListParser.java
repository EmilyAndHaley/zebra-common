package com.runningwithzebras.parsers.dom;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.runningwithzebras.Zebra;

public class ZebraListParser implements DomParser<InputStream, ArrayList<Zebra>> {
	public ArrayList<Zebra> ObjectFromDOM(InputStream stream) {
		
		ArrayList<Zebra> zebras= new ArrayList<Zebra>();
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder; 
		Document doc;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(stream);
		}
		catch (ParserConfigurationException e) {
			return null;
		}
		catch (IOException e) {
			return null;
		}
		catch (SAXException e) {
			return null;
		}
		
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		
		NodeList nList=doc.getElementsByTagName("doc");
		
		ZebraParser zParser=new ZebraParser();
		
		for (int i=0;i<nList.getLength();i++) {
			Element current=(Element)nList.item(i);
			
			zebras.add(zParser.ObjectFromDOM(current));
		}
		
		return zebras;
	}
	

}
