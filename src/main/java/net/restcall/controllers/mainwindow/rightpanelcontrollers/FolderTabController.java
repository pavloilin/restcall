package net.restcall.controllers.mainwindow.rightpanelcontrollers;

import javax.swing.JLabel;

import net.restcall.gui.RightPanel;
import net.restcall.model.ModelItem;

public class FolderTabController extends BaseRightPanelTabController {

	public FolderTabController(ModelItem modelItem, RightPanel rightPanel) {
		super(modelItem, rightPanel);
	}

	@Override
	public void open() {
		rightPanel.openTab(modelItem.getName(), new JLabel(modelItem.getName()));
	}
}
