package org.globalcauseway.gcmobile.client.activities.branddetails;

import org.globalcauseway.gcmobile.shared.dto.Product;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class BrandDetailsPlace extends Place {
	private Product selectedProduct;
	public static class Tokenizer implements PlaceTokenizer<BrandDetailsPlace> {

		@Override
		public BrandDetailsPlace getPlace(String token) {
			return new BrandDetailsPlace();
		}

		@Override
		public String getToken(BrandDetailsPlace place) {
			return "";
		}

	}
	public Product getSelectedProduct() {
		return selectedProduct;
	}
	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	
}
