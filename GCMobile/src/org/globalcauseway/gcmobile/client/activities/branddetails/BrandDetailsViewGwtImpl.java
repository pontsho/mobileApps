package org.globalcauseway.gcmobile.client.activities.branddetails;

import java.util.List;

import org.globalcauseway.gcmobile.client.DetailViewGwtImpl;
import org.globalcauseway.gcmobile.client.css.AppBundle;
import org.globalcauseway.gcmobile.shared.dto.*;

import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.MSearchBox;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBar;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarText;
import com.googlecode.mgwt.ui.client.widget.celllist.BasicCell;
import com.googlecode.mgwt.ui.client.widget.celllist.CellListWithHeader;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

public class BrandDetailsViewGwtImpl extends DetailViewGwtImpl implements BrandDetailsView {
	
	private MSearchBox searchBox;
	private Button searchButton;
	private CellListWithHeader<ProductCategory> cellList;
	FlexTable table;
	private StringBuffer buffer = new StringBuffer();
	private StringBuffer buffer1 = new StringBuffer();
	HTML html = new HTML();
	HTML html1 = new HTML();
	private ButtonBarText other;
	Button cancel ;
	FlowPanel fPanel ;
	public BrandDetailsViewGwtImpl() {
		other = new ButtonBarText("Other products");
		FlexTable wrapper =  new FlexTable();
		cancel =new Button("Cancel");
		table = new FlexTable();
		HTML header = new HTML();
		header.setText("At a Glance");
		header.getElement().getStyle().setMarginLeft(10, Unit.PX);
		table.setText(0, 0, "Philanthropy");
		table.setText(0, 1, "Causes");
		table.setText(0, 2, "Quantum");
		table.setText(0, 3, "Globe Rank");
		table.setCellSpacing(0);
		table.setCellPadding(2);
		table.getElement().getStyle().setMarginLeft(10, Unit.PX);
		table.setWidth("100%");
		wrapper.setWidth("100%");
		
		wrapper.setWidget(0, 0, table);
		Image logo = new Image(AppBundle.INSTANCE.zai_logo38());
		logo.setWidth("100%");
		logo.setHeight("100%");
		//logo.setPixelSize(48, 48);
		//wrapper.setWidget(0, 1, logo);
		FlowPanel container =  new FlowPanel();
		container.add(header);
		container.add(wrapper);
		table.getRowFormatter().addStyleName(0, "detail-header");
		
		RoundPanel roundPanel = new RoundPanel();
		//roundPanel.setWidth("1000px");

		
		roundPanel.add(html);
		
		RoundPanel roundPanel1 = new RoundPanel();
//		roundPanel1.setWidth("1000px");

		roundPanel1.add(html1);

		container.add(roundPanel);
		container.add(roundPanel1);
		
		scrollPanel.add(container);
		scrollPanel.setScrollingEnabledX(false);
		main.add(scrollPanel);
		
		ButtonBar bar = new ButtonBar();
		
		other.getElement().getStyle().setPaddingLeft(5, Unit.PX);
		bar.add(other);
		
		ButtonBarText contactus = new ButtonBarText("Contact them");
		contactus.getElement().getStyle().setFloat(Float.RIGHT);
		contactus.getElement().getStyle().setPosition(Position.ABSOLUTE);
		contactus.getElement().getStyle().setRight(0, Unit.PX);
		contactus.getElement().getStyle().setPaddingRight(5, Unit.PX);
		
		bar.add(contactus);
		
		bar.getElement().setAttribute("style", "background: -webkit-gradient(linear,left bottom,left top,color-stop(0, #053650),color-stop(1, #aacbdc));");
		main.add(bar);
		
	}
	
	@Override
	public HasCellSelectedHandler getCellSelectedHandler() {
		return cellList.getCellList();
	}

	@Override
	public void setProductCategories(List<ProductCategory> createTopicsList) {
		cellList.getCellList().render(createTopicsList);
		fPanel = new FlowPanel();
		fPanel.getElement().setAttribute("style", "z-index: 100;background-color: rgba(151, 142, 142, 0.4);top: 0;left: 0;right: 0;bottom: 0;overflow: hidden;-webkit-perspective: 800;-webkit-backface-visibility: hidden;position: absolute;");;
		main.add(fPanel);
		
		FlowPanel content = new FlowPanel();
		content.add(cellList);
		content.add(cancel);
		fPanel.add(content);
		content.getElement().setAttribute("style", "bottom: 5%;position: absolute;border-top: 1px solid #030506;padding: 10px;left: 0;right: 0;background-image:-webkit-gradient(linear, 0% 0, 0% 100%, from(rgba(50, 74, 103, 0.9)), color-stop(0.02, rgba(20, 25, 35, 0.9) ), to(rgba(0, 0, 0, 0.0) ) )");
		
	}
	@Override
	public void cancelPopup() {
		if (fPanel != null) {
			main.remove(fPanel);
			fPanel.clear();
			fPanel =  null;
		}
		
	}
	@Override
	public void setProductDetails(Product details) {
		Image image = new Image(details.getLogo());
		image.addStyleName("logo");
		headerPanel.setRightWidget(image);
		headerPanel.setHeight("49px");
		
		table.setText(1, 0, details.getPhilanthropy());
		table.setText(1, 1, details.getCauses());
		table.setText(1, 2, details.getQuantum());
		//table.setText(i, 3, details.getGlobes());
		if (details.getImage() != null) {
			table.setWidget(1, 3, new Image(details.getImage()));
		} else {
			table.setText(1, 3, "-");
		}
		//format after adding the second row to avoid exceptions
		//table.getRowFormatter().getElement(1).getStyle().setBackgroundColor("white");
		table.getRowFormatter().addStyleName(1, "table");
		
		buffer = new StringBuffer();		
		buffer.append("<b>They say..</b> ");

		buffer1 = new StringBuffer();
		buffer1.append("<b>We say..</b> ");
		
		buffer.append(details.getTheySay());
		buffer1.append(details.getWeSay());
		
		html.setHTML(buffer.toString());
		html1.setHTML(buffer1.toString());
		
		cellList = new CellListWithHeader<ProductCategory>(new BasicCell<ProductCategory>() {

			@Override
			public String getDisplayString(ProductCategory model) {
				return model.getName();
			}
		});
	}

	@Override
	public HasText getFirstHeader() {
		return cellList.getHeader();
	}
	
	public HasTapHandlers getOther(){
		return other;
	}
	
	@Override
	public HasTapHandlers getCancel(){
		return cancel;
	}

}
