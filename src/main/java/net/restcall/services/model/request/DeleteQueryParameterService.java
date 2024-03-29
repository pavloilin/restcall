package net.restcall.services.model.request;

import java.util.List;

import net.restcall.model.util.SelectableNamedValue;

public class DeleteQueryParameterService {

	private List<SelectableNamedValue> list;

	public DeleteQueryParameterService(List<SelectableNamedValue> list) {
		this.list = list;
	}

	public void delete(int selectedIndex) {
		if (selectedIndex >= 0) {
			list.remove(selectedIndex);
		}
	}
}
