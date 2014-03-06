package org.globalcauseway.gcmobile.client.activities.searchresults;

import java.util.ArrayList;
import java.util.List;

import org.globalcauseway.gcmobile.client.ClientFactory;
import org.globalcauseway.gcmobile.client.DetailActivity;
import org.globalcauseway.gcmobile.client.activities.branddetails.BrandDetailsPlace;
import org.globalcauseway.gcmobile.shared.DataModel;
import org.globalcauseway.gcmobile.shared.dto.Product;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SearchResultsActivity extends DetailActivity {

	private final ClientFactory clientFactory;
	
	List<Product> products = new ArrayList<Product>();
	private SearchResultsPlace place;
	public SearchResultsActivity(ClientFactory clientFactory) {
		super(clientFactory.getFormsView(), "nav");
		this.clientFactory = clientFactory;
		place= (SearchResultsPlace)clientFactory.getPlaceController().getWhere();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		SearchResultsView view = clientFactory.getSearchResultsView();
		view.getMainButtonText().setText("Nav");
		view.getBackbuttonText().setText("back");
		view.getHeader().setText("Results");
		if(place != null && place.getSelectedCategoryId() != null)
		 view.setTopics(createTopicsList());
		view.setPresenter(this);
		panel.setWidget(view);
	}
	
	private List<Product> createTopicsList() {
		DataModel model =  new DataModel();
		
		int id = Integer.valueOf(place.getSelectedCategoryId());
	    products = model.getProductsByCategoryId(id);

	    return products;
	  }
	
	public void goToNewPlace(Product product) {
		BrandDetailsPlace detailsPlace =  new BrandDetailsPlace();
        detailsPlace.setSelectedProduct(product);
        clientFactory.getPlaceController().goTo(detailsPlace);
	}
}
