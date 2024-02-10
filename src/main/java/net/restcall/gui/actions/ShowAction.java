package net.restcall.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import net.restcall.model.ModelItem;

public class ShowAction extends AbstractAction {
	
	private final ModelItem modelItem;

	public ShowAction(ModelItem modelItem) {
		super("Show");
		this.modelItem = modelItem;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("dombilibambas");

	}

}
