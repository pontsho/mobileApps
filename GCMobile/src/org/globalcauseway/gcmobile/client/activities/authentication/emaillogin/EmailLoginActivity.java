
package org.globalcauseway.gcmobile.client.activities.authentication.emaillogin;

import org.globalcauseway.gcmobile.client.ClientFactory;
import org.globalcauseway.gcmobile.client.DetailActivity;
import org.globalcauseway.gcmobile.client.activities.UIPlace;
import org.globalcauseway.gcmobile.client.activities.homepage.HomePagePlace;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

public class EmailLoginActivity extends DetailActivity {

	private final ClientFactory clientFactory;

	public EmailLoginActivity(ClientFactory clientFactory) {
		super(clientFactory.getEmailLoginView(), "nav");
		this.clientFactory = clientFactory;

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		EmailLoginView view = clientFactory.getEmailLoginView();

		view.getBackbuttonText().setText("Home");
		view.getMainButtonText().setText("Nav");
		view.getHeader().setText("Good Cents");
		
		addHandlerRegistration(view.getLoginbutton().addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				 clientFactory.getPlaceController().goTo(new HomePagePlace());
				
			}
		}));

		panel.setWidget(view);

	}

}
