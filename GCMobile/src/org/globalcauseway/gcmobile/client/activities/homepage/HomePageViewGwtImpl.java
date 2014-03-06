package org.globalcauseway.gcmobile.client.activities.homepage;

import org.globalcauseway.gcmobile.client.DetailViewGwtImpl;
import org.globalcauseway.gcmobile.client.css.AppBundle;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.theme.base.ProgressBarCss;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarText;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ComposeButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.SearchButton;


public class HomePageViewGwtImpl extends DetailViewGwtImpl implements HomePageView {

	private SearchButton searchButton;
	private ComposeButton composeButton;
	private HTML newUpdates = new HTML("Zhai....");
	private HTML trivia = new HTML("Zhai....");
	private ButtonBarText triviaback1 = new ButtonBarText("Back");
	private ButtonBarText triviaright1 = new ButtonBarText("Next");
	private HTML updatecount = new HTML("1 of 1");
	private HTML triviacount = new HTML("0 of 0");
	public HomePageViewGwtImpl() {
		main.add(scrollPanel);
		composeButton = new ComposeButton();
		searchButton =  new SearchButton();
		
		searchButton.getElement().getStyle().setPosition(Position.ABSOLUTE);
		headerPanel.setLeftWidget(composeButton);
		headerPanel.setRightWidget(searchButton);
		
		String styleProps = "font-size: 11px;text-align: center;vertical-align: middle;padding-top: 3px;";
		updatecount.getElement().setAttribute("style", styleProps);
		triviacount.getElement().setAttribute("style", styleProps);
		
		FlexTable table =  new FlexTable();
		table.setWidget(0, 0, new HTML("Product Updates"));
		table.setWidget(0, 1, new HTML("Trivia"));
	    FlowPanel content = new FlowPanel();
	    
	    table.setWidget(1, 0, newUpdates);
		table.setWidget(1, 1, trivia);
		
		table.getCellFormatter().addStyleName(1, 0, "mgwt-RoundPanel");
		table.getCellFormatter().addStyleName(1, 1, "mgwt-RoundPanel");
		table.getCellFormatter().getElement(1, 0).setAttribute("style", "border-radius: 0px !important;font-size: 12px !important;vertical-align: top;width: 131px;");
		table.getCellFormatter().getElement(1, 1).setAttribute("style", "border-radius: 0px !important;font-size: 12px !important;vertical-align: top;width: 131px;");
		
	    HorizontalPanel leftcontrol =  new  HorizontalPanel();
	    ButtonBarText back = new ButtonBarText("Back");
	    ButtonBarText right = new ButtonBarText("Next");
	    leftcontrol.add(back);
	    leftcontrol.add(updatecount);
	    leftcontrol.add(right);
	    leftcontrol.setWidth("100%");
	    
	    HorizontalPanel rightcontrol =  new  HorizontalPanel();
	  
	    rightcontrol.add(triviaback1);
	    rightcontrol.add(triviacount);
	    rightcontrol.add(triviaright1);
	    rightcontrol.setWidth("100%");
	    
	    back.getElement().getStyle().setColor("grey");
//	    triviaback1.getElement().getStyle().setColor("grey");
//	    triviaright1.getElement().getStyle().setColor("grey");
	    right.getElement().getStyle().setColor("grey");
	    
	    right.addStyleName("navbuttonBarText");
	    back.addStyleName("navbuttonBarText");
	    triviaback1.addStyleName("navbuttonBarText");
	    triviaright1.addStyleName("navbuttonBarText");
	    
	    table.setWidget(2, 0, leftcontrol);
	    table.setWidget(2, 1, rightcontrol);
	   
	    table.setWidget(3, 0, new Image(AppBundle.INSTANCE.themeplaceholder_150()));
	    table.setWidget(3, 1, new Image(AppBundle.INSTANCE.unlock()));
	    
	    table.getCellFormatter().getElement(3, 0).setAttribute("style", "padding-left: 2px ;");
		table.getCellFormatter().getElement(3, 1).setAttribute("style", "padding-left: 2px ;");
	    
	    scrollPanel.setScrollingEnabledX(false);
	
	    
	
	    HTML spacer = new HTML();
	    spacer.setHeight("100px");
	    content.add(table);
	   // ProgressBarCss getProgressBarCss()
	    content.getElement().getStyle().setPadding(5, Unit.PX);
	    scrollPanel.setWidget(content);

	}
	
	@Override
  	public HasTapHandlers getSearchButton() {
		return searchButton;
	}
	
	@Override
	public HasTapHandlers getComposeButton() {
		return composeButton;
	}

	@Override
	public HTML getNewUpdates() {
		return newUpdates;
	}

	@Override
	public HasTapHandlers getTriviaback1() {
		return triviaback1;
	}

	@Override
	public HasTapHandlers getTriviaright1() {
		return triviaright1;
	}

	@Override
	public HTML getTrivia() {
		return trivia;
	}
	
	@Override
	public void disableTriviaButton(int index, int size){
		if (index == 0) {
		    triviaback1.getElement().getStyle().setColor("grey");
		}else{
		    triviaback1.getElement().getStyle().setColor("#2c4ebb");
		}
		
		if (index == size - 1 ) {
		    triviaright1.getElement().getStyle().setColor("grey");
		}else{
		    triviaright1.getElement().getStyle().setColor("#2c4ebb");
		}
		
		triviacount.setHTML(index+1+" of "+size);
	}

}
