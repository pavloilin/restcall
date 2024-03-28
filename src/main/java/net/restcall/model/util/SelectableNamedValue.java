package net.restcall.model.util;

public class SelectableNamedValue {
	private boolean selected;
	private String name;
	private String value;

	public SelectableNamedValue(String name, String value) {
		this.name = name;
		this.value = value;
		this.selected = true;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isNotEmpty() {
		return !"".equals(name) || !"".equals(value);
	}

}
