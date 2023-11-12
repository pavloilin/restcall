package net.restcall.gui.pages;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class RequestPage extends JSplitPane {
	public RequestPage(Object object) {
		super(JSplitPane.VERTICAL_SPLIT, new JLabel("ah."), new JLabel("Stroka"));
		setDividerLocation(175);
	}
}