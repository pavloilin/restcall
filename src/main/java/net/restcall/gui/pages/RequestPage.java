package net.restcall.gui.pages;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class RequestPage extends JPanel {
	public RequestPage(Object object) {
		Component responseParameters = new JLabel("Stroka");
		Component requestParameters = new JLabel("ah.");
		add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, requestParameters, responseParameters));
	}
}
