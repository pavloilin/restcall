package net.restcall.controllers.mainwindow;

import java.util.ArrayList;
import java.util.List;

import net.restcall.controllers.Context;
import net.restcall.controllers.Updatable;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.BaseRightPanelTabController;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.FolderTabController;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.RestcallTabController;
import net.restcall.gui.RightPanel;
import net.restcall.model.ModelItem;
import net.restcall.model.RestCall;
import net.restcall.model.Workspace;

public class RightPanelController implements Updatable {

	private final Context context;
	private final List<BaseRightPanelTabController> tabControllers = new ArrayList<>();
	private final Workspace workspace;
	private final RightPanel rightPanel;
	private int currentTabIndex = -1;

	public RightPanelController(Context context, Workspace workspace, RightPanel rightPanel) {
		this.context = context;
		this.workspace = workspace;
		this.rightPanel = rightPanel;
	}

	@Override
	public void updateUi() {
		if (rightPanel.isAllTabsPresent(tabControllers.size())) {
			BaseRightPanelTabController tabController = tabControllers.get(tabControllers.size() - 1);
			tabController.open();
		}
		if (currentTabIndex >= 0) {
			rightPanel.switchToTab(currentTabIndex);
			tabControllers.get(currentTabIndex).updateUi();
		}
	}

	public void openModelItem(ModelItem modelItem) {
		currentTabIndex = findTabIndex(modelItem);

		if (currentTabIndex < 0) {
			tabControllers.add(createTabController(modelItem));
			currentTabIndex = tabControllers.size() - 1;
		}
		getContext().invalidateUi();
	}

	private Context getContext() {
		return context;
	}

	private BaseRightPanelTabController createTabController(ModelItem modelItem) {
		if (modelItem instanceof RestCall) {
			return new RestcallTabController(context, modelItem, rightPanel);
		} else {
			return new FolderTabController(context, modelItem, rightPanel);
		}

	}

	private int findTabIndex(ModelItem modelItem) {
		for (int i = 0; i < tabControllers.size(); i++) {
			if (tabControllers.get(i).ownModelItem(modelItem)) {
				return i;

			}
		}
		return -1;
	}

}
