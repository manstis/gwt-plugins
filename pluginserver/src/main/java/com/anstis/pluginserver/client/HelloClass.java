package com.anstis.pluginserver.client;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

@Export
@ExportPackage("jsc")
public class HelloClass implements Exportable {
	String prefix = "Hello: ";

	public String helloMethod(String name) {
		return prefix + " " + name;
	}

}
