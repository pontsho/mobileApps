package org.globalcauseway.gcmobile.client.activities.homepage;

import java.util.Iterator;
import java.util.List;

import org.globalcauseway.gcmobile.client.ClientFactory;
import org.globalcauseway.gcmobile.client.DetailActivity;
import org.globalcauseway.gcmobile.client.activities.search.SearchPlace;
import org.globalcauseway.gcmobile.shared.DataModel;
import org.globalcauseway.gcmobile.shared.dto.Product;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

/**
 * @author Pontsho Molewa
 * 
 */
public class HomePageActivity extends DetailActivity {

	private final ClientFactory clientFactory;
	int index = 0;
	public HomePageActivity(ClientFactory clientFactory) {
		super(clientFactory.getHomePageView(), "nav");
		this.clientFactory = clientFactory;

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		HomePageView view = clientFactory.getHomePageView();

		view.getBackbuttonText().setText("signout");
		view.getMainButtonText().setText("Nav");
		view.getHeader().setText("Good Cents");
		
		addHandlerRegistration(view.getSearchButton().addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				clientFactory.getPlaceController().goTo(new SearchPlace());
				
			}
		}));
		DataModel dataModel = new DataModel();
		StringBuffer stringBuffer = new StringBuffer("");
		for (Product prd : dataModel.getAllProducts()) {
			stringBuffer.append(prd.getName()+" : "+prd.getCategoryname()+"<br>");
		}
		 view.getNewUpdates().setHTML(stringBuffer.toString());
		
		final List<String> trivias = DataModel.getTrivia();
		view.getTrivia().setHTML(trivias.get(0));
		index = 0;
		clientFactory.getHomePageView().disableTriviaButton(index, trivias.size());
		addHandlerRegistration(view.getTriviaback1().addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				if (index>0) {
					index = index - 1;
					clientFactory.getHomePageView().disableTriviaButton(index, trivias.size());
					clientFactory.getHomePageView().getTrivia().setHTML(trivias.get(index));
				}
				
			}
		}));
		addHandlerRegistration(view.getTriviaright1().addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				if (index<trivias.size()-1) {
					index = index + 1;
					clientFactory.getHomePageView().disableTriviaButton(index, trivias.size());
					clientFactory.getHomePageView().getTrivia().setHTML(trivias.get(index));
				}
				
			}
		}));

		panel.setWidget(view);
	}

}
