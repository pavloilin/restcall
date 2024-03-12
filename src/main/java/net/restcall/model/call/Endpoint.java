package net.restcall.model.call;

import net.restcall.consts.RcConsts.RequestTypes;

public class Endpoint {
	private RequestTypes method;
	private String url;

	public RequestTypes getMethod() {
		return method;
	}

	public void setMethod(RequestTypes method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
