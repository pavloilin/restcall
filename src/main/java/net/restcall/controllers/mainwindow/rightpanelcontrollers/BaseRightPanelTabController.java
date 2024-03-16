package net.restcall.controllers.mainwindow.rightpanelcontrollers;

import java.util.ArrayList;
import java.util.List;

import net.restcall.controllers.BaseTabController;
import net.restcall.controllers.Updatable;
import net.restcall.gui.RightPanel;
import net.restcall.model.ModelItem;

public abstract class BaseRightPanelTabController extends BaseTabController {
	protected final ModelItem modelItem;
	protected final RightPanel rightPanel;

	public abstract void open();

	public BaseRightPanelTabController(ModelItem modelItem, RightPanel rightPanel) {
		this.modelItem = modelItem;
		this.rightPanel = rightPanel;
	}

	

	public boolean ownModelItem(ModelItem modelItem) {
		return this.modelItem.equals(modelItem);
	}

	

}
