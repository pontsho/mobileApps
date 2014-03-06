
package org.globalcauseway.gcmobile.client.activities.authentication.signup;

import org.globalcauseway.gcmobile.client.DetailView;

import com.google.gwt.user.client.ui.HasText;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;

public interface ForgotPasswordView extends DetailView {

	public HasText getEmail();

	public HasTapHandlers getSendPassbutton();

}
