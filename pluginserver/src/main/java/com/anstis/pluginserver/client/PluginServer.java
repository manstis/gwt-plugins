package com.anstis.pluginserver.client;

import com.anstis.plugincommon.shared.Person;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class PluginServer implements EntryPoint {

	public void onModuleLoad() {
		GWT.create(CommonService.class);
		onLoadImpl();
		
		RootPanel.get("container").add(getPersonButton());
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
	alert("PluginServer.displayPerson.person is " + (person != null ? "not " : "") + "null");
	try {
		var pluginServer = new $wnd.com.anstis.pluginserver.CommonService();
		alert("PluginServer.displayPerson.pluginServer = " + pluginServer);
    	pluginServer.displayPerson(person);
	} catch(err) {
		alert(err);
	}
	}-*/;
	
}
