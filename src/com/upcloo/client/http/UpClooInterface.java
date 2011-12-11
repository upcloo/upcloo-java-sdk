package com.upcloo.client.http;

import java.util.List;

import com.upcloo.client.model.Base;

public interface UpClooInterface {
	public boolean index();
	public List<Base> get(String id);
	public List<Base> get(String id, String virtualSiteKey);
}
