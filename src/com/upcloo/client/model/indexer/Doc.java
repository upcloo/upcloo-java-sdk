package com.upcloo.client.model.indexer;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlType(name = "model", propOrder = {
	    "id",
	    "sitekey",
	    "password",
	    "title",
	    "summary",
	    "content",
	    "publishDate",
	    "author"
	})
@XmlRootElement(name="model")
public class Doc {
	private String id;
	private String sitekey;
	private String password;
	private String title;
	private String summary;
	private String content;
	private XMLGregorianCalendar publishDate;
	private String author;
	
	public String getId() {
		return id;
	}

	@XmlElement(required=true, nillable=false)
	public void setId(String id) {
		this.id = id;
	}

	public String getSitekey() {
		return sitekey;
	}

	@XmlElement(required=true)
	public void setSitekey(String sitekey) {
		this.sitekey = sitekey;
	}

	public String getPassword() {
		return password;
	}

	@XmlElement(required=true)
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String asXml() throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(Doc.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		StringWriter writer = new StringWriter();
		jaxbMarshaller.marshal(this, writer);
		
		return writer.toString();
	}

	public String getTitle() {
		return title;
	}

	@XmlElement(name="title", required=false)
	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	@XmlElement(name="summary", required=false)
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	@XmlElement(name="content", required=false)
	public void setContent(String content) {
		this.content = content;
	}

	public XMLGregorianCalendar getPublishDate() {
		return publishDate;
	}

	@XmlSchemaType(name="dateTime")
	@XmlElement(name="publish_date", required=false)
	public void setPublishDate(XMLGregorianCalendar publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement(name="author", required=false)
	public void setAuthor(String author) {
		this.author = author;
	}
}
