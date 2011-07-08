package com.anstis.plugincommon.shared;

import com.google.gwt.core.client.JavaScriptObject;

public class Person extends JavaScriptObject {

	protected Person() {
		// GWT JSO compliance requirement
	}
		
	// Use this factory method to create the entities
	public static Person create(String name, int age) {
		Person p = JavaScriptObject.createObject().cast();
		p.setName(name);
		p.setAge(age);
		return p;
	}

	public final native String getName() /*-{
		return this.name; 
	}-*/;

	public final native void setName(String name) /*-{
		this.name = name;
	}-*/;

	public final native int getAge() /*-{
		return this.age; 
	}-*/;

	public final native void setAge(int age) /*-{
		this.age = age;
	}-*/;

}
