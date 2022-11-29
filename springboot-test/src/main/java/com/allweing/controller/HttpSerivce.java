package com.allweing.controller;

import fi.iki.elonen.NanoHTTPD;

/**
 * @auther: zzzgyu
 */

public class HttpSerivce extends NanoHTTPD {
	public HttpSerivce( String hostname, int port ) {
		super(hostname, port);
	}
}
