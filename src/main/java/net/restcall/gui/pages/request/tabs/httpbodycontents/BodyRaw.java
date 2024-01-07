package net.restcall.gui.pages.request.tabs.httpbodycontents;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BodyRaw extends JPanel {
	public BodyRaw() {
		super(new BorderLayout(0, 0));
		var textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);
	}
}
