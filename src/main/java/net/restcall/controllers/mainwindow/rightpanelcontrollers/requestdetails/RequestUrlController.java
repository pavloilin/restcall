package net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails;

import java.util.List;

import net.restcall.consts.RcConsts.RequestTypes;
import net.restcall.controllers.Updatable;
import net.restcall.gui.listeners.UiChangeListener;
import net.restcall.gui.pages.request.HttpUrlInput;
import net.restcall.model.call.Endpoint;
import net.restcall.model.call.request.QueryParameters;
import net.restcall.model.util.SelectableNamedValue;

public class RequestUrlController implements Updatable, UiChangeListener {
	private final Endpoint endpoint;
	private final QueryParameters queryParams;
	private final HttpUrlInput urlInput;

	public RequestUrlController(Endpoint endpoint, QueryParameters queryParams, HttpUrlInput urlInput) {
		super();
		this.endpoint = endpoint;
		this.queryParams = queryParams;
		this.urlInput = urlInput;
		urlInput.registerChangeListener(this);
	}

	@Override
	public void updateUi() {
		urlInput.update(endpoint.getMethod(), buildUrl());
	}

	@Override
	public void uiChanged() {
		endpoint.setMethod(RequestTypes.valueOf(urlInput.method()));
		endpoint.setUrl(urlInput.url());
		
	}

	private String buildUrl() {
		StringBuilder url = new StringBuilder();
		url.append(endpoint.getUrl());
		List<SelectableNamedValue> params = queryParams.getParams();
		if (params.size() > 0) {
			char delimitor = '?';
			for(SelectableNamedValue item: params) {
				url.append(delimitor);
				if(delimitor == '?') {
					delimitor = '&';
				}
				url.append(item.getName());
				url.append("=");
				url.append(item.getValue());
			}
		}
		return url.toString();
	}

}
