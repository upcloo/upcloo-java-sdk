package com.upcloo.client.model.getter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="tag")
public class Tag {
	private String tag;

	public String getCategory() {
		return tag;
	}

	@XmlValue
	public void setCategory(String tag) {
		this.tag = tag;
	}

}
