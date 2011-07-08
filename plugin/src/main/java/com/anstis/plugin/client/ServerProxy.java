package com.anstis.plugin.client;

import com.anstis.plugincommon.shared.Command;

public class ServerProxy {

	public static native String executeCommand(Command c) /*-{
		try {
			var server = new $wnd.com.anstis.pluginserver.Server();
			return server.executeCommand(c);
		} catch(err) {
			alert(err);
		}
	}-*/;

}
