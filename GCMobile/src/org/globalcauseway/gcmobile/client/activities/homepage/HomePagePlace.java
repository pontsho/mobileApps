package org.globalcauseway.gcmobile.client.activities.homepage;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Pontsho Molewa
 *
 */
public class HomePagePlace extends Place {
	public static class HomePagePlaceTokenizer implements PlaceTokenizer<HomePagePlace> {

		@Override
		public HomePagePlace getPlace(String token) {
			return new HomePagePlace();
		}

		@Override
		public String getToken(HomePagePlace place) {
			return "";
		}

	}
}
