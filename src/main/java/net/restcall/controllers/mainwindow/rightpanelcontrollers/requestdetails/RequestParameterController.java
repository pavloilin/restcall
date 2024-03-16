package net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails;

import net.restcall.controllers.BaseTabController;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails.tabcontrollers.QueryParamsController;
import net.restcall.gui.pages.request.HttpRequestParameterTabs;
import net.restcall.model.call.Request;

public class RequestParameterController extends BaseTabController {
	
	private final Request request;
	
	private final HttpRequestParameterTabs parameterTabs;

	public RequestParameterController(Request request, HttpRequestParameterTabs parameterTabs) {
		this.request = request;
		this.parameterTabs = parameterTabs;
		registerController(new QueryParamsController(request.getQueryParameters(), parameterTabs.getQueryParametersPanel()));
	}
}
