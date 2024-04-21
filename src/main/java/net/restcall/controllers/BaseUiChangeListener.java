package net.restcall.controllers;

import net.restcall.gui.listeners.UiChangeListener;

public abstract class BaseUiChangeListener implements UiChangeListener {
	private final Context context;

	public BaseUiChangeListener(Context context) {
		this.context = context;
	}
	
	protected abstract void applyUiChanges();

	@Override
	public void uiChanged() {
		if (!context.isUpdating()) {
			applyUiChanges();	
		}
	}

	protected Context getContext() {
		return context;
	}
	
	
}
