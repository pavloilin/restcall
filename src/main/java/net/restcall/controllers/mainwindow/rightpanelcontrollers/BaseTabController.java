package net.restcall.controllers.mainwindow.rightpanelcontrollers;

import java.util.ArrayList;
import java.util.List;

import net.restcall.controllers.Updatable;
import net.restcall.gui.RightPanel;
import net.restcall.model.ModelItem;

public abstract class BaseTabController implements Updatable{
	private final List<Updatable> controllers = new ArrayList<>();
	protected final ModelItem modelItem;
	protected final RightPanel rightPanel;

	public abstract void open();

	 
	
	public BaseTabController(ModelItem modelItem, RightPanel rightPanel) {
		this.modelItem = modelItem;
		this.rightPanel = rightPanel;
	}
	
	protected void registerController(Updatable updatable) {
		controllers.add(updatable);
	}
	
	
	public boolean ownModelItem(ModelItem modelItem) {
		return this.modelItem.equals(modelItem);
	}
	
	@Override
	public void updateUi() {
		for (Updatable controller : controllers) {
			controller.updateUi();
		}
	}
	
}
