package org.globalcauseway.gcmobile.client.activities.searchresults;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SearchResultsPlace extends Place {
	private String selectedCategoryId;
	private String searchString;
	private String quantum;
	private String globes;
	public static class Tokenizer implements PlaceTokenizer<SearchResultsPlace> {

		@Override
		public SearchResultsPlace getPlace(String token) {
			return new SearchResultsPlace();
		}

		@Override
		public String getToken(SearchResultsPlace place) {
			return "";
		}

	}
	public String getSelectedCategoryId() {
		return selectedCategoryId;
	}
	public void setSelectedCategoryId(String selectedCategoryId) {
		this.selectedCategoryId = selectedCategoryId;
	}
	public String getSearchString() {
		return searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	public String getGlobes() {
		return globes;
	}
	public void setGlobes(String globes) {
		this.globes = globes;
	}
	public String getQuantum() {
		return quantum;
	}
	public void setQuantum(String quantum) {
		this.quantum = quantum;
	}
}
