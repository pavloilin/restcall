package net.restcall.model;

import java.util.Date;

import net.restcall.model.call.Endpoint;
import net.restcall.model.call.Request;
import net.restcall.model.call.Response;

public class RestCall extends ModelItem {
	private Endpoint endpoint = new Endpoint();
	private Request request = new Request();
	private Response response = new Response();

	public RestCall (String name, String description, Date creationDate) {
		super(name, description, creationDate);
	}

	public Endpoint getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
}


