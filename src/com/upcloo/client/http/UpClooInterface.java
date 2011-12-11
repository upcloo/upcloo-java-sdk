package com.upcloo.client.http;

import java.util.List;

public interface UpClooInterface {
	
	public void setUsername(String username);
	public void setPassword(String password);
	public void setSiteKey(String siteKey);
	
	public boolean index(com.upcloo.client.model.indexer.Doc model) throws RuntimeException;
	public List<com.upcloo.client.model.getter.Doc> get(String id) throws RuntimeException;
	public List<com.upcloo.client.model.getter.Doc> get(String id, String virtualSiteKey) throws RuntimeException;
}
