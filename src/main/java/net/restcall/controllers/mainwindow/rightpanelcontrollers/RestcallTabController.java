package net.restcall.controllers.mainwindow.rightpanelcontrollers;

import net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails.RequestUrlController;
import net.restcall.gui.RightPanel;
import net.restcall.gui.pages.RequestPage;
import net.restcall.model.ModelItem;
import net.restcall.model.RestCall;

public class RestcallTabController extends BaseTabController {

	private final RequestPage requestPage;
	
	public RestcallTabController(ModelItem modelItem, RightPanel rightPanel) {
		super(modelItem, rightPanel);
		requestPage = new RequestPage(modelItem);
		RestCall restcall = (RestCall) modelItem;
		registerController(new RequestUrlController(restcall.getEndpoint(), requestPage.requestParamPanel().getHttpUrlInput()));
	}

	@Override
	public void open() {
		rightPanel.openTab(modelItem.getName(), requestPage);
	}


}
