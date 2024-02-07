package net.restcall.model;

import java.util.Date;

public class ModelItem {
	private String name;
	private String description;
	private Date creationDate;
	public ModelItem(String name, String description, Date creationDate) {
		super();
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
	}
	
	public ModelItem() {
		
	}
	
	@Override
	public String toString() {
		return getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}
