package com.upcloo.client.model.getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="doc")
public class Doc {
	private String id;
	private String contentId;
	private String publishDate;
	
	private String title;
	private String summary;
	private String url;
	
	private String type;
	
	private Categories categories;
	
	private Tags tags;
	
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
	
	@XmlElement(name="description")
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getId() {
		return id;
	}

	@XmlAttribute(name="id")
	public void setId(String id) {
		this.id = id;
	}

	public String getContentId() {
		return contentId;
	}

	@XmlAttribute(name="content_id")
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getPublishDate() {
		return publishDate;
	}

	@XmlAttribute(name="pubDate")
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getUrl() {
		return url;
	}

	@XmlElement(name="url")
	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	@XmlElement(name="type")
	public void setType(String type) {
		this.type = type;
	}

	public Categories getCategories() {
		return categories;
	}

	@XmlElement(name="categories")
	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Tags getTags() {
		return tags;
	}

	@XmlElement(name="tags")
	public void setTags(Tags tags) {
		this.tags = tags;
	}

}
