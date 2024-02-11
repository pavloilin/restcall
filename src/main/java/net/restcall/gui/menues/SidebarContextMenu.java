package net.restcall.gui.menues;

import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

import net.restcall.controllers.mainwindow.RightPanelController;
import net.restcall.gui.actions.ShowAction;
import net.restcall.model.ModelItem;
import net.restcall.model.RequestFolder;

public class SidebarContextMenu {

	private final RightPanelController rightPanelController;
	
	public SidebarContextMenu(RightPanelController rightPanelController) {
		super();
		this.rightPanelController = rightPanelController;
	}

	private JPopupMenu create(Object model) {
		JPopupMenu menu = new JPopupMenu();
		menu.add(new ShowAction((ModelItem)model, rightPanelController));
		if (model instanceof RequestFolder) {
			menu.add("New Folder");
			menu.add("REST Call");
		}
		return menu;
	}

	public void open(MouseEvent mouseEvent, Object model) {
		JPopupMenu menu = create(model);
		menu.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
	}
}
