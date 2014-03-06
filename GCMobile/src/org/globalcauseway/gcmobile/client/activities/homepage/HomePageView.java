package org.globalcauseway.gcmobile.client.activities.homepage;

import org.globalcauseway.gcmobile.client.DetailView;

import com.google.gwt.user.client.ui.HTML;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;

/**
 * @author Pontsho Molewa
 * 
 */
public interface HomePageView extends DetailView {

	HasTapHandlers getSearchButton();

	HasTapHandlers getComposeButton();

	HTML getNewUpdates();

	HasTapHandlers getTriviaback1();

	HasTapHandlers getTriviaright1();

	HTML getTrivia();

	void disableTriviaButton(int index, int size);

}
