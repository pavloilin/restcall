package net.restcall.gui;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import net.restcall.consts.RcConsts;
import net.restcall.gui.menues.RestCallMainMenu;
import net.restcall.gui.pages.RequestPage;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	JTabbedPane tabbedPane;

	public MainWindow() {
		super("RestCall ver." + RcConsts.version);
		configure();

		setJMenuBar(new RestCallMainMenu());

		JTree sidebarPanel = createSidebarTree();
		JPanel bottomPanel = createBottomPanel();
		JPanel mainPanel = createMainPanel();

		// Create split panes
		JSplitPane horizontalSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebarPanel, mainPanel);
		JSplitPane verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, horizontalSplitPane, bottomPanel);

		// Set initial sizes of the split panes (customize as needed)
		verticalSplitPane.setDividerLocation(400);
		horizontalSplitPane.setDividerLocation(200);

		// Set the split pane as the content of the frame
		getContentPane().add(verticalSplitPane);

	}

	private void configure() {
		setSize(700, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel();

		mainPanel.setLayout(new BorderLayout());

		tabbedPane = new JTabbedPane();

		// Add some components to bottom and main panels (customize as needed)

		mainPanel.add(tabbedPane, BorderLayout.CENTER); // Add the JTabbedPane to mainPanel

		return mainPanel;
	}

	private JPanel createBottomPanel() {
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		return bottomPanel;
	}

	private JTree createSidebarTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("RestCall 1");
		DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("RestCall 2");
		DefaultMutableTreeNode branch3 = new DefaultMutableTreeNode("RestCall 3");

		root.add(branch1);
		root.add(branch2);
		root.add(branch3);

		JTree sidebarPanel = new JTree(root);
		sidebarPanel.setLayout(new BorderLayout());

		sidebarPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 1) {
					openRequestTab(sidebarPanel);
				}
			}

			private void openRequestTab(JTree sidebarPanel) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) sidebarPanel
						.getLastSelectedPathComponent();
				if (selectedNode != null && selectedNode.isLeaf()) {
					openUpRequestPage(selectedNode);
				}
			}
		});

		return sidebarPanel;
	}

	private void openUpRequestPage(DefaultMutableTreeNode selectedNode) {
		tabbedPane.addTab(selectedNode.getUserObject().toString(), new RequestPage(selectedNode.getUserObject()));
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}
}
