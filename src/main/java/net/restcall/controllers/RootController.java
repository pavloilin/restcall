package net.restcall.controllers;

import net.restcall.controllers.mainwindow.BottomPanelController;
import net.restcall.controllers.mainwindow.RightPanelController;
import net.restcall.controllers.mainwindow.SidebarController;
import net.restcall.gui.MainWindow;
import net.restcall.model.Workspace;

public class RootController implements Updatable {
	private Workspace workspace;
	private MainWindow mainWindow;
	private Updatable[] controllers;
	
	public RootController(){
		workspace = new Workspace();
		mainWindow = new MainWindow();
		controllers = new Updatable[] {
				new SidebarController(),
				new RightPanelController(),
				new BottomPanelController()
		};
	}
	
	public void show() {
		mainWindow.setVisible(true);
	}
	@Override
	public void updateUi() {
		for (Updatable controller: controllers) {
			controller.updateUi();
		}
	}
}
