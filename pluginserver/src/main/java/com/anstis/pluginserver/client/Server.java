package com.anstis.pluginserver.client;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;

import com.anstis.plugincommon.shared.Command;
import com.anstis.plugincommon.shared.Person;
import com.google.gwt.user.client.Window;

public class Server implements Exportable {

	// Method that we want to use from JScript
	@Export
	public String executeCommand(Command c) {
		try {
			Person p = c.getPerson();
			return "Hello " + p.getName() + " aged " + p.getAge();
		} catch (Exception e) {
			Window.alert(e.getMessage());
		}
		return "";
	}

}
