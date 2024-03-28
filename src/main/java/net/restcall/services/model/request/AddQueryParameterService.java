package net.restcall.services.model.request;

import java.util.List;

import net.restcall.model.util.SelectableNamedValue;

public class AddQueryParameterService {
	private List<SelectableNamedValue> list;

	public AddQueryParameterService(List<SelectableNamedValue> list) {
		this.list = list;

	}

	public void add() {
		if (list.size() == 0 || list.get(list.size() - 1).isNotEmpty()) {
			list.add(new SelectableNamedValue("", ""));
		}
	}
}
