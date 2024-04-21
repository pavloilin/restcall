package net.restcall.controllers;

import javax.swing.SwingUtilities;

public class Context {
	private final Updatable root;
	private boolean updating;

	public Context(Updatable root) {
		this.root = root;
	}

	public boolean isUpdating() {
		return updating;
	}

	public void invalidateUi() {
		SwingUtilities.invokeLater(() -> {
			try {
				updating = true;
				root.updateUi();
			} finally {
				updating = false;
			}
		});
	}

}
