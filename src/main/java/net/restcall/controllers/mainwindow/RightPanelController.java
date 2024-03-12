package net.restcall.controllers.mainwindow;

import java.util.ArrayList;
import java.util.List;

import net.restcall.controllers.Updatable;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.BaseTabController;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.FolderTabController;
import net.restcall.controllers.mainwindow.rightpanelcontrollers.RestcallTabController;
import net.restcall.gui.RightPanel;
import net.restcall.gui.pages.RequestPage;
import net.restcall.model.ModelItem;
import net.restcall.model.RestCall;
import net.restcall.model.Workspace;

public class RightPanelController implements Updatable {

	private final List<BaseTabController> tabControllers = new ArrayList<>();
	private final Workspace workspace;
	private final RightPanel rightPanel;
	private int currentTabIndex = -1;

	public RightPanelController(Workspace workspace, RightPanel rightPanel) {
		this.workspace = workspace;
		this.rightPanel = rightPanel;
	}

	@Override
	public void updateUi() {
		if (rightPanel.isAllTabsPresent(tabControllers.size())) {
			BaseTabController tabController = tabControllers.get(tabControllers.size() - 1);
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
		updateUi();
	}

	private BaseTabController createTabController(ModelItem modelItem) {
		if (modelItem instanceof RestCall) {
			return new RestcallTabController(modelItem, rightPanel);
		} else {
			return new FolderTabController(modelItem, rightPanel);
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
