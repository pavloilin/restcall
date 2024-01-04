package net.restcall.gui.pages.request.tabs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HttpBody extends JPanel {
	private final JPanel contentPanel = new JPanel();
	
	public HttpBody() {
		super(new BorderLayout(0, 0));
		
		String[] payloadTypes = { "none", "form-data", "x-www-form-urlencoded", "raw", "binary" };
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
	 private void updateContentPanel(String selectedOption) {
	        // Clear previous content
	        contentPanel.removeAll();

	        // Add new content based on the selected option
	        JLabel label = new JLabel("Content for " + selectedOption);
	        contentPanel.add(label);

	        // Repaint the panel
	        contentPanel.revalidate();
	        contentPanel.repaint();
	    }

}
