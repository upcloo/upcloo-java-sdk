package com.upcloo.client.http;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class UpCloo implements UpClooInterface
{
	private String siteKey;
	private String username;
	private String password;

	public final String UPDATE_URL = "http://%s.update.upcloo.com";
	public final String REPOSITORY_URL = "http://repository.upcloo.com/%s/%s.xml"; 
	public final String L_REPOSITORY_URL = "http://repository.upcloo.com/%s/%s/%s.xml";
	
	@Override
	public boolean index(com.upcloo.client.model.indexer.Doc model) {
		String url = String.format(UPDATE_URL, getUsername());
		
		model.setPassword(getPassword());
		model.setSitekey(getSiteKey());
		
		String xml = null;
		try {
			xml = model.asXml();
			
			return _index(url, xml);
		} catch (JAXBException e) {
			throw new RuntimeException("Unable to create XML message.");
		}
	}
	
	private boolean _index(String url, String xml)
	{
		try {
			HttpPut httpPut = new HttpPut(url);
			
			httpPut.setEntity(new StringEntity(xml, "UTF-8"));
			
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse response = httpclient.execute(httpPut);
			
			if (response.getStatusLine().getStatusCode() == 200) {
				return true;
			} 
		} catch (Exception e) {
			throw new RuntimeException("Unable to connect with remote host on address: " + url);
		}
		
		return false;
	}

	@Override
	public List<com.upcloo.client.model.getter.Doc> get(String id) {
		return get(id, null);
	}

	@Override
	public List<com.upcloo.client.model.getter.Doc> get(String id, String virtualSiteKey) {

		String url = String.format(REPOSITORY_URL, getSiteKey(), id);
		
		if (virtualSiteKey != null) {
			url = String.format(L_REPOSITORY_URL, getSiteKey(), virtualSiteKey, id);
		}
		
		try {
			HttpGet httpGet = new HttpGet(url);
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse response = httpclient.execute(httpGet);
			
			if (response.getStatusLine().getStatusCode() == 200) {
				//TODO: parse the reply...
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to get contents from remote host.");
		}
		
		return new ArrayList<com.upcloo.client.model.getter.Doc>();
	}

	public String getSiteKey() {
		return siteKey;
	}

	public void setSiteKey(String siteKey) {
		this.siteKey = siteKey;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
