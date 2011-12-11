package com.upcloo.client.model.getter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="category")
public class Category {
	private String category;

	public String getCategory() {
		return category;
	}

	@XmlValue
	public void setCategory(String category) {
		this.category = category;
	}

}
