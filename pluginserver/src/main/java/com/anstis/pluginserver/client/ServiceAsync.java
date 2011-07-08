package com.anstis.pluginserver.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

//TODO NOT USED
public interface ServiceAsync {
	void hello(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
