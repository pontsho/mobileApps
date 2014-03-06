package org.globalcauseway.gcmobile.client;

import org.globalcauseway.gcmobile.client.activities.AboutActivity;
import org.globalcauseway.gcmobile.client.activities.AboutPlace;
import org.globalcauseway.gcmobile.client.activities.UIPlace;
import org.globalcauseway.gcmobile.client.activities.animation.AnimationPlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationCubePlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationDissolvePlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationDoneActivity;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationFadePlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationFlipPlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationPopPlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationSlidePlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationSlideUpPlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationSwapPlace;
import org.globalcauseway.gcmobile.client.activities.authentication.emaillogin.EmailLoginActivity;
import org.globalcauseway.gcmobile.client.activities.authentication.emaillogin.EmailLoginPlace;
import org.globalcauseway.gcmobile.client.activities.authentication.passwordreset.SignupActivity;
import org.globalcauseway.gcmobile.client.activities.authentication.passwordreset.SignupPlace;
import org.globalcauseway.gcmobile.client.activities.authentication.signup.ForgotPasswordActivity;
import org.globalcauseway.gcmobile.client.activities.authentication.signup.ForgotPasswordPlace;
import org.globalcauseway.gcmobile.client.activities.branddetails.BrandDetailsActivity;
import org.globalcauseway.gcmobile.client.activities.branddetails.BrandDetailsPlace;
import org.globalcauseway.gcmobile.client.activities.homepage.HomePageActivity;
import org.globalcauseway.gcmobile.client.activities.homepage.HomePagePlace;
import org.globalcauseway.gcmobile.client.activities.search.SearchActivity;
import org.globalcauseway.gcmobile.client.activities.search.SearchPlace;
import org.globalcauseway.gcmobile.client.activities.searchresults.SearchResultsActivity;
import org.globalcauseway.gcmobile.client.activities.searchresults.SearchResultsPlace;
import org.globalcauseway.gcmobile.client.activities.slideShow.ElementsActivity;
import org.globalcauseway.gcmobile.client.activities.slideShow.ElementsPlace;
import org.globalcauseway.gcmobile.client.places.HomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class TabletMainActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	private Place lastPlace;

	public TabletMainActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;

	}

	@Override
	public Activity getActivity(Place place) {
		Activity activity = getActivity(lastPlace, place);
		lastPlace = place;
		return activity;

	}

	private AboutActivity aboutActivity;

	private AboutActivity getAboutActivity() {
		if (aboutActivity == null) {
			aboutActivity = new AboutActivity(clientFactory);
		}

		return aboutActivity;
	}

	private Activity getActivity(Place lastPlace, Place newPlace) {
		if (newPlace instanceof HomePlace) {
			return getAboutActivity();
		}

		if (newPlace instanceof AboutPlace) {
			return getAboutActivity();
		}

		if (newPlace instanceof UIPlace) {
			return getAboutActivity();
		}

		if (newPlace instanceof ElementsPlace) {
			return new ElementsActivity(clientFactory);
		}

		if (newPlace instanceof SearchPlace) {
			return new SearchActivity(clientFactory);
		}

		if (newPlace instanceof EmailLoginPlace) {
			return new EmailLoginActivity(clientFactory);
		}

		if (newPlace instanceof SignupPlace) {
			return new SignupActivity(clientFactory);
		}

		if (newPlace instanceof HomePagePlace) {
			return new HomePageActivity(clientFactory);
		}

		if (newPlace instanceof AnimationPlace) {
			return new AboutActivity(clientFactory);
		}

		if (newPlace instanceof ForgotPasswordPlace) {
			return new ForgotPasswordActivity(clientFactory);
		}
		
		if (newPlace instanceof SearchResultsPlace) {
			return new SearchResultsActivity(clientFactory);
		}
		
		if (newPlace instanceof BrandDetailsPlace) {
			return new BrandDetailsActivity(clientFactory);
		}
		
		if (newPlace instanceof AnimationSlidePlace || newPlace instanceof AnimationSlideUpPlace || newPlace instanceof AnimationDissolvePlace || newPlace instanceof AnimationFadePlace
				|| newPlace instanceof AnimationFlipPlace || newPlace instanceof AnimationPopPlace || newPlace instanceof AnimationSwapPlace || newPlace instanceof AnimationCubePlace) {
			return new AnimationDoneActivity(clientFactory);
		}

		return null;
	}

}
