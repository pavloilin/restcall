package net.restcall.gui.pages.response;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResponsePanel extends JPanel{
	public ResponsePanel() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new JLabel("howdy"));
		add(new ResponseTabs());
		
	}
}
