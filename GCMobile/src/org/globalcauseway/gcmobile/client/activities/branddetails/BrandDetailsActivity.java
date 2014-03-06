package org.globalcauseway.gcmobile.client.activities.branddetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.globalcauseway.gcmobile.client.ClientFactory;
import org.globalcauseway.gcmobile.client.DetailActivity;
import org.globalcauseway.gcmobile.client.activities.searchresults.SearchResultsPlace;
import org.globalcauseway.gcmobile.shared.DataModel;
import org.globalcauseway.gcmobile.shared.dto.Product;
import org.globalcauseway.gcmobile.shared.dto.ProductCategory;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

public class BrandDetailsActivity extends DetailActivity {

	private final ClientFactory clientFactory;
	BrandDetailsPlace place;
	List<ProductCategory> list;
	public BrandDetailsActivity(ClientFactory clientFactory) {
		super(clientFactory.getFormsView(), "nav");
		this.clientFactory = clientFactory;
		place= (BrandDetailsPlace)clientFactory.getPlaceController().getWhere();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		BrandDetailsView view = clientFactory.getBrandDetailsView();
		view.getMainButtonText().setText("Nav");
		view.getBackbuttonText().setText("back");
		view.getHeader().setText(place.getSelectedProduct().getName());
		
		view.setProductDetails(place.getSelectedProduct());
		view.cancelPopup();
		addHandlerRegistration(view.getOther().addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				BrandDetailsView view = clientFactory.getBrandDetailsView();
				view.setProductCategories(getCategories());
			}
		}));
		addHandlerRegistration(view.getCancel().addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				BrandDetailsView view = clientFactory.getBrandDetailsView();
				view.cancelPopup();
			}
		}));
		addHandlerRegistration(view.getCellSelectedHandler().addCellSelectedHandler(
			        new CellSelectedHandler() {

			          @Override
			          public void onCellSelected(CellSelectedEvent event) {
			            int index = event.getIndex();
			            
			            SearchResultsPlace newplace = new  SearchResultsPlace();
						newplace.setSelectedCategoryId(String.valueOf(list.get(index).getId()));
			            clientFactory.getPlaceController().goTo(newplace);
			          }
			        }));
		panel.setWidget(view);
	}
	
	private List<ProductCategory> getCategories() {
		DataModel model =  new DataModel();
		Map<ProductCategory, String> categoryMap = new HashMap<ProductCategory, String>();
		for (Product product : model.getAllProducts()) {
			if(place.getSelectedProduct().getName().equals(product.getName())){
			for (ProductCategory cat : model.getAllCategoryProducts()) {
				if (cat.getId() == product.getCategory()) {
					categoryMap.put(cat, product.getName());
				}
			}
		
			}
		}
		list= new ArrayList<ProductCategory>();
		for (ProductCategory cat : categoryMap.keySet()) {
			list.add(cat);
		}
	    return list;
	  }

}
