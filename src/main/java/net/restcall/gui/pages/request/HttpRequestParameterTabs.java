package net.restcall.gui.pages.request;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import net.restcall.gui.pages.request.tabs.HttpBody;
import net.restcall.gui.pages.request.tabs.HttpHeaders;
import net.restcall.gui.pages.request.tabs.QueryParameters;

public class HttpRequestParameterTabs extends JTabbedPane {
	public HttpRequestParameterTabs() {
		super(TOP, SCROLL_TAB_LAYOUT);
		addTab("Query Parameters", new QueryParameters());
		addTab("Auth", new JLabel("dhsoif"));
		addTab("Headers", new HttpHeaders());
		addTab("Body", new HttpBody());
		addTab("Pre-Actions", new JLabel("dhsoif"));
		addTab("Post-Actions", new JLabel("dhsoif"));
		addTab("Settings", new JLabel("dhsoif"));
	}
}
