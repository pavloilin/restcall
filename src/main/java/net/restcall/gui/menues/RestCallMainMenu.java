package net.restcall.gui.menues;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class RestCallMainMenu extends JMenuBar {

	public RestCallMainMenu() {
		add(createFileMenu());
		add(createEditMenu());
		add(createSearchMenu());
		add(createHelpMenu());
	}

//the Menu Components
	private JMenu createFileMenu() {
		var fileMenu = new JMenu("File");
		JMenuItem newWorkspace = new JMenuItem("New Workspace");
		JMenuItem newCollection = new JMenuItem("New Collection");
		JMenuItem newEnvironment = new JMenuItem("New Environment");
		JMenuItem openSpace = new JMenuItem("Open Space...");
		JMenuItem saveSpace = new JMenuItem("Save Space");
		JMenuItem openCollection = new JMenuItem("Open Collection...");
		JMenuItem saveCollection = new JMenuItem("Save Collection");
		JMenuItem importCollection = new JMenuItem("Import Collection...");
		JMenuItem importEnvironment = new JMenuItem("Import Environment...");
		JMenuItem exportCollection = new JMenuItem("Export Collection...");
		JMenuItem exportEnvironment = new JMenuItem("Export Environment...");
		JMenuItem exitItem = new JMenuItem("Exit");

		fileMenu.add(newWorkspace);
		fileMenu.add(newCollection);
		fileMenu.add(newEnvironment);
		fileMenu.add(new JSeparator());
		fileMenu.add(openSpace);
		fileMenu.add(saveSpace);
		fileMenu.add(openCollection);
		fileMenu.add(saveCollection);
		fileMenu.add(new JSeparator());
		fileMenu.add(importCollection);
		fileMenu.add(importEnvironment);
		fileMenu.add(exportCollection);
		fileMenu.add(exportEnvironment);
		fileMenu.add(new JSeparator());
		fileMenu.add(exitItem);
		
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		return fileMenu;
	}

	private JMenu createEditMenu() {
		var editMenu = new JMenu("Edit");
		JMenuItem cutItem = new JMenuItem("Cut");
		JMenuItem copyItem = new JMenuItem("Copy");
		JMenuItem pasteItem = new JMenuItem("Paste");
		JMenuItem deleteItem = new JMenuItem("Delete");

		editMenu.add(cutItem);
		editMenu.add(copyItem);
		editMenu.add(pasteItem);
		editMenu.add(deleteItem);
		return editMenu;
	}
	private JMenu createSearchMenu() {
		var searchMenu = new JMenu("Search");
		JMenuItem searchItem = new JMenuItem("Search...");
		JMenuItem replaceItem = new JMenuItem("Replace...");

		searchMenu.add(searchItem);
		searchMenu.add(replaceItem);
		return searchMenu;
	}
	private JMenu createHelpMenu() {
		var helpMenu = new JMenu("Help");
		JMenuItem aboutItem = new JMenuItem("About");

		helpMenu.add(aboutItem);



		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getParent(), "Rest Call is an application to test the http request",
						"About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		return helpMenu;
	}
}
