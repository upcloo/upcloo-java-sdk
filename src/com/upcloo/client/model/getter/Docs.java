package com.upcloo.client.model.getter;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="docs")
public class Docs {

	private List<Doc> docs;

	public List<Doc>getDocs()
	{
		return docs;
	}

	@XmlElement(name="doc")
	public void setDocs(List<Doc> docs)
	{
		this.docs = docs;
	}
}
