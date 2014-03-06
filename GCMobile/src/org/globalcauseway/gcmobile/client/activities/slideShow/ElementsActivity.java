package org.globalcauseway.gcmobile.client.activities.slideShow;

import org.globalcauseway.gcmobile.client.ClientFactory;
import org.globalcauseway.gcmobile.client.DetailActivity;
import org.globalcauseway.gcmobile.client.activities.homepage.HomePagePlace;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

public class ElementsActivity extends DetailActivity {

	private final ClientFactory clientFactory;

	public ElementsActivity(ClientFactory clientFactory) {
		super(clientFactory.getElementsView(), "nav");
		this.clientFactory = clientFactory;

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		ElementsView view = clientFactory.getElementsView();
		view.getMainButtonText().setText("Nav");
		view.getBackbuttonText().setText("home");
		view.getHeader().setText("Ads slideshow");
		addHandlerRegistration(view.getCloseButton().addTapHandler(new TapHandler() {

	        @Override
	        public void onTap(TapEvent event) {
	          clientFactory.getPlaceController().goTo(new HomePagePlace());

	        }
	      }));
		panel.setWidget(view);
	}

}
