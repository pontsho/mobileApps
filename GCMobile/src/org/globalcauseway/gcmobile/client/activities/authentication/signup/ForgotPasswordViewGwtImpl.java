
package org.globalcauseway.gcmobile.client.activities.authentication.signup;

import org.globalcauseway.gcmobile.client.DetailViewGwtImpl;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

public class ForgotPasswordViewGwtImpl extends DetailViewGwtImpl implements ForgotPasswordView {

	
	private Button sendPassButton;
	private MTextBox email;

	public ForgotPasswordViewGwtImpl() {

		sendPassButton= new Button("Send Password");
		sendPassButton.getElement().setId("btn-test");
		email = new MTextBox();
		email.setPlaceHolder("Email address");
		
		FlowPanel container = new FlowPanel();
		HTML header = new HTML("Enter you email address and we will send your password to you");
		WidgetList widgetList = new WidgetList();
		widgetList.setRound(true);
		
		widgetList.add(email);
		widgetList.add(header);
		container.add(widgetList);
		//widgetList.add(sendPassButton);
		
		main.add(container);
		main.add(sendPassButton);
	}

	@Override
	public HasText getEmail() {
		return email;
	}

	@Override
	public HasTapHandlers getSendPassbutton() {
		return sendPassButton;
	}

}
