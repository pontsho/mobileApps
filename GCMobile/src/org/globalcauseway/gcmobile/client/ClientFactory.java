package org.globalcauseway.gcmobile.client;

import org.globalcauseway.gcmobile.client.activities.AboutView;
import org.globalcauseway.gcmobile.client.activities.ShowCaseListView;
import org.globalcauseway.gcmobile.client.activities.UIView;
import org.globalcauseway.gcmobile.client.activities.animation.AnimationView;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationDoneView;
import org.globalcauseway.gcmobile.client.activities.authentication.emaillogin.EmailLoginView;
import org.globalcauseway.gcmobile.client.activities.authentication.passwordreset.SignupView;
import org.globalcauseway.gcmobile.client.activities.authentication.signup.ForgotPasswordView;
import org.globalcauseway.gcmobile.client.activities.branddetails.BrandDetailsView;
import org.globalcauseway.gcmobile.client.activities.slideShow.ElementsView;
import org.globalcauseway.gcmobile.client.activities.homepage.HomePageView;
import org.globalcauseway.gcmobile.client.activities.search.SearchView;
import org.globalcauseway.gcmobile.client.activities.searchresults.SearchResultsView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author Pontsho
 * 
 */
public interface ClientFactory {
	public ShowCaseListView getHomeView();

	public EventBus getEventBus();

	public PlaceController getPlaceController();

	/**
	 * @return
	 */
	public UIView getUIView();

	public AboutView getAboutView();

	public AnimationView getAnimationView();

	public AnimationDoneView getAnimationDoneView();

	public ElementsView getElementsView();

	public EmailLoginView getEmailLoginView();


	public SignupView getTabBarView();

	public HomePageView getHomePageView();


	public ForgotPasswordView getSignupView();

	public SearchView getFormsView();
	
	public SearchResultsView getSearchResultsView();
	
	public BrandDetailsView getBrandDetailsView();
	
}
