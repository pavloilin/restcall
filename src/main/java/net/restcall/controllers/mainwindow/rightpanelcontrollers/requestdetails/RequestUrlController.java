package net.restcall.controllers.mainwindow.rightpanelcontrollers.requestdetails;

import net.restcall.consts.RcConsts.RequestTypes;
import net.restcall.controllers.Updatable;
import net.restcall.gui.listeners.UiChangeListener;
import net.restcall.gui.pages.request.HttpUrlInput;
import net.restcall.model.call.Endpoint;

public class RequestUrlController implements Updatable, UiChangeListener {
	private final Endpoint endpoint;
	private final HttpUrlInput urlInput;

	public RequestUrlController(Endpoint endpoint, HttpUrlInput urlInput) {
		super();
		this.endpoint = endpoint;
		this.urlInput = urlInput;
		urlInput.registerChangeListener(this);
	}

	@Override
	public void updateUi() {
		urlInput.update(endpoint.getMethod(), endpoint.getUrl());		
	}

	@Override
	public void uiChanged() {
		endpoint.setMethod(RequestTypes.valueOf(urlInput.method()));
		endpoint.setUrl(urlInput.url());
		
	}

}
