package net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails.tabcontrollers;

import net.restcall.controllers.Updatable;
import net.restcall.gui.listeners.UiChangeListener;
import net.restcall.gui.pages.request.tabs.QueryParametersPanel;
import net.restcall.model.call.request.QueryParameters;

public class QueryParamsController implements Updatable, UiChangeListener {
	
	private final QueryParameters queryParams;
	private final QueryParametersPanel queryParametersPanel;
	
	public QueryParamsController(QueryParameters queryParams, QueryParametersPanel queryParametersPanel) {
		this.queryParams = queryParams;
		this.queryParametersPanel = queryParametersPanel;	
		queryParametersPanel.registerChangeListener(this);
	}

	@Override
	public void updateUi() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uiChanged() {
		// TODO Auto-generated method stub
		
	}	
}
