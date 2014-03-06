package org.globalcauseway.gcmobile.client;

import org.globalcauseway.gcmobile.client.activities.UIPlace;
import org.globalcauseway.gcmobile.client.places.HomePlace;

import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;

public class TabletNavAnimationMapper implements AnimationMapper {

	@Override
	public Animation getAnimation(Place oldPlace, Place newPlace) {
		if (oldPlace == null) {
			return Animation.FADE;
		}

		if (oldPlace instanceof HomePlace && newPlace instanceof UIPlace) {
			return Animation.SLIDE;
		}

		if (oldPlace instanceof UIPlace && newPlace instanceof HomePlace) {
			return Animation.SLIDE_REVERSE;
		}

		return Animation.SLIDE;
	}

}
