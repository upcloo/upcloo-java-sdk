package com.upcloo.client.http;

import java.util.List;

import com.upcloo.client.model.Base;
import com.upcloo.client.model.Doc;

public interface UpClooInterface {
	
	public void setUsername(String username);
	public void setPassword(String password);
	public void setSiteKey(String siteKey);
	
	public boolean index(Doc model) throws RuntimeException;
	public List<Base> get(String id) throws RuntimeException;
	public List<Base> get(String id, String virtualSiteKey) throws RuntimeException;
}
