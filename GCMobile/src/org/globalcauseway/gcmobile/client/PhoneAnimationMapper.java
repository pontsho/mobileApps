
package org.globalcauseway.gcmobile.client;

import org.globalcauseway.gcmobile.client.activities.AboutPlace;
import org.globalcauseway.gcmobile.client.activities.UIPlace;
import org.globalcauseway.gcmobile.client.activities.animation.AnimationPlace;
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
import org.globalcauseway.gcmobile.client.activities.homepage.HomePagePlace;
import org.globalcauseway.gcmobile.client.activities.search.SearchPlace;
import org.globalcauseway.gcmobile.client.activities.slideShow.ElementsPlace;
import org.globalcauseway.gcmobile.client.places.HomePlace;

import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;

public class PhoneAnimationMapper implements AnimationMapper {

	@Override
	public Animation getAnimation(Place oldPlace, Place newPlace) {

		if (oldPlace instanceof UIPlace && newPlace instanceof HomePlace) {
			return Animation.SLIDE_REVERSE;
		}

		if (oldPlace instanceof AboutPlace && newPlace instanceof HomePlace) {
			return Animation.SLIDE_UP_REVERSE;
		}

		if (oldPlace instanceof HomePlace && newPlace instanceof AboutPlace) {
			return Animation.SLIDE_UP;
		}

		if (oldPlace instanceof HomePlace && newPlace instanceof AnimationPlace) {
			return Animation.SLIDE;
		}

		if (oldPlace instanceof HomePlace && newPlace instanceof UIPlace) {
			return Animation.SLIDE;
		}

		if (oldPlace instanceof AnimationPlace && newPlace instanceof HomePlace) {
			return Animation.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof ElementsPlace) {
			return Animation.SLIDE;
		}

		if (oldPlace instanceof ElementsPlace && newPlace instanceof UIPlace) {
			return Animation.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof SearchPlace) {
			return Animation.SLIDE;
		}

		if (oldPlace instanceof SearchPlace && newPlace instanceof UIPlace) {
			return Animation.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof EmailLoginPlace) {
			return Animation.SLIDE;
		}

		if (oldPlace instanceof EmailLoginPlace && newPlace instanceof UIPlace) {
			return Animation.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof SignupPlace) {
			return Animation.SLIDE;
		}

		if (oldPlace instanceof SignupPlace && newPlace instanceof UIPlace) {
			return Animation.SLIDE_REVERSE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof HomePagePlace) {
			return Animation.SLIDE;
		}

		if (oldPlace instanceof HomePagePlace && newPlace instanceof UIPlace) {
			return Animation.SLIDE_REVERSE;
		}


		if (oldPlace instanceof UIPlace && newPlace instanceof ForgotPasswordPlace) {
			return Animation.SLIDE;
		}

		if (oldPlace instanceof ForgotPasswordPlace && newPlace instanceof UIPlace) {
			return Animation.SLIDE_REVERSE;
		}

		// animation

		if (oldPlace instanceof AnimationSlidePlace && newPlace instanceof AnimationPlace) {
			return Animation.SLIDE_REVERSE;
		}

		// if (oldPlace instanceof AnimationCubePlace && newPlace instanceof
		// AnimationPlace) {
		// return Animation.CUBE_REVERSE;
		// }
		//
		// if (oldPlace instanceof AnimationPlace && newPlace instanceof
		// AnimationCubePlace) {
		// return Animation.CUBE;
		// }

		if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationSlideUpPlace) {
			return Animation.SLIDE_UP;
		}

		if (oldPlace instanceof AnimationSlideUpPlace && newPlace instanceof AnimationPlace) {
			return Animation.SLIDE_UP_REVERSE;
		}

		if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationDissolvePlace) {
			return Animation.DISSOLVE;
		}

		if (oldPlace instanceof AnimationDissolvePlace && newPlace instanceof AnimationPlace) {
			return Animation.DISSOLVE_REVERSE;
		}

		if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationFadePlace) {
			return Animation.FADE;
		}

		if (oldPlace instanceof AnimationFadePlace && newPlace instanceof AnimationPlace) {
			return Animation.FADE_REVERSE;
		}
		if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationFlipPlace) {
			return Animation.FLIP;
		}

		if (oldPlace instanceof AnimationFlipPlace && newPlace instanceof AnimationPlace) {
			return Animation.FLIP_REVERSE;
		}

		if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationPopPlace) {
			return Animation.POP;
		}

		if (oldPlace instanceof AnimationPopPlace && newPlace instanceof AnimationPlace) {
			return Animation.POP_REVERSE;
		}

		if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationSwapPlace) {
			return Animation.SWAP;
		}

		if (oldPlace instanceof AnimationSwapPlace && newPlace instanceof AnimationPlace) {
			return Animation.SWAP_REVERSE;
		}

		return Animation.SLIDE;

	}
}
