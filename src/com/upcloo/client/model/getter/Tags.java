package com.upcloo.client.model.getter;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tags")
public class Tags {
	private List<Tag> tag;

	public List<Tag> getCategory() {
		return tag;
	}

	@XmlElement(name="tag")
	public void setCategory(List<Tag> tag) {
		this.tag = tag;
	}
}
