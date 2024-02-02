package net.restcall.model;

import java.util.Date;

import net.restcall.model.call.Endpoint;
import net.restcall.model.call.Request;
import net.restcall.model.call.Response;

public class RestCall extends ModelItem {
	private Endpoint endpoint;
	private Request request;
	private Response response;

	public RestCall(String name, String description, Date creationDate) {
		super(name, description, creationDate);
	}
}
