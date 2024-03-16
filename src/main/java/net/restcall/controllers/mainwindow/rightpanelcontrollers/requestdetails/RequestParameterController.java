package net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails;

import net.restcall.controllers.BaseTabController;
import net.restcall.gui.pages.request.HttpRequestParameterTabs;

public class RequestParameterController extends BaseTabController {
	
	private final HttpRequestParameterTabs parameterTabs;

	public RequestParameterController(HttpRequestParameterTabs parameterTabs) {
		this.parameterTabs = parameterTabs;
	}
}
