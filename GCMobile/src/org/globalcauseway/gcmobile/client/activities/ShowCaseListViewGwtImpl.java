package org.globalcauseway.gcmobile.client.activities;

import java.util.List;

import org.globalcauseway.gcmobile.client.BasicCell;
import org.globalcauseway.gcmobile.shared.dto.Product;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.junit.client.impl.JUnitHost.TestBlock;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.DefaultRequestTransport;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapStandardImpl;
import com.googlecode.gwtphonegap.client.util.PhonegapUtil;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.MPasswordTextBox;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBar;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarText;
import com.googlecode.mgwt.ui.client.widget.celllist.CellListWithHeader;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

public class ShowCaseListViewGwtImpl implements ShowCaseListView {

	private LayoutPanel main;
	private HeaderButton forwardButton;
	private HeaderPanel headerPanel;
	private CellListWithHeader<Product> cellList;
	
    Button emailLoginButton;
    ButtonBarText forgotButton ;
    ButtonBarText signupButton ;
    Button fbLoginButton;
    
    ButtonBarText test ;
    
	private MTextBox email;
	private MPasswordTextBox password;

	public ShowCaseListViewGwtImpl() {
		main = new LayoutPanel();
		
		email = new MTextBox();
		email.setPlaceHolder("Email address");
		
		password = new MPasswordTextBox();
		password.setPlaceHolder("Password");
		
		
		email.getElement().getStyle().setMarginTop(3, Unit.PX);
		email.addStyleName("textinput");
		password.addStyleName("textinput");
		
		PhoneGap phoneGap = new PhoneGapStandardImpl();
		if(phoneGap.isPhoneGapDevice()){
			//Window.alert("Device ready");
		}
		headerPanel = new HeaderPanel();

		forwardButton = new HeaderButton();
		if (MGWT.getOsDetection().isPhone()) {
			headerPanel.setRightWidget(forwardButton);
		}
		main.add(headerPanel);
		HTML topspacer = new HTML();
		topspacer.setHeight("14px");
	    main.add(topspacer);
	   
	    fbLoginButton = new Button();
	    fbLoginButton.addStyleName("fbLogin");
	    main.add(fbLoginButton);
	  
	    HTML lLabel = new HTML("Login with Email");
	    lLabel.getElement().setAttribute("style", "margin : 0 5px");
	    main.add(lLabel);
	    
	    
	    HTML form = new HTML();
	    form.setHeight("15px");
	    
	    FlowPanel container = new FlowPanel();
	    container.add(email);
	    container.add(form);
	    container.add(password);
	    
	    emailLoginButton = new Button("Login");
	    container.add(emailLoginButton);
	    emailLoginButton.getElement().getStyle().setMarginTop(20, Unit.PX);
	    
	    forgotButton = new ButtonBarText("Forgot password?");
	    //forgotButton.setWidth("273px");
	    
	    main.add(container);
	    main.add(forgotButton);
	    
	    //HTML spacer = new HTML();
	   // spacer.setHeight("50px");
	    //main.add(spacer);
	    
	    signupButton  = new ButtonBarText("Sign up for GC");
	    
	    test  = new ButtonBarText("View Slides");
	    main.add(signupButton);
	    //main.add(test);
		    
	    forgotButton.addStyleName("buttonBarText");
	    signupButton.addStyleName("buttonBarText");	    
	    
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

		cellList.getCellList().setRound(true);
		cellList.getHeader().setText("Header");

//		ScrollPanel scrollPanel = new ScrollPanel();
//		//scrollPanel.setWidget(cellList);
//		scrollPanel.setScrollingEnabledX(false);
//		scrollPanel.setUsePos(MGWT.getOsDetection().isAndroid());
//		main.add(scrollPanel);

	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public void setTitle(String text) {
		headerPanel.setCenter(text);

	}

	@Override
	public void setRightButtonText(String text) {
		forwardButton.setText(text);

	}

	@Override
	public HasTapHandlers getAboutButton() {
		return forwardButton;
	}

	@Override
	public HasCellSelectedHandler getCellSelectedHandler() {
		return cellList.getCellList();
	}

	@Override
	public void setTopics(List<Product> createTopicsList) {
		cellList.getCellList().render(createTopicsList);

	}

	@Override
	public HasText getFirstHeader() {
		return cellList.getHeader();
	}

	@Override
	public HasTapHandlers getFBloginButton() {
		return fbLoginButton;
	}
	@Override
	public HasTapHandlers getEmailLoginButton() {
		return emailLoginButton;
	}
	@Override
	public HasTapHandlers getForgotPasswordButton() {
		return forgotButton;
	}
	@Override
	public HasTapHandlers getPasswordResetButton() {
		return null;
	}
	
	@Override
	public HasTapHandlers getSignupButton() {
		return signupButton;
	}
	
	@Override
	public HasTapHandlers getTestButton() {
		return test;
	}
}
