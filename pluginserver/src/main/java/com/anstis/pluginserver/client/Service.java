package com.anstis.pluginserver.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

//TODO NOT USED
@RemoteServiceRelativePath("service")
public interface Service extends RemoteService {
	String hello(String input) throws IllegalArgumentException;
}
