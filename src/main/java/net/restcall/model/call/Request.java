package net.restcall.model.call;

import net.restcall.model.call.request.Actions;
import net.restcall.model.call.request.Authentification;
import net.restcall.model.call.request.Body;
import net.restcall.model.call.request.Headers;
import net.restcall.model.call.request.Options;
import net.restcall.model.call.request.QueryParameters;

public class Request {
	private QueryParameters queryParameters;
	private Authentification authentification;
	private Headers headers;
	private Body body;
	private Actions preAction;
	private Actions postAction;
	private Options options;
	
}
