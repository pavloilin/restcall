package net.restcall.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.tree.DefaultMutableTreeNode;

import net.restcall.gui.pages.RequestPage;

public class RightPanel extends JPanel {

	private JTabbedPane tabbedPane;

	public RightPanel() {

		setLayout(new BorderLayout());

		tabbedPane = new JTabbedPane();

		// Add some components to bottom and main panels (customize as needed)

		add(tabbedPane, BorderLayout.CENTER); // Add the JTabbedPane to mainPanel

		
	}
	public void openTab(String title, RequestPage requestPage) {
		tabbedPane.addTab(title, requestPage);
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}
	public boolean isAllTabsPresent(int size) {
		
		return size != tabbedPane.getTabCount();
	}
	public void switchToTab(int tabIndex) {
		tabbedPane.setSelectedIndex(tabIndex);
	}
}
