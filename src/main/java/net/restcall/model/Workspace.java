package net.restcall.model;

import java.util.Date;
import java.util.List;

public class Workspace extends ModelItem {

	private List<Environment> environments;
	private List<RequestFolder> rootFolders;

	public Workspace(String name, String description, Date creationDate) {
		super(name, description, creationDate);
	}

	public void installFolders(List<RequestFolder> rootFolders) {
		this.rootFolders = rootFolders;
	}
	
	public List<RequestFolder> getRootFolders(){
		return rootFolders;
	}
}
