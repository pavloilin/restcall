package net.restcall.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import net.restcall.consts.RcConsts;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainWindow() {
		super("RestCall ver." + RcConsts.version);
		configure();
		
		JTree sidebarPanel = createSidebarTree();
        JPanel bottomPanel = createBottomPanel();
        JPanel mainPanel = createMainPanel();

      
        // Create split panes
        JSplitPane horizontalSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebarPanel, mainPanel);
        JSplitPane verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, horizontalSplitPane, bottomPanel );

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
		return mainPanel;
	}

	private JPanel createBottomPanel() {
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		return bottomPanel;
	}

	private JTree createSidebarTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("Branch 1");
        DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("Branch 2");
        DefaultMutableTreeNode branch3 = new DefaultMutableTreeNode("Branch 3");

        root.add(branch1);
        root.add(branch2);
        root.add(branch3);

        JTree sidebarPanel = new JTree(root);
        sidebarPanel.setLayout(new BorderLayout());
		return sidebarPanel;
	}
}
