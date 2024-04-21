package net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails;

import java.util.List;

import net.restcall.consts.RcConsts.RequestTypes;
import net.restcall.controllers.BaseUiChangeListener;
import net.restcall.controllers.Context;
import net.restcall.controllers.Updatable;
import net.restcall.gui.pages.request.HttpUrlInput;
import net.restcall.model.call.Endpoint;
import net.restcall.model.call.request.QueryParameters;
import net.restcall.model.util.SelectableNamedValue;

public class RequestUrlController extends BaseUiChangeListener implements Updatable {
	private final Endpoint endpoint;
	private final QueryParameters queryParams;
	private final HttpUrlInput urlInput;

	public RequestUrlController(Context context, Endpoint endpoint, QueryParameters queryParams,
			HttpUrlInput urlInput) {
		super(context);
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
	public void applyUiChanges() {
		endpoint.setMethod(RequestTypes.valueOf(urlInput.method()));
		String[] urlParts = urlInput.url().split("\\?");
		endpoint.setUrl(urlParts[0]);
		if (urlParts.length > 1) {
			updateQueryParameters(urlParts[1]);
		} else {
			updateQueryParameters(urlInput.url());
		}
		getContext().invalidateUi();
	}

	private void updateQueryParameters(String urlParams) {
		String[] pairs = urlParams.split("&");
		var params = queryParams.getParams();
		params.clear();
		for (String pair: pairs) {
			String[] item = pair.split("=");
			if (item.length == 1) {
				params.add(new SelectableNamedValue(item[0], ""));
			} else if (item.length ==2) {
				params.add(new SelectableNamedValue(item[0], item[1]));
			}
		}
		if(urlParams.endsWith("&")) {
			params.add(new SelectableNamedValue("", ""));	
		}
	}

	private String buildUrl() {
		StringBuilder url = new StringBuilder();
		url.append(endpoint.getUrl());
		List<SelectableNamedValue> params = queryParams.getParams();
		if (params.size() > 0) {
			char delimitor = '?';
			for (SelectableNamedValue item : params) {
				url.append(delimitor);
				if (delimitor == '?') {
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
