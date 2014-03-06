package org.globalcauseway.gcmobile.client;

import org.globalcauseway.gcmobile.client.activities.AboutView;
import org.globalcauseway.gcmobile.client.activities.AboutViewGwtImpl;
import org.globalcauseway.gcmobile.client.activities.ShowCaseListView;
import org.globalcauseway.gcmobile.client.activities.ShowCaseListViewGwtImpl;
import org.globalcauseway.gcmobile.client.activities.UIView;
import org.globalcauseway.gcmobile.client.activities.UIViewImpl;
import org.globalcauseway.gcmobile.client.activities.animation.AnimationView;
import org.globalcauseway.gcmobile.client.activities.animation.AnimationViewGwtImpl;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationDoneView;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationDoneViewGwtImpl;
import org.globalcauseway.gcmobile.client.activities.authentication.emaillogin.EmailLoginView;
import org.globalcauseway.gcmobile.client.activities.authentication.emaillogin.EmailLoginViewGwtImpl;
import org.globalcauseway.gcmobile.client.activities.authentication.passwordreset.SignupView;
import org.globalcauseway.gcmobile.client.activities.authentication.passwordreset.SignupViewGwtImpl;
import org.globalcauseway.gcmobile.client.activities.authentication.signup.ForgotPasswordView;
import org.globalcauseway.gcmobile.client.activities.authentication.signup.ForgotPasswordViewGwtImpl;
import org.globalcauseway.gcmobile.client.activities.branddetails.BrandDetailsView;
import org.globalcauseway.gcmobile.client.activities.branddetails.BrandDetailsViewGwtImpl;
import org.globalcauseway.gcmobile.client.activities.homepage.HomePageView;
import org.globalcauseway.gcmobile.client.activities.homepage.HomePageViewGwtImpl;
import org.globalcauseway.gcmobile.client.activities.search.SearchView;
import org.globalcauseway.gcmobile.client.activities.search.SearchViewGwtImpl;
import org.globalcauseway.gcmobile.client.activities.searchresults.SearchResultsView;
import org.globalcauseway.gcmobile.client.activities.searchresults.SearchResultsViewGwtImpl;
import org.globalcauseway.gcmobile.client.activities.slideShow.ElementsView;
import org.globalcauseway.gcmobile.client.activities.slideShow.ElementsViewImpl;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;


public class ClientFactoryImpl implements ClientFactory {

	private EventBus eventBus;
	private PlaceController placeController;
	private ShowCaseListView homeViewImpl;
	private UIView uiView;
	private AboutView aboutView;
	private AnimationView animationView;
	private AnimationDoneView animationDoneView;
	private ElementsView elementsView;
	private EmailLoginViewGwtImpl emailLoginView;
	private SignupView signupView;
	private HomePageView homePageView;

	private SearchViewGwtImpl formsView;
	private ForgotPasswordView forgotPasswordView;
	private SearchResultsView searchResultsView;
	private BrandDetailsView brandDetailsView;

	public ClientFactoryImpl() {
		eventBus = new SimpleEventBus();

		placeController = new PlaceController(eventBus);

		homeViewImpl = new ShowCaseListViewGwtImpl();
	}

	@Override
	public ShowCaseListView getHomeView() {
		if (homeViewImpl == null) {
			homeViewImpl = new ShowCaseListViewGwtImpl();
		}
		return homeViewImpl;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public UIView getUIView() {
		if (uiView == null) {
			uiView = new UIViewImpl();
		}
		return uiView;
	}

	@Override
	public AboutView getAboutView() {
		if (aboutView == null) {
			aboutView = new AboutViewGwtImpl();
		}

		return aboutView;
	}

	@Override
	public AnimationView getAnimationView() {
		if (animationView == null) {
			animationView = new AnimationViewGwtImpl();
		}
		return animationView;
	}

	@Override
	public AnimationDoneView getAnimationDoneView() {
		if (animationDoneView == null) {
			animationDoneView = new AnimationDoneViewGwtImpl();
		}
		return animationDoneView;
	}


	@Override
	public ElementsView getElementsView() {
		if (elementsView == null) {
			elementsView = new ElementsViewImpl();
		}
		return elementsView;
	}

	@Override
	public EmailLoginView getEmailLoginView() {
		if (emailLoginView == null) {
			emailLoginView = new EmailLoginViewGwtImpl();
		}
		return emailLoginView;
	}

	@Override
	public SignupView getTabBarView() {
		if (signupView == null) {
			signupView = new SignupViewGwtImpl();
		}
		return signupView;
	}

	@Override
	public HomePageView getHomePageView() {
		if (homePageView == null) {
			homePageView = new HomePageViewGwtImpl();
		}
		return homePageView;
	}




	@Override
	public SearchView getFormsView() {
		if (formsView == null) {
			formsView = new SearchViewGwtImpl();
		}
		return formsView;
	}

	@Override
	public ForgotPasswordView getSignupView() {
		if (forgotPasswordView == null) {
			forgotPasswordView = new ForgotPasswordViewGwtImpl();
		}
		return forgotPasswordView;
	}

	@Override
	public SearchResultsView getSearchResultsView() {
		if(searchResultsView == null){
			searchResultsView = new SearchResultsViewGwtImpl();
		}
		return searchResultsView;
	}

	@Override
	public BrandDetailsView getBrandDetailsView() {
		if(brandDetailsView == null){
			brandDetailsView = new BrandDetailsViewGwtImpl();
		}
		return brandDetailsView;
	}


}
