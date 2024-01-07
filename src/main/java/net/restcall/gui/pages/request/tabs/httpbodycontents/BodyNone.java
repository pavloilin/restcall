package net.restcall.gui.pages.request.tabs.httpbodycontents;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BodyNone extends JPanel{
	public BodyNone() {
		super(new BorderLayout(0, 0));
		var noneLabel = new JLabel ("This Request Does Not Have a Body");
		noneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(noneLabel, BorderLayout.CENTER);
	}
	
}
