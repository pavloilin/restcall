package net.restcall;

import java.awt.EventQueue;

import net.restcall.gui.MainWindow;

public class RestcallApplication {

	public static void main(String[] args) {
		var app = new RestcallApplication();
		app.startGui();
	}

	private void startGui() {
		EventQueue.invokeLater(this::showMainWindow);

	}

	private void showMainWindow() {
		MainWindow form = new MainWindow();
		form.setVisible(true);
	}
}
