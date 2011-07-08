package com.anstis.pluginserver.server;

import com.anstis.pluginserver.client.Service;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

//TODO NOT USED
@SuppressWarnings("serial")
public class ServiceImpl extends RemoteServiceServlet implements Service {

	public String hello(String input) throws IllegalArgumentException {
		return "[hello service]: Hello " + input;
	}

}
