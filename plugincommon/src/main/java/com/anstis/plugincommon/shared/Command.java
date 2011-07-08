package com.anstis.plugincommon.shared;

import com.google.gwt.core.client.JavaScriptObject;

public class Command extends JavaScriptObject {

	protected Command() {
		// GWT JSO compliance requirement
	}
		
	// Use this factory method to create the entities
	public static Command create(Person person) {
		Command c = JavaScriptObject.createObject().cast();
		c.setPerson(person);
		return c;
	}

	public final native Person getPerson() /*-{
		return this.person; 
	}-*/;

	public final native void setPerson(Person person) /*-{
		this.person = person;
	}-*/;
	
}
