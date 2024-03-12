package net.restcall.gui.pages.request;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.restcall.consts.RcConsts.RequestTypes;
import net.restcall.gui.listeners.UiChangeListener;

public class HttpUrlInput extends JPanel {
	private JComboBox<String> methodComboBox;
	private JTextField urlField;
	private UiChangeListener changeListener;

	public HttpUrlInput() {
		super(new BorderLayout(0, 0));

		// Dropdown for HTTP method
		String[] httpMethods = { "GET", "POST", "PUT", "DELETE" };
		methodComboBox = new JComboBox<>(httpMethods);
		methodComboBox.addActionListener(al -> fireUiChanged());

		// Text field for URL
		urlField = new JTextField();
		urlField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				if (e.getType() != null) {
					fireUiChanged();
				}

			}
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				if (e.getType() != null) {
					fireUiChanged();
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				if (e.getType() != null) {
					fireUiChanged();
				}
			}

		});

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
		// setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
	}

	private Object fireUiChanged() {
		if (changeListener != null) {
			changeListener.uiChanged();
		}
		return null;
	}

	public void registerChangeListener(UiChangeListener changeListener) {
		this.changeListener = changeListener;
	}

	@Override
	public Dimension getMaximumSize() {
		var r = super.getMaximumSize();
		r.height = 20;
		return r;
	}

	public void update(RequestTypes type, String url) {
		methodComboBox.setSelectedItem(type.toString());
		urlField.setText(url);
	}

	public String url() {
		return urlField.getText();
	}

	public String method() {
		return methodComboBox.getSelectedItem().toString();
	}
}
