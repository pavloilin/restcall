package net.restcall.gui.widgets;

import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class HeaderWithToolbar extends JPanel {

	private final JToolBar toolBar;

	public HeaderWithToolbar(String title) {
		setLayout(new BorderLayout());

		// Header label on the left
		JLabel headerLabel = new JLabel(title);
		add(headerLabel, BorderLayout.WEST);

		// Control toolbar on the right
		toolBar = new JToolBar();
		toolBar.setFloatable(false);

		add(toolBar, BorderLayout.EAST);
	}

	public void registerActions(Action[] actions) {
		for (Action action : actions) {
			JButton addButton = new JButton(action);
			toolBar.add(addButton);
		}

	}
}