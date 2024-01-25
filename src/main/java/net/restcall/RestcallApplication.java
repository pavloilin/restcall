package net.restcall;

import java.awt.EventQueue;

import net.restcall.controllers.RootController;

public class RestcallApplication {

	public static void main(String[] args) {
		var app = new RestcallApplication();
		app.startGui();
	}

	private void startGui() {
		var rootController = new RootController();
		EventQueue.invokeLater(rootController::show);

	}
}
