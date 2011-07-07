package com.anstis.pluginserver.client;

import com.anstis.plugincommon.client.ServerProxy;
import com.anstis.plugincommon.shared.Person;
import com.anstis.plugincommon.shared.PluginCallback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class PluginServer implements EntryPoint {

	public void onModuleLoad() {
		GWT.create(Server.class);
		onLoadImpl();

		RootPanel.get("container").add(getPersonButton());
		RootPanel.get("container").add(getProxyPersonButton());
		RootPanel.get("container").add(getEchoButton());
	}

	private native void onLoadImpl() /*-{
		if ($wnd.jscOnLoad && typeof $wnd.jscOnLoad == 'function') $wnd.jscOnLoad();
	}-*/;

	private Button getPersonButton() {
		Button btn = new Button("Local Person");
		btn.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				Person p = new Person();
				p.setName("Michael");
				p.setAge(38);
				displayPerson(p);
			}

		});
		return btn;
	}

	private native void displayPerson(Person person) /*-{
		try {
			pluginServer.displayPerson(person);
		} catch(err) {
			alert(err);
		}
	}-*/;

	private Button getProxyPersonButton() {
		Button btn = new Button("Local Person (proxy)");
		btn.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				Person p = new Person();
				p.setName("Michael");
				p.setAge(38);
				ServerProxy.displayPerson(p );
			}

		});
		return btn;
	}

	private Button getEchoButton() {
		Button btn = new Button("Local Echo (proxy)");
		btn.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				ServerProxy.echo("text", new PluginCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
					}

					@Override
					public void onSuccess(String result) {
						Window.alert(result);
					}

				});
			}

		});
		return btn;
	}

}
