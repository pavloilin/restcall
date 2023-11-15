package net.restcall.gui.pages.request;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class HttpRequestParameterTabs extends JTabbedPane {
	public HttpRequestParameterTabs() {
		super(TOP, SCROLL_TAB_LAYOUT);
		addTab("Parameters", new JLabel("dhsoif"));
		addTab("Auth", new JLabel("dhsoif"));
		addTab("Headers", new JLabel("dhsoif"));
		addTab("Body", new JLabel("dhsoif"));
		addTab("Pre-Actions", new JLabel("dhsoif"));
		addTab("Post-Actions", new JLabel("dhsoif"));
		addTab("Settings", new JLabel("dhsoif"));
	}
}
