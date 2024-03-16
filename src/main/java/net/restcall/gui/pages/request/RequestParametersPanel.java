package net.restcall.gui.pages.request;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RequestParametersPanel extends JPanel {
	
	private final HttpUrlInput httpUrlInput = new HttpUrlInput();
	private final HttpRequestParameterTabs parameterTabs = new HttpRequestParameterTabs();
	
	public RequestParametersPanel() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new JLabel("howdy"));
		add(httpUrlInput);
		add(parameterTabs);
		
	}

	public HttpUrlInput getHttpUrlInput() {
		return httpUrlInput;
	}
	
	public HttpRequestParameterTabs getParameterTabs() {
		return parameterTabs;
	}
	
	
}
