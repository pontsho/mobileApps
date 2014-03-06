package org.globalcauseway.gcmobile.client.activities.branddetails;

import java.util.List;

import org.globalcauseway.gcmobile.client.DetailView;
import org.globalcauseway.gcmobile.shared.dto.Product;
import org.globalcauseway.gcmobile.shared.dto.ProductCategory;

import com.google.gwt.user.client.ui.HasText;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

public interface BrandDetailsView extends DetailView {

	public HasCellSelectedHandler getCellSelectedHandler();
	public HasText getFirstHeader();
	void setProductDetails(Product details);
	void setProductCategories(List<ProductCategory> createTopicsList);
	public HasTapHandlers getOther();
	void cancelPopup();
	HasTapHandlers getCancel();
}
