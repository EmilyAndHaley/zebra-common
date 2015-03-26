package com.runningwithzebras;

/**
 * 
 * 
 */
import java.util.List;

/*
 * Class used to store elements of the XML file from find zebras 
 * Consists of various getters and setters 
 */

public class Zebra {

	private String content;
	private String displayTitle;
	private String retrievedDate;
	private List<String> genes;
	private List<String> symptoms;
	private String source;
	private String sourceUrl;
	private String score;

	public Zebra(String displaytitle, String content, String source,
			String sourceUrl, String retrievedDate, List<String> genes) {
		this.displayTitle = displaytitle;
		this.content = content;
		this.source = source;
		this.sourceUrl = sourceUrl;
		this.retrievedDate = retrievedDate;
		this.genes = genes;
	}

	public String getContent() {
		return content;
	}

	public String getRetrievedDate() {
		return retrievedDate;
	}

	public String getDisplayTitle() {
		return displayTitle;
	}

	public List<String> getGenes() {
		return genes;
	}

	public List<String> getSymptoms() {
		return symptoms;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public String getScore() {
		return score;
	}

	public String getSource() {
		return source;
	}

}
