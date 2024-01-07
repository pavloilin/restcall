package net.restcall.gui.pages.request.tabs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import net.restcall.gui.pages.request.tabs.httpbodycontents.BodyBinary;
import net.restcall.gui.pages.request.tabs.httpbodycontents.BodyFormData;
import net.restcall.gui.pages.request.tabs.httpbodycontents.BodyNone;
import net.restcall.gui.pages.request.tabs.httpbodycontents.BodyRaw;
import net.restcall.gui.pages.request.tabs.httpbodycontents.BodyXWwwFormUrlencoded;

public class HttpBody extends JPanel {
	private static final String BINARY = "binary";
	private static final String RAW = "raw";
	private static final String X_WWW_FORM_URLENCODED = "x-www-form-urlencoded";
	private static final String FORM_DATA = "form-data";
	private static final String NONE = "none";

	private final JPanel contentPanel = new JPanel();

	public HttpBody() {
		super(new BorderLayout(0, 0));

		String[] payloadTypes = { NONE, FORM_DATA, X_WWW_FORM_URLENCODED, RAW, BINARY };
		JComboBox<String> payloadTypeComboBox = new JComboBox<>(payloadTypes);

		add(payloadTypeComboBox, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);

		updateContentPanel((String) payloadTypeComboBox.getSelectedItem()); // Initial update

		// Add an ActionListener to the combo box
		payloadTypeComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String) payloadTypeComboBox.getSelectedItem();
				updateContentPanel(selectedOption);
			}
		});
	}

	/**
	 * Update content panel
	 * 
	 * @param selectedOption
	 */
	private void updateContentPanel(String selectedOption) {
		// Clear previous content
		contentPanel.removeAll();

		// Add new content based on the selected option
		contentPanel.add(createBodyContent(selectedOption));

		// Repaint the panel
		contentPanel.revalidate();
		contentPanel.repaint();
	}

	private JComponent createBodyContent(String selectedOption) {
		switch (selectedOption) {
		case FORM_DATA:
			return new BodyFormData();
		case X_WWW_FORM_URLENCODED: 
			return new BodyXWwwFormUrlencoded();
		case RAW:
			return new BodyRaw();
		case BINARY:
			return new BodyBinary();
		default:
			return new BodyNone();
		}
	}

}
