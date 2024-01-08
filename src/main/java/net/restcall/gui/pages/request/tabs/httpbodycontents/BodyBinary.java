package net.restcall.gui.pages.request.tabs.httpbodycontents;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BodyBinary extends JPanel {
	public BodyBinary() {
		
		JButton selectFilesButton = new JButton("Select Files");
		selectFilesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showFileChooser();
			}
		});

		
		add(selectFilesButton);

		setVisible(true);
	}

	private static void showFileChooser() {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(true); // Allow selecting multiple files

		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			// User selected files
			System.out.println("Selected files:");
			for (java.io.File file : fileChooser.getSelectedFiles()) {
				System.out.println(file.getAbsolutePath());
			}
		}
	}
}
