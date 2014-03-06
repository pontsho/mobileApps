/*
 * Copyright 2012 Daniel Kurka
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
package org.globalcauseway.gcmobile.client.activities.search;

import java.util.List;

import org.globalcauseway.gcmobile.client.ClientFactory;
import org.globalcauseway.gcmobile.client.DetailActivity;
import org.globalcauseway.gcmobile.client.activities.searchresults.SearchResultsPlace;
import org.globalcauseway.gcmobile.shared.DataModel;
import org.globalcauseway.gcmobile.shared.dto.ProductCategory;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

public class SearchActivity extends DetailActivity {

	private final ClientFactory clientFactory;

	public SearchActivity(ClientFactory clientFactory) {
		super(clientFactory.getFormsView(), "nav");
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		SearchView view = clientFactory.getFormsView();
		view.getProductCategoryListBox().clear();
		DataModel dataModel =  new DataModel();
		view.getMainButtonText().setText("Nav");
		view.getBackbuttonText().setText("Home");
		view.getHeader().setText("Search");

		addHandlerRegistration(view.getSearchButton().addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				SearchResultsPlace newplace = new  SearchResultsPlace();
				newplace.setSelectedCategoryId(clientFactory.getFormsView().getProductCategoryListBox().getValue(clientFactory.getFormsView().getProductCategoryListBox().getSelectedIndex()));
				clientFactory.getPlaceController().goTo(newplace);
			}
		}));
		
		addHandlerRegistration(view.getProductCategory().addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				// TODO Auto-generated method stub
			
				
			}
		}));
		
		List<ProductCategory> categories = dataModel.getAllCategoryProducts();
		for (ProductCategory productCategory : categories) {
			view.getProductCategoryListBox().addItem(productCategory.getName(), String.valueOf(productCategory.getId()));
		}
		
		panel.setWidget(view);
	}
	

}
