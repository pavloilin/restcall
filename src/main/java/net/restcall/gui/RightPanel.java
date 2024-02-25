package net.restcall.gui;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class RightPanel extends JPanel {

	private JTabbedPane tabbedPane;

	public RightPanel() {

		setLayout(new BorderLayout());

		tabbedPane = new JTabbedPane();

		// Add some components to bottom and main panels (customize as needed)

		add(tabbedPane, BorderLayout.CENTER); // Add the JTabbedPane to mainPanel

		
	}
	public void openTab(String title, JComponent content ) {
		tabbedPane.addTab(title, content);
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}
	public boolean isAllTabsPresent(int size) {
		
		return size != tabbedPane.getTabCount();
	}
	public void switchToTab(int tabIndex) {
		tabbedPane.setSelectedIndex(tabIndex);
	}
}
