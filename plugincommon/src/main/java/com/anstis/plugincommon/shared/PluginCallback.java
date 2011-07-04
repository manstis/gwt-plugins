package com.anstis.plugincommon.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class PluginCallback<T> implements AsyncCallback<T> {

	public void onFailure(Throwable caught) {
	}

	public void onSuccess(T result) {
	}

}
