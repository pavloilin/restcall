package net.restcall.model;

import java.util.Date;
import java.util.SortedMap;

public class Environment extends ModelItem{

	private SortedMap<String, String> parameters;
	
	public Environment(String name, String description, Date creationDate) {
		super(name, description, creationDate);
	}
}
