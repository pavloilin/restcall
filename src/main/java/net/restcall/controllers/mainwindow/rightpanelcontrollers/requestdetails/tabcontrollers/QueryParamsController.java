package net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails.tabcontrollers;

import java.util.List;

import net.restcall.controllers.Updatable;
import net.restcall.gui.listeners.UiChangeListener;
import net.restcall.gui.pages.request.tabs.QueryParametersPanel;
import net.restcall.model.call.request.QueryParameters;
import net.restcall.model.util.SelectableNamedValue;

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
		List<SelectableNamedValue> list = queryParams.getParams();
		String[][] data = new String[list.size()][QueryParametersPanel.COLUMN_COUNT];
		for (int i = 0; i < list.size(); i++) {
//			String[] row = new String[QueryParametersPanel.COLUMN_COUNT];
			SelectableNamedValue item = list.get(i);
//			row[0] = item.getName();
//			row[1] = item.getValue();
//			row[2] = "";
//			data[i] = row;
			data[i][0] = item.getName();
			data[i][1] = item.getValue();
			data[i][2] = "";
		}
		queryParametersPanel.installNewData(data);

	}

	@Override
	public void uiChanged() {
		// TODO Auto-generated method stub

	}
}
