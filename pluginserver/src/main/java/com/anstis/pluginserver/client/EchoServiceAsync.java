package com.anstis.pluginserver.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EchoServiceAsync {
	void echo(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
