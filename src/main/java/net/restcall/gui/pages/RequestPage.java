package net.restcall.gui.pages;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import net.restcall.gui.pages.request.RequestParametersPanel;

public class RequestPage extends JSplitPane {
	public RequestPage(Object object) {
		super(JSplitPane.VERTICAL_SPLIT, new RequestParametersPanel(), new JLabel("Stroka"));
		setDividerLocation(175);
	}
}