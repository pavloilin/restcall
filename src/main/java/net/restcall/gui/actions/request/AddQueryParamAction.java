package net.restcall.gui.actions.request;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AddQueryParamAction extends AbstractAction {

	public AddQueryParamAction() {
		super("", new ImageIcon(AddQueryParamAction.class.getResource("/buttons/add.png")));
		putValue(SHORT_DESCRIPTION, "Add New Query Param");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog((Component) e.getSource(), "Add Query Param");

	}

}
