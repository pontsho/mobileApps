package org.globalcauseway.gcmobile.client.activities;

import org.globalcauseway.gcmobile.client.ClientFactory;
import org.globalcauseway.gcmobile.client.DetailActivity;
import org.globalcauseway.gcmobile.client.event.ActionEvent;
import org.globalcauseway.gcmobile.client.event.ActionNames;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

public class AboutActivity extends DetailActivity {

	private final ClientFactory clientFactory;

	public AboutActivity(ClientFactory clientFactory) {
		super(clientFactory.getAboutView(), "nav");
		this.clientFactory = clientFactory;

	}

	@Override
	public void start(AcceptsOneWidget panel, final EventBus eventBus) {
		super.start(panel, eventBus);
		AboutView aboutView = clientFactory.getAboutView();

		aboutView.getBackbuttonText().setText("Home");

		aboutView.getHeader().setText("About");

		aboutView.getMainButtonText().setText("Nav");

		addHandlerRegistration(aboutView.getBackbutton().addTapHandler(new TapHandler() {

			@Override
			public void onTap(TapEvent event) {
				ActionEvent.fire(eventBus, ActionNames.BACK);

			}
		}));

		panel.setWidget(aboutView);

	}

}
