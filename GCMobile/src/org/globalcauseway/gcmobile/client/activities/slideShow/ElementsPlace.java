package org.globalcauseway.gcmobile.client.activities.slideShow;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Pontsho
 *
 */
public class ElementsPlace extends Place {
	public static class ElementsPlaceTokenizer implements PlaceTokenizer<ElementsPlace> {

		@Override
		public ElementsPlace getPlace(String token) {
			return new ElementsPlace();
		}

		@Override
		public String getToken(ElementsPlace place) {
			return "";
		}

	}
}
