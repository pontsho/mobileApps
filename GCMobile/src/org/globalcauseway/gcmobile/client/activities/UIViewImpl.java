
package org.globalcauseway.gcmobile.client.activities;

import java.util.List;

import org.globalcauseway.gcmobile.client.BasicCell;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.Carousel;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

/**
 * @author Daniel Kurka
 * 
 */
public class UIViewImpl implements UIView {

	private LayoutPanel main;
	private HeaderPanel headerPanel;
	private HeaderButton headerBackButton;
	private CellList<Item> cellListWithHeader;
	private Carousel carousel;
	public UIViewImpl() {
		main = new LayoutPanel();

		main.getElement().setId("testdiv");

		headerPanel = new HeaderPanel();
		main.add(headerPanel);

		headerBackButton = new HeaderButton();
		headerBackButton.setBackButton(true);
		headerPanel.setLeftWidget(headerBackButton);
		
		//TODO uncomments this before going to actual phone
		//headerBackButton.setVisible(!MGWT.getOsDetection().isAndroid());

		carousel = new Carousel();

		main.add(carousel);

		for (int i = 0; i < 5; i++) {

			ScrollPanel scrollPanel2 = new ScrollPanel();
			scrollPanel2.setScrollingEnabledX(false);
			// scrollPanel2.setWidth("100%");

			RoundPanel flowPanel3 = new RoundPanel();
			for (int j = 0; j < 10; j++) {
				HTML html = new HTML("Slide: " + (i + 1));
				html.getElement().getStyle().setMarginBottom(300, Unit.PX);
				flowPanel3.add(html);
			}

			scrollPanel2.setWidget(flowPanel3);

			carousel.add(scrollPanel2);
		}


	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public void setBackButtonText(String text) {
		headerBackButton.setText(text);

	}

	@Override
	public HasTapHandlers getBackButton() {
		return headerBackButton;
	}

	@Override
	public void setTitle(String title) {
		headerPanel.setCenter(title);

	}

	@Override
	public HasCellSelectedHandler getList() {
		return cellListWithHeader;
	}

	@Override
	public void renderItems(List<Item> items) {
		//cellListWithHeader.render(items);

	}

	@Override
	public void setSelectedIndex(int index, boolean selected) {
		//cellListWithHeader.setSelectedIndex(index, selected);

	}

}
