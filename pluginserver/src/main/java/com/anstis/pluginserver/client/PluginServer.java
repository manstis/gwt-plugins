package com.anstis.pluginserver.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class PluginServer implements EntryPoint {

	public void onModuleLoad() {
		GWT.create(Server.class);
	}

}
