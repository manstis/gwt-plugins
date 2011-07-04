package com.anstis.pluginserver.client;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;

import com.anstis.plugincommon.shared.Person;
import com.anstis.plugincommon.shared.PluginCallback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

@Export
public class CommonService implements Exportable {

	private static final EchoServiceAsync echoService = GWT
			.create(EchoService.class);

	public void echo(String input, PluginCallback<String> callback) {
		Window.alert("CommonService.echo.input is "
				+ (input != null ? "not " : "") + "null"
				+ (input != null ? " [" + input + "]" : ""));
		Window.alert("CommonService.echo.callback is "
				+ (callback != null ? "not " : "") + "null");
		try {
			echoService.echo(input, callback);
		} catch (Exception e) {
			e.fillInStackTrace();
			e.printStackTrace(System.out);
			Window.alert(e.getMessage());
		}
	}

	public void displayPerson(Person person) {
		Window.alert("CommonService.displayPerson.person is "
				+ (person != null ? "not " : "") + "null");
		Window.alert("Person=" + person + ", Name=" + person.getName()
				+ ", age=" + person.getAge() + ", display=" + person.display());
	}

}
