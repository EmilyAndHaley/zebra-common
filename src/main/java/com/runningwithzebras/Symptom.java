package com.runningwithzebras;

public class Symptom {
	
	private String term;
	private int count;
	
	public Symptom(String term, int count) {
		this.term=term;
		this.count=count;
	}
	
	public void setTerm(String term) {
		this.term=term;
	}
	
	public String getTerm() {
		return term;
	}
	
	public void setCount(int count) {
		this.count=count;
	}
	
	public int getCount() {
		return count;
	}
}
