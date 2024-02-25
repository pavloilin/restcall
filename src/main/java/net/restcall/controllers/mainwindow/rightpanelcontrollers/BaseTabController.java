package net.restcall.controllers.mainwindow.rightpanelcontrollers;

import net.restcall.gui.RightPanel;
import net.restcall.model.ModelItem;

public abstract class BaseTabController {
	protected final ModelItem modelItem;
	protected final RightPanel rightPanel;

	public abstract void open();

	public BaseTabController(ModelItem modelItem, RightPanel rightPanel) {
		this.modelItem = modelItem;
		this.rightPanel = rightPanel;
	}

	public boolean ownModelItem(ModelItem modelItem) {
		return this.modelItem.equals(modelItem);
	}

	
}
