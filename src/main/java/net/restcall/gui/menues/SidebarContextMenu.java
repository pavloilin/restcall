package net.restcall.gui.menues;

import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

import net.restcall.gui.actions.ShowAction;
import net.restcall.model.ModelItem;
import net.restcall.model.RequestFolder;

public class SidebarContextMenu extends JPopupMenu {

	public SidebarContextMenu(DefaultMutableTreeNode selectedNode) {
		add(new ShowAction((ModelItem)selectedNode.getUserObject()));
		if (selectedNode.getUserObject() instanceof RequestFolder) {
			add("New Folder");
			add("REST Call");
		}
	}
}
