package com.anstis.pluginserver.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

//TODO NOT USED
public class Server {

	private static final ServiceAsync service = GWT.create(Service.class);

	public void hello(String input, AsyncCallback<String> callback) {
		try {
			service.hello(input, callback);
		} catch (Exception e) {
			e.fillInStackTrace();
			e.printStackTrace(System.out);
			Window.alert(e.getMessage());
		}
	}

}
