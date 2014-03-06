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

import org.globalcauseway.gcmobile.client.DetailViewGwtImpl;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.MListBox;
import com.googlecode.mgwt.ui.client.widget.MNumberTextBox;
import com.googlecode.mgwt.ui.client.widget.MSearchBox;
import com.googlecode.mgwt.ui.client.widget.MSlider;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

public class SearchViewGwtImpl extends DetailViewGwtImpl implements SearchView {
	
	private MSearchBox searchBox;
	private Button searchButton;
	private MNumberTextBox charity;
	private MSlider charitySlider;
	private MListBox productCategory;
	
	public SearchViewGwtImpl() {

		FlowPanel container = new FlowPanel();

		HTML header = new HTML("Search");
		header.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getListCss().listHeader()) ;
		searchBox = new MSearchBox();
		searchBox.setPlaceHolder("Search");
		searchButton = new Button("Search");
		charity =  new MNumberTextBox();
		charitySlider =  new MSlider();
		
		WidgetList widgetList = new WidgetList();
		if (MGWT.getOsDetection().isAndroid()) {
			widgetList.addStyleName("mgwt-List-round-android");
		}
		widgetList.setRound(true);

		Label lbl = new Label(" % profits to charity");
		lbl.getElement().getStyle().setFontSize(12, Unit.PX);
		charity.getElement().getStyle().setWidth(37, Unit.PX);
		lbl.getElement().getStyle().setLineHeight(28, Unit.PX);
		lbl.getElement().getStyle().setPaddingLeft(5, Unit.PX);
		FlowPanel vpanel = new FlowPanel();
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.add(charity);
		hPanel.add(lbl);
		//hPanel.getElement().getStyle().setPaddingLeft(20, Unit.PX);
		vpanel.add(charitySlider);
		vpanel.add(hPanel);
		productCategory =  new MListBox();
		productCategory.addItem("Select Product");
		productCategory.addItem("Milk");
		productCategory.addItem("Fashion labels");
		
		MListBox causes =  new MListBox();
		causes.addItem("Select Cause");
		causes.addItem("Animal Rights");
		causes.addItem("Community Building");
		causes.addItem("Culture & the Arts");
		causes.addItem("Education");
		causes.addItem("Environmental Conservation");
		causes.addItem("Healthcare");
		causes.addItem("Labour Rights");
		causes.addItem("National Building");
		causes.addItem("Poverty");
		causes.addItem("VWO support");
		
		MTextBox globes = new MTextBox();
		globes.setPlaceHolder("Globes");
		
		widgetList.add(searchBox);
		widgetList.add(productCategory);
		widgetList.add(causes);
		widgetList.add(vpanel);
		widgetList.add(globes);
		
		charity.addStyleName("textinput");
		globes.addStyleName("textinput");

		charitySlider.setWidth("98%");
		charitySlider.getElement().getStyle().setMarginLeft(4, Unit.PX);
		charitySlider.setMax(4);
		
		charitySlider.addValueChangeHandler(new ValueChangeHandler<Integer>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Integer> event) {
				if(event.getValue() ==0){
					charity.setValue("0.5");
				}
				if(event.getValue() ==1){
					charity.setValue(String.valueOf(event.getValue()));
				}
				if(event.getValue() ==2){
					charity.setValue("1.5");
				}
				if(event.getValue() ==3){
					charity.setValue(String.valueOf(event.getValue()-1));
				}
				
			}
		});
		
		charity.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				if(event.getValue().equals("0.5")){
					charitySlider.setValue(0);
				}
				if(event.getValue().equals("1")){
					charitySlider.setValue(1);
				}
				if(event.getValue().equals("1.5")){
					charitySlider.setValue(2);
				}
				if(event.getValue().equals("2")){
					charitySlider.setValue(3);
				}
			
			}
		});

		main.add(scrollPanel);
		container.add(widgetList);
		widgetList.add(searchButton);
		

		scrollPanel.setScrollingEnabledX(false);
		scrollPanel.add(container);
		// workaround for android formfields jumping around when using
		// -webkit-transform
		scrollPanel.setUsePos(MGWT.getOsDetection().isAndroid());

	}
	
	@Override
	public HasText getSearchBox(){
		return searchBox;
	}
	
	@Override
	public HasTapHandlers getSearchButton(){
		return searchButton;
	}
	
	@Override
	public HasChangeHandlers getProductCategory(){
		return productCategory;
	}

	@Override
	public MListBox getProductCategoryListBox() {
		return productCategory;
	}
}
