package net.restcall.controllers.mainwindow.rightpanelcontrollers;

import net.restcall.gui.RightPanel;
import net.restcall.gui.pages.RequestPage;
import net.restcall.model.ModelItem;

public class RestcallTabController extends BaseTabController {

	public RestcallTabController(ModelItem modelItem, RightPanel rightPanel) {
		super(modelItem, rightPanel);
	}

	@Override
	public void open() {
		rightPanel.openTab(modelItem.getName(), new RequestPage(modelItem));
	}

}
