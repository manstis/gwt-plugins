package com.anstis.plugincommon.client;

import com.anstis.plugincommon.shared.Person;
import com.anstis.plugincommon.shared.PluginCallback;

public class ServerProxy {

	public static native void echo(String text, PluginCallback<String> callback) /*-{
		alert("ServerProxy.echo.callback is " + (callback != null ? "not " : "") + "null");
		try {
			var pluginServer = new $wnd.com.anstis.pluginserver.Server();
			alert("callback=" + callback +", Plugin.echo.pluginServer = " + pluginServer);
			pluginServer.echo(text, callback);
		} catch(err) {
			alert(err);
		}
	}-*/;

	public static native void displayPerson(Person person) /*-{
		alert("ServerProxy.displayPerson.person is " + (person != null ? "not " : "") + "null");
		try {
			var pluginServer = new $wnd.com.anstis.pluginserver.Server();
			alert("Person=" + person + ", Plugin.displayPerson.pluginServer = " + pluginServer);
			pluginServer.displayPerson(person);
		} catch(err) {
			alert(err);
		}
	}-*/;
	
}
