package com.upcloo.client.model.getter;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="categories")
public class Categories {
	private List<Category> category;

	public List<Category> getCategory() {
		return category;
	}

	@XmlElement(name="category")
	public void setCategory(List<Category> category) {
		this.category = category;
	}
}
