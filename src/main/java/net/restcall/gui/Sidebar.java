package net.restcall.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import net.restcall.gui.listeners.DoubleClickNodeListener;
import net.restcall.gui.menues.SidebarContextMenu;

public class Sidebar extends JTree {

	private SidebarContextMenu sidebarContextMenu;

	public Sidebar() {
		// DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
//		DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("RestCall 1");
//		DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("RestCall 2");
//		DefaultMutableTreeNode branch3 = new DefaultMutableTreeNode("RestCall 3");
//
//		root.add(branch1);
//		root.add(branch2);
//		root.add(branch3);
//
//		JTree sidebarPanel = new JTree(root);
//		sidebarPanel.setLayout(new BorderLayout());
//
//		sidebarPanel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (e.getClickCount() > 1) {
//					openRequestTab(sidebarPanel);
//				}
//			}
//
//			private void openRequestTab(JTree sidebarPanel) {
//				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) sidebarPanel
//						.getLastSelectedPathComponent();
//				if (selectedNode != null && selectedNode.isLeaf()) {
//					openUpRequestPage(selectedNode);
//				}
//			}
//		});
//	}}
		registerContextMenu();
	}

	public void setSidebarContextMenu(SidebarContextMenu sidebarContextMenu) {
		this.sidebarContextMenu = sidebarContextMenu;
	}

	public void registerContextMenu() {
		MouseListener mouseListener = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent mouseEvent) {
				handleContextMenu(mouseEvent);
			}

			@Override
			public void mouseReleased(MouseEvent mouseEvent) {
				handleContextMenu(mouseEvent);
			}
		};

		this.addMouseListener(mouseListener);
	}

	public void registerNodeActivationListener(DoubleClickNodeListener listener) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 1) {
					activateNode();
				}
			}

			private void activateNode() {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) Sidebar.this
						.getLastSelectedPathComponent();
				if (selectedNode != null) {
					listener.nodeActivated(selectedNode);
				}
			}
		});
	}

	private void handleContextMenu(MouseEvent mouseEvent) {
		if (mouseEvent.isPopupTrigger()) {
			// Use getPathForLocation to get the TreePath at the mouse event location
			TreePath path = getPathForLocation(mouseEvent.getX(), mouseEvent.getY());

			// Check if the path is not null
			if (path != null && sidebarContextMenu != null) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();

				// Now you have the selected node (selectedNode)
				// You can use it in your SidebarContextMenu or perform other actions

				sidebarContextMenu.open(mouseEvent, selectedNode.getUserObject());
			}
		}
	}
}