package org.globalcauseway.gcmobile.client;

import org.globalcauseway.gcmobile.client.activities.AboutPlace;
import org.globalcauseway.gcmobile.client.activities.UIEntrySelectedEvent;
import org.globalcauseway.gcmobile.client.activities.UIEntrySelectedEvent.UIEntry;
import org.globalcauseway.gcmobile.client.activities.UIPlace;
import org.globalcauseway.gcmobile.client.activities.animation.Animation;
import org.globalcauseway.gcmobile.client.activities.animation.Animation.AnimationNames;
import org.globalcauseway.gcmobile.client.activities.animation.AnimationPlace;
import org.globalcauseway.gcmobile.client.activities.animation.AnimationSelectedEvent;
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
import org.globalcauseway.gcmobile.client.activities.searchresults.SearchResultsPlace;
import org.globalcauseway.gcmobile.client.activities.slideShow.ElementsPlace;
import org.globalcauseway.gcmobile.client.event.ActionEvent;
import org.globalcauseway.gcmobile.client.event.ActionNames;
import org.globalcauseway.gcmobile.client.places.HomePlace;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.History;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.googlecode.mgwt.dom.client.event.mouse.HandlerRegistrationCollection;
import com.googlecode.mgwt.mvp.client.history.HistoryHandler;
import com.googlecode.mgwt.mvp.client.history.HistoryObserver;
import com.googlecode.mgwt.ui.client.MGWT;

public class AppHistoryObserver implements HistoryObserver {

	@Override
	public void onPlaceChange(Place place, HistoryHandler handler) {

	}

	@Override
	public void onHistoryChanged(Place place, HistoryHandler handler) {

	}

	@Override
	public void onAppStarted(Place place, HistoryHandler historyHandler) {
		if (MGWT.getOsDetection().isPhone()) {
			onPhoneNav(place, historyHandler);
		} else {
			// tablet
			onTabletNav(place, historyHandler);

		}

	}

	@Override
	public HandlerRegistration bind(EventBus eventBus, final HistoryHandler historyHandler) {

		HandlerRegistration addHandler = eventBus.addHandler(AnimationSelectedEvent.getType(), new AnimationSelectedEvent.Handler() {

			@Override
			public void onAnimationSelected(AnimationSelectedEvent event) {

				Animation animation = event.getAnimation();

				AnimationNames animationName = animation.getAnimationName();

				Place place = null;

				switch (animationName) {
				case SLIDE:
					place = new AnimationSlidePlace();

					break;
				case SLIDE_UP:
					place = new AnimationSlideUpPlace();

					break;
				case DISSOLVE:
					place = new AnimationDissolvePlace();

					break;
				case FADE:
					place = new AnimationFadePlace();

					break;
				case FLIP:
					place = new AnimationFlipPlace();

					break;
				case POP:
					place = new AnimationPopPlace();

					break;
				case SWAP:
					place = new AnimationSwapPlace();

					break;

				default:
					// TODO log
					place = new AnimationSlidePlace();
					break;
				}

				if (MGWT.getOsDetection().isTablet()) {

					historyHandler.replaceCurrentPlace(place);
					historyHandler.goTo(place, true);
				} else {
					historyHandler.goTo(place);
				}

			}
		});
		HandlerRegistration register3 = UIEntrySelectedEvent.register(eventBus, new UIEntrySelectedEvent.Handler() {

			@Override
			public void onAnimationSelected(UIEntrySelectedEvent event) {

				UIEntry entry = event.getEntry();

				Place place = null;

				switch (entry) {
				case EMAIL_LOGIN:
					place = new EmailLoginPlace();
					break;
				case HOMEPAGE:
					place = new HomePagePlace();
					break;
				case ELEMENTS:
					place = new ElementsPlace();
					break;
				case SEARCH:
					place = new SearchPlace();
					break;
				
				case PASSWORD_RESET:
					place = new SignupPlace();
					break;
				case SIGNUP:
					place = new ForgotPasswordPlace();
					break;
				default:
					break;
				}

				if (MGWT.getOsDetection().isTablet()) {

					historyHandler.replaceCurrentPlace(place);
					historyHandler.goTo(place, true);
				} else {
					historyHandler.goTo(place);
				}

			}
		});

		HandlerRegistration register2 = ActionEvent.register(eventBus, ActionNames.BACK, new ActionEvent.Handler() {

			@Override
			public void onAction(ActionEvent event) {

				History.back();

			}
		});

		HandlerRegistration register = ActionEvent.register(eventBus, ActionNames.ANIMATION_END, new ActionEvent.Handler() {

			@Override
			public void onAction(ActionEvent event) {
				if (MGWT.getOsDetection().isPhone()) {
					History.back();
				} else {
					historyHandler.goTo(new AnimationPlace(), true);
				}

			}
		});

		HandlerRegistrationCollection col = new HandlerRegistrationCollection();
		col.addHandlerRegistration(register);
		col.addHandlerRegistration(register2);
		col.addHandlerRegistration(register3);
		col.addHandlerRegistration(addHandler);
		return col;
	}

	private void onPhoneNav(Place place, HistoryHandler historyHandler) {
		if (place instanceof AnimationDissolvePlace || place instanceof AnimationFadePlace || place instanceof AnimationFlipPlace || place instanceof AnimationPopPlace
				|| place instanceof AnimationSlidePlace || place instanceof AnimationSlideUpPlace || place instanceof AnimationSwapPlace) {

			historyHandler.replaceCurrentPlace(new HomePlace());

			historyHandler.pushPlace(new AnimationPlace());

		} else {
			if (place instanceof AboutPlace) {
				historyHandler.replaceCurrentPlace(new HomePlace());

			} else {
				if (place instanceof AnimationPlace) {
					historyHandler.replaceCurrentPlace(new HomePlace());
				} else {
					if (place instanceof UIPlace) {
						historyHandler.replaceCurrentPlace(new HomePlace());
					} else {
						if (place instanceof UIPlace) {
							historyHandler.replaceCurrentPlace(new HomePlace());
						} else {

							if (place instanceof EmailLoginPlace || place instanceof ForgotPasswordPlace || place instanceof HomePagePlace
									|| place instanceof ElementsPlace || place instanceof SearchPlace ||  
									place instanceof SignupPlace ||  
									place instanceof SearchResultsPlace) {
								historyHandler.replaceCurrentPlace(new HomePlace());

								historyHandler.pushPlace(new UIPlace());
							}

						}
					}
				}
			}
		}
	}

	private void onTabletNav(Place place, HistoryHandler historyHandler) {
		if (place instanceof AnimationDissolvePlace || place instanceof AnimationFadePlace || place instanceof AnimationFlipPlace || place instanceof AnimationPopPlace
				|| place instanceof AnimationSlidePlace || place instanceof AnimationSlideUpPlace || place instanceof AnimationSwapPlace) {

			historyHandler.replaceCurrentPlace(new HomePlace());

		} else {
			if (place instanceof AboutPlace) {
				historyHandler.replaceCurrentPlace(new HomePlace());
			} else {
				if (place instanceof AnimationPlace) {
					historyHandler.replaceCurrentPlace(new HomePlace());
				} else {
					if (place instanceof UIPlace) {
						historyHandler.replaceCurrentPlace(new HomePlace());
					} else {
						if (place instanceof UIPlace) {
							historyHandler.replaceCurrentPlace(new HomePlace());
						} else {

							if (place instanceof EmailLoginPlace ||  place instanceof ForgotPasswordPlace || place instanceof HomePagePlace
									|| place instanceof ElementsPlace || place instanceof SearchPlace  
									 || place instanceof SignupPlace || place instanceof SearchResultsPlace) {
								//historyHandler.replaceCurrentPlace(new HomePlace());

							}

						}
					}
				}
			}
		}
	}

}
