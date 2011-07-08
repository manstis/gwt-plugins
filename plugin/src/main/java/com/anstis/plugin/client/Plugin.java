package com.anstis.plugin.client;

import com.anstis.plugincommon.shared.Command;
import com.anstis.plugincommon.shared.Person;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Plugin implements EntryPoint {

	private final TextBox txtName = new TextBox();
	private final TextBox txtAge = new TextBox();
	private final TextBox result = new TextBox();
	private final Button btn = new Button("Hello");

	public void onModuleLoad() {

		txtName.setText("Michael");
		txtAge.setText("38");

		VerticalPanel container = new VerticalPanel();
		container.add(txtName);
		container.add(txtAge);
		container.add(result);
		container.add(btn);

		RootPanel.get("container").add(container);

		btn.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				String name = txtName.getText();
				int age = 0;
				try {
					age = Integer.valueOf(txtAge.getText());
				} catch (NumberFormatException nfe) {
				}
				Person p = Person.create(name, age);
				Command c = Command.create(p);
				result.setText(ServerProxy.executeCommand(c));
			}

		});

	}

}
