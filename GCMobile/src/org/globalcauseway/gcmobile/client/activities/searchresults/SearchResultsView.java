package org.globalcauseway.gcmobile.client.activities.searchresults;

import java.util.List;

import org.globalcauseway.gcmobile.client.DetailView;
import org.globalcauseway.gcmobile.shared.dto.Product;

import com.google.gwt.user.client.ui.HasText;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

public interface SearchResultsView extends DetailView {

	public HasCellSelectedHandler getCellSelectedHandler();
	public void setTopics(List<Product> createTopicsList);
	public HasText getFirstHeader();
	void setPresenter(SearchResultsActivity activity);

}
