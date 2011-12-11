package com.upcloo.client.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="model")
public class Doc {
	private String id;
	private String sitekey;
	private String password;

	public String getId() {
		return id;
	}

	@XmlElement(required=true)
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
}
