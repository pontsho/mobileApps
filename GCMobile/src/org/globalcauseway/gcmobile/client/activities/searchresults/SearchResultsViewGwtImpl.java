package org.globalcauseway.gcmobile.client.activities.searchresults;

import java.util.HashMap;
import java.util.List;

import org.globalcauseway.gcmobile.client.BasicCell;
import org.globalcauseway.gcmobile.client.DetailViewGwtImpl;
import org.globalcauseway.gcmobile.shared.dto.Product;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.WhiteSpace;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.MSearchBox;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarText;
import com.googlecode.mgwt.ui.client.widget.celllist.CellListWithHeader;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

public class SearchResultsViewGwtImpl extends DetailViewGwtImpl implements SearchResultsView {
	
	private MSearchBox searchBox;
	private Button searchButton;
	private CellListWithHeader<Product> cellList;
	FlexTable table;
	SearchResultsActivity activity;
	HashMap<ButtonBarText, Product> map;
	public SearchResultsViewGwtImpl() {

		cellList = new CellListWithHeader<Product>(new BasicCell<Product>() {

			@Override
			public String getDisplayString(Product model) {
				return model.getName();
			}

			@Override
			public boolean canBeSelected(Product model) {
				return true;
			}

		});

//		cellList.getCellList().setRound(true);
//		//cellList.getHeader().setText("Header");
//
//		//ScrollPanel scrollPanel = new ScrollPanel();
//		scrollPanel.setWidget(cellList);
//		scrollPanel.setScrollingEnabledX(false);
//		main.add(scrollPanel);
		
		
		table = new FlexTable();
		FlexTable header = new FlexTable();
		table.setWidth("100%");
		table.setText(0, 0, "Brand");
		table.setText(0, 1, "Philanthropy");
		table.setText(0, 2, "Causes");
		table.setText(0, 3, "Quantum");
		table.setText(0, 4, "Globe");
		table.setCellSpacing(0);
		table.setCellPadding(2);

		
		FlowPanel container =  new FlowPanel();
		container.add(header);
		container.add(table);
		table.getRowFormatter().addStyleName(0, "detail-header");

		scrollPanel.add(container);
		scrollPanel.setScrollingEnabledX(false);
		main.add(scrollPanel);
	}
	
	@Override
	public void setPresenter(SearchResultsActivity activity){
		this.activity = activity;
	}
		
	
	@Override
	public HasCellSelectedHandler getCellSelectedHandler() {
		return cellList.getCellList();
	}

	@Override
	public void setTopics(List<Product> createTopicsList) {
		//cellList.getCellList().render(createTopicsList);
		map = new HashMap<ButtonBarText, Product>();
		for (int i = 0; i < createTopicsList.size(); i++) {
			Product details = createTopicsList.get(i);
			ButtonBarText buttonBarText = new ButtonBarText();
			buttonBarText.getElement().getStyle().setMarginTop(0, Unit.PX);
			buttonBarText.getElement().getStyle().setWhiteSpace(WhiteSpace.NORMAL);
			map.put(buttonBarText, details);
			buttonBarText.addTapHandler(new TapHandler() {
			
				@Override
				public void onTap(TapEvent event) {
					
					ButtonBarText b = (ButtonBarText)event.getSource();
					activity.goToNewPlace(map.get(b));
					
				}
			});
			
			buttonBarText.setHTML(details.getName());

			table.setWidget(i+1, 0, buttonBarText);
		
			table.setText(i+1, 1, details.getPhilanthropy());
			table.setText(i+1, 2, details.getCauses());
			table.setText(i+1, 3, details.getQuantum().equals("Undisclosed")?details.getQuantum():details.getQuantum() +"%");
			//table.setText(i, 3, details.getGlobes());
			if (details.getImage() != null) {
				table.setWidget(i+1, 4, new Image(details.getImage()));
			} else {
				table.setText(i+1, 4, "-");
			}
			
			
			table.getRowFormatter().addStyleName(i+1, "table");
		}
		
		//format after adding the second row to avoid exceptions
		//table.getRowFormatter().getElement(1).getStyle().setBackgroundColor("white");
		
		
	}

	@Override
	public HasText getFirstHeader() {
		return cellList.getHeader();
	}
}
