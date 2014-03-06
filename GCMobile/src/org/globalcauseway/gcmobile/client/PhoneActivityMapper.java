/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.globalcauseway.gcmobile.client;

import org.globalcauseway.gcmobile.client.activities.AboutActivity;
import org.globalcauseway.gcmobile.client.activities.AboutPlace;
import org.globalcauseway.gcmobile.client.activities.ShowCaseListActivity;
import org.globalcauseway.gcmobile.client.activities.UIActivity;
import org.globalcauseway.gcmobile.client.activities.UIPlace;
import org.globalcauseway.gcmobile.client.activities.animation.AnimationActivity;
import org.globalcauseway.gcmobile.client.activities.animation.AnimationPlace;
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

/**
 * @author Daniel Kurka
 * 
 */
public class PhoneActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	public PhoneActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof HomePlace) {
			return new ShowCaseListActivity(clientFactory);
		}

		if (place instanceof UIPlace) {
			return new UIActivity(clientFactory);
		}

		if (place instanceof AboutPlace) {
			return new AboutActivity(clientFactory);
		}

		if (place instanceof AnimationPlace) {
			return new AnimationActivity(clientFactory);
		}

		if (place instanceof HomePagePlace) {
			return new HomePageActivity(clientFactory);
		}

		if (place instanceof ForgotPasswordPlace) {
			return new ForgotPasswordActivity(clientFactory);
		}
		
		if (place instanceof EmailLoginPlace) {
			return new EmailLoginActivity(clientFactory);
		}
		
		if (place instanceof SearchPlace) {
			return new SearchActivity(clientFactory);
		}
		
		if (place instanceof SignupPlace) {
			return new SignupActivity(clientFactory);
		}
		
		if (place instanceof SearchResultsPlace) {
			return new SearchResultsActivity(clientFactory);
		}
		
		if (place instanceof BrandDetailsPlace) {
			return new BrandDetailsActivity(clientFactory);
		}
		
		if (place instanceof ElementsPlace) {
			return new ElementsActivity(clientFactory);
		}
		if (place instanceof AnimationSlidePlace || place instanceof AnimationSlideUpPlace || place instanceof AnimationDissolvePlace || place instanceof AnimationFadePlace
				|| place instanceof AnimationFlipPlace || place instanceof AnimationPopPlace || place instanceof AnimationSwapPlace || place instanceof AnimationSwapPlace) {
			return new AnimationDoneActivity(clientFactory);
		}
		return new ShowCaseListActivity(clientFactory);
	}
}
