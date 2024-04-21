package net.restcall.controllers.mainwindow.rightpanelcontrollers;

import javax.swing.JLabel;

import net.restcall.controllers.Context;
import net.restcall.gui.RightPanel;
import net.restcall.model.ModelItem;

public class FolderTabController extends BaseRightPanelTabController {

	private final Context context;

	public FolderTabController(Context context, ModelItem modelItem, RightPanel rightPanel) {
		super(modelItem, rightPanel);
		this.context = context;
	}

	@Override
	public void open() {
		rightPanel.openTab(modelItem.getName(), new JLabel(modelItem.getName()));
	}
}
