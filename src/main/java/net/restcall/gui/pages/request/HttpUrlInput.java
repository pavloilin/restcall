package net.restcall.gui.pages.request;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HttpUrlInput extends JPanel {
	public HttpUrlInput() {
		super(new BorderLayout(0, 0));

		// Dropdown for HTTP method
		String[] httpMethods = { "GET", "POST", "PUT", "DELETE" };
		JComboBox<String> methodComboBox = new JComboBox<>(httpMethods);

		// Text field for URL
		JTextField urlField = new JTextField();

		// Button for sending the request
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Handle the request here (e.g., print the URL and method)
				String selectedMethod = (String) methodComboBox.getSelectedItem();
				String url = urlField.getText();
				System.out.println("Method: " + selectedMethod + ", URL: " + url);
			}
		});

//		methodComboBox.setPreferredSize(new Dimension(100, 10));
//		sendButton.setPreferredSize(new Dimension(100, 10));

		// Add components to the URL request panel

		add(methodComboBox, BorderLayout.WEST);
		add(urlField, BorderLayout.CENTER);
		add(sendButton, BorderLayout.EAST);
		//setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
	}
	
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 50;
	}
}
