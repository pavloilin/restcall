package net.restcall.controllers;

import java.util.Date;

import javax.swing.tree.DefaultMutableTreeNode;

import net.restcall.controllers.mainwindow.BottomPanelController;
import net.restcall.controllers.mainwindow.RightPanelController;
import net.restcall.controllers.mainwindow.SidebarController;
import net.restcall.gui.MainWindow;
import net.restcall.gui.actions.ShowAction;
import net.restcall.gui.listeners.DoubleClickNodeListener;
import net.restcall.gui.menues.SidebarContextMenu;
import net.restcall.model.ModelItem;
import net.restcall.model.Workspace;
import net.restcall.services.model.ModelLoader;

public class RootController implements Updatable, DoubleClickNodeListener {
	private final Workspace workspace;
	private final MainWindow mainWindow;
	private final Updatable[] controllers;
	private final RightPanelController rightPanelController;
	private final Context context;

	public RootController() {
		this.context= new Context(this);
		workspace = new Workspace("workplace", "", new Date());
		mainWindow = new MainWindow();
		var sidebarPanel = mainWindow.getSidebarPanel();
		rightPanelController = new RightPanelController(context, workspace, mainWindow.getRightPanel());
		sidebarPanel.setSidebarContextMenu(new SidebarContextMenu(rightPanelController));
		sidebarPanel.registerNodeActivationListener(this);
		controllers = new Updatable[] { new SidebarController(context, workspace, sidebarPanel), rightPanelController,
				new BottomPanelController(context)
				
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
		for (Updatable controller : controllers) {
			controller.updateUi();
		}
	}

	@Override
	public void nodeActivated(DefaultMutableTreeNode selectedNode) {
		new ShowAction((ModelItem) selectedNode.getUserObject(), rightPanelController).actionPerformed(null);
	}
}
