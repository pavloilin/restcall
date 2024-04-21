package net.restcall.controllers.mainwindow;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import net.restcall.controllers.Context;
import net.restcall.controllers.Updatable;
import net.restcall.gui.Sidebar;
import net.restcall.model.RequestFolder;
import net.restcall.model.RestCall;
import net.restcall.model.Workspace;

public class SidebarController implements Updatable {

	private final Workspace workspace;
	private final Sidebar sidebarPanel;
	private final Context context;

	public SidebarController(Context context, Workspace workspace, Sidebar sidebarPanel) {
		this.context = context;
		this.workspace = workspace;
		this.sidebarPanel = sidebarPanel;
	}

	@Override
	public void updateUi() {
		List<RequestFolder> folders = workspace.getRootFolders();

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(workspace.getName());

		addNodeChildren(folders, null, root);

		TreeModel model = new DefaultTreeModel(root);
		sidebarPanel.setModel(model);

	}

	private void addNodeChildren(List<RequestFolder> folders, List<RestCall> restCalls, DefaultMutableTreeNode parent) {
		if (folders != null) {
			for (RequestFolder rf : folders) {
				DefaultMutableTreeNode branch = new DefaultMutableTreeNode(rf) {
					@Override
					public boolean isLeaf() {
						return false;
					}
				};
				parent.add(branch);
				addNodeChildren(rf.getFolders(), rf.getRestCalls(), branch);
			}
		}
		if (restCalls != null) {
			for (RestCall rc : restCalls) {
				DefaultMutableTreeNode branch = new DefaultMutableTreeNode(rc){@Override
				public boolean isLeaf() {
					return true;
				}};
				parent.add(branch);
			}
		}
	}
}
