package net.restcall.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import net.restcall.consts.RcConsts;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainWindow() {
		super("RestCall ver." + RcConsts.version);
		setSize(700, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("Branch 1");
        DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("Branch 2");
        DefaultMutableTreeNode branch3 = new DefaultMutableTreeNode("Branch 3");

        root.add(branch1);
        root.add(branch2);
        root.add(branch3);

        JTree sidebarPanel = new JTree(root);
        JPanel bottomPanel = new JPanel();
        JPanel mainPanel = new JPanel();

        // Set layouts for the panels (you can customize as needed)
        sidebarPanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());

        // Add some components to each panel (customize as needed)
        sidebarPanel.add(new JLabel("Sidebar Content"), BorderLayout.CENTER);
        bottomPanel.add(new JLabel("Bottom Panel Content"), BorderLayout.CENTER);
        mainPanel.add(new JLabel("Main Window Content"), BorderLayout.CENTER);

        // Create split panes
        JSplitPane verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mainPanel, bottomPanel);
        JSplitPane horizontalSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebarPanel, verticalSplitPane);

        // Set initial sizes of the split panes (customize as needed)
        verticalSplitPane.setDividerLocation(400);
        horizontalSplitPane.setDividerLocation(200);

        // Set the split pane as the content of the frame
        getContentPane().add(horizontalSplitPane);

	}
}
