package net.restcall.model;

import java.util.Date;
import java.util.List;

public class RequestFolder extends ModelItem {
	private List<RequestFolder> folders;
	private List<RestCall> restCalls;
	
	public RequestFolder() {
		super();
	}

	public RequestFolder(String name, String description, Date creationDate) {
		super(name, description, creationDate);
	}

	public RequestFolder(String name) {
		super(name, null, null);
	}

	public List<RequestFolder> getFolders() {
		return folders;
	}

	public void setFolders(List<RequestFolder> folders) {
		this.folders = folders;
	}

	public List<RestCall> getRestCalls() {
		return restCalls;
	}

	public void setRestCalls(List<RestCall> restCalls) {
		this.restCalls = restCalls;
	}
	
	
}
