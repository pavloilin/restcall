package net.restcall.gui;



import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import net.restcall.consts.RcConsts;
import net.restcall.gui.menues.RestCallMainMenu;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	Sidebar sidebarPanel;
	RightPanel rightPanel;

	public MainWindow() {
		super("RestCall ver." + RcConsts.version);
		configure();

		setJMenuBar(new RestCallMainMenu());

		sidebarPanel = new Sidebar();
		JPanel bottomPanel = createBottomPanel();
		rightPanel = new RightPanel();

		// Create split panes
		JSplitPane horizontalSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebarPanel, rightPanel);
		JSplitPane verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, horizontalSplitPane, bottomPanel);

		// Set initial sizes of the split panes (customize as needed)
		verticalSplitPane.setDividerLocation(400);
		horizontalSplitPane.setDividerLocation(200);

		// Set the split pane as the content of the frame
		getContentPane().add(verticalSplitPane);

	}

	public Sidebar getSidebarPanel() {
		return sidebarPanel;
	}

	private void configure() {
		setSize(700, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private JPanel createBottomPanel() {
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		return bottomPanel;
	}

	

	public RightPanel getRightPanel() {

		return rightPanel;
	}
}
