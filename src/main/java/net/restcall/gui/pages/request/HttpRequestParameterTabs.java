package net.restcall.gui.pages.request;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import net.restcall.gui.pages.request.tabs.HttpBodyPanel;
import net.restcall.gui.pages.request.tabs.HttpHeadersPanel;
import net.restcall.gui.pages.request.tabs.QueryParametersPanel;

public class HttpRequestParameterTabs extends JTabbedPane {
	
	private final QueryParametersPanel queryParametersPanel = new QueryParametersPanel();
	
	public HttpRequestParameterTabs() {
		super(TOP, SCROLL_TAB_LAYOUT);
		addTab("Query Parameters", queryParametersPanel);
		addTab("Auth", new JLabel("dhsoif"));
		addTab("Headers", new HttpHeadersPanel());
		addTab("Body", new HttpBodyPanel());
		addTab("Pre-Actions", new JLabel("dhsoif"));
		addTab("Post-Actions", new JLabel("dhsoif"));
		addTab("Settings", new JLabel("dhsoif"));	
	}

	public QueryParametersPanel getQueryParametersPanel() {
		return queryParametersPanel;
	}
	
}
