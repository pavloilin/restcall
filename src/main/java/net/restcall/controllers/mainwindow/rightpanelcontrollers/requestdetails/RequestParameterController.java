package net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails;

import net.restcall.controllers.BaseTabController;
import net.restcall.controllers.Context;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails.tabcontrollers.QueryParamsController;
import net.restcall.gui.pages.request.HttpRequestParameterTabs;
import net.restcall.model.call.Request;

public class RequestParameterController extends BaseTabController {

	private final Request request;

	private final HttpRequestParameterTabs parameterTabs;

	private final Context context;

	public RequestParameterController(Context context, Request request, HttpRequestParameterTabs parameterTabs) {
		this.context = context;
		this.request = request;
		this.parameterTabs = parameterTabs;
		registerController(
				new QueryParamsController(context, request.getQueryParameters(), parameterTabs.getQueryParametersPanel()));
	}
}
