package com.anstis.plugincommon.client;

import com.anstis.plugincommon.shared.Command;

public class ServerProxy {

	public static native String executeCommand(Command c) /*-{
		try {
			return $wnd.executeCommand(c);
		} catch(e) {
			$wnd.alert(e);
		}
	}-*/;

}
