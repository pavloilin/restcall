package net.restcall.model.call;

import net.restcall.model.call.request.Actions;
import net.restcall.model.call.request.Authentification;
import net.restcall.model.call.request.Body;
import net.restcall.model.call.request.Headers;
import net.restcall.model.call.request.Options;
import net.restcall.model.call.request.QueryParameters;

public class Request {
	
	private final QueryParameters queryParameters = new QueryParameters();
	private final Authentification authentification = new Authentification();
	private final Headers headers = new Headers();
	private final Body body = new Body();
	private final Actions preAction = new Actions();
	private final Actions postAction = new Actions();
	private final Options options = new Options();
	
	public QueryParameters getQueryParameters() {
		return queryParameters;
	}
	public Authentification getAuthentification() {
		return authentification;
	}
	public Headers getHeaders() {
		return headers;
	}
	public Body getBody() {
		return body;
	}
	public Actions getPreAction() {
		return preAction;
	}
	public Actions getPostAction() {
		return postAction;
	}
	public Options getOptions() {
		return options;
	}
}
