package com.anstis.plugin.client;

import com.anstis.plugincommon.client.ServerProxy;
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
				ServerProxy.echo(text.getText(), callback);
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
				ServerProxy.displayPerson(person);
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

}
