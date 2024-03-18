package net.restcall.model.call.request;

import java.util.ArrayList;
import java.util.List;

import net.restcall.model.util.SelectableNamedValue;

public class QueryParameters {
	private List<SelectableNamedValue> params = new ArrayList<>();

	public void addParameter(String name, String value) {
		SelectableNamedValue namedValue = new SelectableNamedValue(name, value);
		params.add(namedValue);
	}

	public List<SelectableNamedValue> getParams() {
		return params;
	}
	
	
}
