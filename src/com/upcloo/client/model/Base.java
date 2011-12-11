package com.upcloo.client.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="doc")
public class Base {
	private String title;
	private String summary;
	
	public String getTitle() {
		return title;
	}
	
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSummary() {
		return summary;
	}
	
	@XmlElement
	public void setSummary(String summary) {
		this.summary = summary;
	}
}
