package net.restcall.gui.pages;

import javax.swing.JSplitPane;

import net.restcall.gui.pages.request.RequestParametersPanel;
import net.restcall.gui.pages.response.ResponsePanel;

public class RequestPage extends JSplitPane {
	
	private final RequestParametersPanel requestParamPanel = new RequestParametersPanel();
	private final ResponsePanel responsePanel = new ResponsePanel();
	
	public RequestPage(Object object) {
		setOrientation(JSplitPane.VERTICAL_SPLIT);
		setDividerLocation(175);
		setLeftComponent(requestParamPanel);
		setRightComponent(responsePanel);
	
		
	}
	public RequestParametersPanel requestParamPanel(){
		return requestParamPanel;
	}
}