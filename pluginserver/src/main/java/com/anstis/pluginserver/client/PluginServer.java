package com.anstis.pluginserver.client;

import com.anstis.plugincommon.shared.Command;
import com.anstis.plugincommon.shared.Person;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class PluginServer implements EntryPoint {

	private Server server = new Server();

	public void onModuleLoad() {
		GWT.create(Server.class);

		// Export the method when the application is ready
		exportServiceMethods(this);

	}

	//TODO use GWT-EXPORTER
	private native void exportServiceMethods(PluginServer instance) /*-{
		$wnd.executeCommand = function(c) {
			return instance.@com.anstis.pluginserver.client.PluginServer::executeCommand(Lcom/anstis/plugincommon/shared/Command;) (c);
		};
	}-*/;

	// Method that we want to use from javascript
	public String executeCommand(Command c) {
		Person p = c.getPerson();
		return "Hello " + p.getName() + " aged " + p.getAge();
	}

}
