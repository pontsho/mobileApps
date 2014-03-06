package org.globalcauseway.gcmobile.client;

import org.globalcauseway.gcmobile.client.activities.AboutPlace;
import org.globalcauseway.gcmobile.client.activities.ShowCaseListActivity;
import org.globalcauseway.gcmobile.client.activities.UIActivity;
import org.globalcauseway.gcmobile.client.activities.UIPlace;
import org.globalcauseway.gcmobile.client.activities.animation.AnimationActivity;
import org.globalcauseway.gcmobile.client.activities.animation.AnimationPlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationCubePlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationDissolvePlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationFadePlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationFlipPlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationPopPlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationSlidePlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationSlideUpPlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationSwapPlace;
import org.globalcauseway.gcmobile.client.activities.authentication.emaillogin.EmailLoginPlace;
import org.globalcauseway.gcmobile.client.activities.authentication.passwordreset.SignupPlace;
import org.globalcauseway.gcmobile.client.activities.authentication.signup.ForgotPasswordPlace;
import org.globalcauseway.gcmobile.client.activities.branddetails.BrandDetailsPlace;
import org.globalcauseway.gcmobile.client.activities.homepage.HomePagePlace;
import org.globalcauseway.gcmobile.client.activities.search.SearchPlace;
import org.globalcauseway.gcmobile.client.activities.searchresults.SearchResultsPlace;
import org.globalcauseway.gcmobile.client.activities.slideShow.ElementsPlace;
import org.globalcauseway.gcmobile.client.places.HomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class TabletNavActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	public TabletNavActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	private UIActivity uiActivity;
	private ShowCaseListActivity showCaseListActivity;
	private AnimationActivity animationActivity;

	private Activity getUIActivity() {
		if (uiActivity == null) {
			uiActivity = new UIActivity(clientFactory);
		}
		return uiActivity;
	}

	private Activity getShowCaseListActivity() {
		if (showCaseListActivity == null) {
			showCaseListActivity = new ShowCaseListActivity(clientFactory);
		}
		return showCaseListActivity;
	}

	private Activity getAnimationActicity() {
		if (animationActivity == null) {
			animationActivity = new AnimationActivity(clientFactory);
		}
		return animationActivity;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof HomePlace || place instanceof AboutPlace) {
			return getShowCaseListActivity();
		}

		if ( place instanceof ForgotPasswordPlace || place instanceof UIPlace 
				|| place instanceof ElementsPlace || place instanceof SearchPlace || place instanceof EmailLoginPlace || place instanceof SignupPlace
				|| place instanceof HomePagePlace || place instanceof SearchResultsPlace || place instanceof BrandDetailsPlace) {
			return getUIActivity();
		}

		if (place instanceof AnimationPlace) {
			return getAnimationActicity();
		}

		if (place instanceof AnimationSlidePlace || place instanceof AnimationSlideUpPlace || place instanceof AnimationDissolvePlace || place instanceof AnimationFadePlace
				|| place instanceof AnimationFlipPlace || place instanceof AnimationPopPlace || place instanceof AnimationSwapPlace || place instanceof AnimationCubePlace) {
			return getAnimationActicity();
		}
		return new ShowCaseListActivity(clientFactory);
	}
}
