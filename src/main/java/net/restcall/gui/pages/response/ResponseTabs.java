package net.restcall.gui.pages.response;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class ResponseTabs extends JTabbedPane {
	public ResponseTabs() {
		super(BOTTOM, SCROLL_TAB_LAYOUT);
		addTab("Body", new JLabel("dhsoif"));
		addTab("Cookies", new JLabel("dhsoif"));
		addTab("Headers", new JLabel("dhsoif"));
		addTab("Test Results", new JLabel("dhsoif"));
	}
}
