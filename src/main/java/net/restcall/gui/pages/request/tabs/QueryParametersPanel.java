package net.restcall.gui.pages.request.tabs;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import net.restcall.gui.listeners.UiChangeListener;
import net.restcall.gui.widgets.HeaderWithToolbar;

public class QueryParametersPanel extends JPanel {

	public static final int COLUMN_COUNT = 3;

	private final JTable table;
	private final HeaderWithToolbar headerWithToolbar;
	private UiChangeListener changeListener;

	public QueryParametersPanel() {
		super(new BorderLayout(0, 0));

		headerWithToolbar = new HeaderWithToolbar("Query RestCall");

		this.table = new JTable();

		JScrollPane scrollpane = new JScrollPane(table);
		add(scrollpane, BorderLayout.CENTER);
		add(headerWithToolbar, BorderLayout.NORTH);
	}

	public void registerChangeListener(UiChangeListener changeListener) {
		this.changeListener = changeListener;
	}

	public void installNewData(String[][] data) {
		String col[] = { "Name", "Value", "Description" };
		DefaultTableModel model = new DefaultTableModel(data, col);
		model.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				if (changeListener != null) {
					changeListener.uiChanged();
				}
			}
		});
		table.setModel(model);
	}
	public Vector<Vector> getData(){
		return ((DefaultTableModel)table.getModel()).getDataVector();
		
	}

	public void registerActions(Action[] actions) {
		headerWithToolbar.registerActions(actions);
		
	}

	public int getSelectedIndex() {
		return table.getSelectedRow();
	}
}
