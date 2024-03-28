	package net.restcall.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import net.restcall.controllers.mainwindow.RightPanelController;
import net.restcall.model.ModelItem;

public class ShowAction extends AbstractAction {
	
	private final ModelItem modelItem;
	private RightPanelController rightPanelController;

	public ShowAction(ModelItem modelItem, RightPanelController rightPanelController) {
		super("Show");
		this.modelItem = modelItem;
		this.rightPanelController = rightPanelController;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		rightPanelController.openModelItem(modelItem);
	}

}
