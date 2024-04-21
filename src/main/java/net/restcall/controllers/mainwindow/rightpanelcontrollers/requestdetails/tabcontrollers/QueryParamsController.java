package net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails.tabcontrollers;

import java.util.List;
import java.util.Vector;

import javax.swing.Action;

import net.restcall.controllers.BaseUiChangeListener;
import net.restcall.controllers.Context;
import net.restcall.controllers.Updatable;
import net.restcall.gui.actions.CommandAction;
import net.restcall.gui.actions.CommandExecutor;
import net.restcall.gui.pages.request.tabs.QueryParametersPanel;
import net.restcall.model.call.request.QueryParameters;
import net.restcall.model.util.SelectableNamedValue;
import net.restcall.services.model.request.AddQueryParameterService;
import net.restcall.services.model.request.DeleteQueryParameterService;

public class QueryParamsController extends BaseUiChangeListener implements Updatable, CommandExecutor {

	private static final int ADD_NEW_QUERY_PARAM = 0;
	private static final int DELETE_QUERY_PARAM = 1;
	private final QueryParameters queryParams;
	private final QueryParametersPanel queryParametersPanel;

	public QueryParamsController(Context context, QueryParameters queryParams,
			QueryParametersPanel queryParametersPanel) {
		super(context);
		this.queryParams = queryParams;
		this.queryParametersPanel = queryParametersPanel;
		queryParametersPanel.registerChangeListener(this);
		queryParametersPanel.registerActions(
				new Action[] { new CommandAction(DELETE_QUERY_PARAM, "Delete Query Param", "/buttons/del.png", this),
						new CommandAction(ADD_NEW_QUERY_PARAM, "Add New Query Param", "/buttons/add.png", this)

				});
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
	public void applyUiChanges() {
			List<SelectableNamedValue> list = queryParams.getParams();
			Vector<Vector> uiData = queryParametersPanel.getData();
			for (int i = 0; i < uiData.size(); i++) {
				SelectableNamedValue item = list.get(i);
				Vector row = uiData.get(i);
				item.setName((String) row.get(0));
				item.setValue((String) row.get(1));
			}
			getContext().invalidateUi();
	}

	@Override
	public void execute(int commandId, String... params) {
		switch (commandId) {
		case ADD_NEW_QUERY_PARAM:
			new AddQueryParameterService(queryParams.getParams()).add();
			break;
		case DELETE_QUERY_PARAM:
			new DeleteQueryParameterService(queryParams.getParams()).delete(queryParametersPanel.getSelectedIndex());
		}
		getContext().invalidateUi();
	}
}
