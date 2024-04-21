package net.restcall.controllers.mainwindow.rightpanelcontrollers;

import net.restcall.controllers.Context;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails.RequestParameterController;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails.RequestUrlController;
import net.restcall.gui.RightPanel;
import net.restcall.gui.pages.RequestPage;
import net.restcall.model.ModelItem;
import net.restcall.model.RestCall;

public class RestcallTabController extends BaseRightPanelTabController {

	private final RequestPage requestPage;
	private final Context context;

	public RestcallTabController(Context context, ModelItem modelItem, RightPanel rightPanel) {
		super(modelItem, rightPanel);
		this.context = context;
		requestPage = new RequestPage(modelItem);
		RestCall restcall = (RestCall) modelItem;
		registerController(new RequestUrlController(context, restcall.getEndpoint(), restcall.getRequest().getQueryParameters(),
				requestPage.requestParamPanel().getHttpUrlInput()));
		registerController(new RequestParameterController(context, restcall.getRequest(),
				requestPage.requestParamPanel().getParameterTabs()));

	}

	@Override
	public void open() {
		rightPanel.openTab(modelItem.getName(), requestPage);
	}

}
