package net.restcall.controllers;

import java.util.Date;

import net.restcall.controllers.mainwindow.BottomPanelController;
import net.restcall.controllers.mainwindow.RightPanelController;
import net.restcall.controllers.mainwindow.SidebarController;
import net.restcall.gui.MainWindow;
import net.restcall.gui.menues.SidebarContextMenu;
import net.restcall.model.Workspace;
import net.restcall.services.model.ModelLoader;

public class RootController implements Updatable {
	private Workspace workspace;
	private MainWindow mainWindow;
	private Updatable[] controllers;
	
	public RootController(){
		workspace = new Workspace("workspace1","",new Date());
		mainWindow = new MainWindow();
		var sidebarPanel = mainWindow.getSidebarPanel();
		RightPanelController rightPanelController = new RightPanelController(workspace, mainWindow.getRightPanel());
		sidebarPanel.setSidebarContextMenu(new SidebarContextMenu(rightPanelController));
		controllers = new Updatable[] {
				new SidebarController(workspace, sidebarPanel),
				rightPanelController,
				new BottomPanelController()
				
				
		};
	}
	
	public void show() {
		ModelLoader modelLoader = new ModelLoader();
		modelLoader.load(workspace);
		
		updateUi();
		mainWindow.setVisible(true);
	}
	@Override
	public void updateUi() {
		for (Updatable controller: controllers) {
			controller.updateUi();
		}
	}
}
