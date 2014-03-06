package org.globalcauseway.gcmobile.client.activities.authentication.passwordreset;

import java.util.List;

import org.globalcauseway.gcmobile.client.DetailViewGwtImpl;
import org.globalcauseway.gcmobile.client.css.AppBundle;
import org.globalcauseway.gcmobile.shared.dto.ProductCategory;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.MDateBox;
import com.googlecode.mgwt.ui.client.widget.MListBox;
import com.googlecode.mgwt.ui.client.widget.MPasswordTextBox;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarText;

/**
 * @author Pontsho Molewa
 * 
 */
public class SignupViewGwtImpl extends DetailViewGwtImpl implements SignupView {
	private Button sendPassButton;
	private MTextBox email;
	private MTextBox firstName;
	private MTextBox surname;
	private MPasswordTextBox password;
	private MPasswordTextBox passwordConfirm;
	private MListBox gender;
	
	private Button cancel ;
	FlowPanel fPanel;
	FlowPanel container = new FlowPanel();

	public SignupViewGwtImpl() {

		cancel = new Button("Cancel");
		cancel.setSmall(true);
		fPanel = new FlowPanel();
		
		gender = new MListBox();
		gender.addItem("-Select gender-");
		gender.addItem("Male");
		gender.addItem("Female");
		gender.addItem("Other");
		sendPassButton= new Button("Sign up");
		email = new MTextBox();
		email.setPlaceHolder("Email address");
		firstName = new MTextBox();
		firstName.setPlaceHolder("Your name");
		surname = new MTextBox();
		surname.setPlaceHolder("Your surname");
		password = new MPasswordTextBox();
		password.setPlaceHolder("new password");
		passwordConfirm = new MPasswordTextBox();
		passwordConfirm.setPlaceHolder("confirm password");
		
		//HTML header = new HTML("Enter you email address and we will send your password to you");
		WidgetList widgetList = new WidgetList();
		widgetList.setRound(true);
		
		widgetList.add(email);
		widgetList.add(firstName);
		widgetList.add(surname);
		widgetList.add(gender);
		widgetList.add(new MDateBox());
		widgetList.add(password);
		widgetList.add(passwordConfirm);
		//widgetList.add(header);
		container.add(widgetList);
		
		
		main.add(container);
		container.add(sendPassButton);
		
		ButtonBarText termsConditions  = new ButtonBarText("Terms + Privacy");
		container.add(termsConditions);
		    
	    termsConditions.addStyleName("buttonBarText");
	    
	    termsConditions.addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				displayTerms();
			}
		});
	}

	@Override
	public HasText getEmail() {
		return email;
	}

	@Override
	public HasTapHandlers getSendPassbutton() {
		return sendPassButton;
	}
	public void displayTerms() {
		//fPanel.getElement().setAttribute("style", "z-index: 100;background-color: white;top: 0;left: 0;right: 0;bottom: 0;position: absolute;");;
		FlowPanel content = new FlowPanel();
		HTML html = new HTML(AppBundle.INSTANCE.terms_privacy().getText());
	    html.getElement().getStyle().setFontSize(14, Unit.PX);
		content.add(html);
		//content.getElement().setAttribute("style", "bottom: 5%;position: absolute;border-top: 1px solid #030506;padding: 10px;left: 0;right: 0;background-image:-webkit-gradient(linear, 0% 0, 0% 100%, from(rgba(50, 74, 103, 0.9)), color-stop(0.02, rgba(20, 25, 35, 0.9) ), to(rgba(0, 0, 0, 0.0) ) )");
		content.add(cancel);
		
		scrollPanel.add(content);
		scrollPanel.setScrollingEnabledX(false);
		main.remove(container);
		main.add(scrollPanel);
	}
	
	public HasTapHandlers getCancel(){
		return cancel;
	}
	
	@Override
	public void cancelPopup() {
		
		//main.clear();
		scrollPanel.clear();
		main.remove(scrollPanel);
		main.add(container);
		
	}
}
