package net.restcall.gui.pages.request.tabs;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails.tabcontrollers.QueryParamsController;
import net.restcall.gui.listeners.UiChangeListener;

public class QueryParametersPanel extends JPanel {
	
	public static final int COLUMN_COUNT = 3;
	
	private final JTable table;
	private UiChangeListener changeListener;
	
	public QueryParametersPanel() {
		super(new BorderLayout(0, 0));

		var header = new JLabel("Query RestCall");					
		
		this.table = new JTable();

		JScrollPane scrollpane = new JScrollPane(table);
		add(scrollpane, BorderLayout.CENTER);
		add(header, BorderLayout.NORTH);
	}

	public void registerChangeListener(UiChangeListener changeListener) {
		this.changeListener = changeListener;
	}
	
	public void installNewData(String[][] data) {
		String col[] = { "Name", "Value", "Description" };
		DefaultTableModel model = new DefaultTableModel(data, col);
		table.setModel(model);
	}
}
