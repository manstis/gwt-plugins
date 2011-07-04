package com.anstis.pluginserver.server;

import com.anstis.pluginserver.client.EchoService;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class EchoServiceImpl extends RemoteServiceServlet implements
		EchoService {

	public String echo(String input) throws IllegalArgumentException {
		Window.alert("input=" + input);
		return "[echo]:" + input;
	}

}
