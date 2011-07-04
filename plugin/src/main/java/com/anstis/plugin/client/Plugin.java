package com.anstis.plugin.client;

import com.anstis.plugincommon.shared.Person;
import com.anstis.plugincommon.shared.PluginCallback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Plugin implements EntryPoint {

	private final TextBox text = new TextBox();
	private final TextBox result = new TextBox();
	private final Button echoButton = new Button("Echo");
	private final Button personButton = new Button("Person");

	public void onModuleLoad() {

		text.setText("hello");

		VerticalPanel container = new VerticalPanel();
		container.add(text);
		container.add(result);
		container.add(echoButton);
		container.add(personButton);

		RootPanel.get("container").add(container);

		echoButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				PluginCallback<String> callback = getPluginCallback();
				Window.alert("Plugin.onModuleLoad.echoButton.onClick.callback is "
						+ (callback != null ? "not " : "") + "null");
				echo(text.getText(), callback);
			}

		});

		personButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				Person person = new Person();
				person.setName("Michael");
				person.setAge(38);
				Window.alert("Person="
						+ person
						+ ", Plugin.onModuleLoad.personButton.onClick.person is "
						+ (person != null ? "not " : "") + "null");
				displayPerson(person);
			}

		});

	}

	private PluginCallback<String> getPluginCallback() {
		return new PluginCallback<String>() {
			public void onFailure(Throwable caught) {
				Window.alert("Failure");
			}

			public void onSuccess(String text) {
				Window.alert("Success");
			}
		};
	}

	private native void echo(String text, PluginCallback<String> callback) /*-{
		alert("Plugin.echo.callback is " + (callback != null ? "not " : "") + "null");
		try {
			var pluginServer = new $wnd.com.anstis.pluginserver.CommonService();
			alert("callback=" + callback +", Plugin.echo.pluginServer = " + pluginServer);
			pluginServer.echo(text, callback);
		} catch(err) {
			alert(err);
		}
	}-*/;

	private native void displayPerson(Person person) /*-{
		alert("Plugin.displayPerson.person is " + (person != null ? "not " : "") + "null");
		try {
			var pluginServer = new $wnd.com.anstis.pluginserver.CommonService();
			alert("Person=" + person + ", Plugin.displayPerson.pluginServer = " + pluginServer);
			pluginServer.displayPerson(person);
		} catch(err) {
			alert(err);
		}
	}-*/;

}
