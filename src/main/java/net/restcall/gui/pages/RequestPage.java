package net.restcall.gui.pages;

import javax.swing.JSplitPane;

import net.restcall.gui.pages.request.RequestParametersPanel;
import net.restcall.gui.pages.response.ResponsePanel;

public class RequestPage extends JSplitPane {
	public RequestPage(Object object) {
		super(JSplitPane.VERTICAL_SPLIT, new RequestParametersPanel(), new ResponsePanel());
		setDividerLocation(175);
	}
}