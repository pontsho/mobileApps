
package org.globalcauseway.gcmobile.client.activities.authentication.passwordreset;

import org.globalcauseway.gcmobile.client.DetailView;

import com.google.gwt.user.client.ui.HasText;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;

/**
 * @author Pontsho Molewa
 * 
 */
public interface SignupView extends DetailView {

	public HasText getEmail();

	public HasTapHandlers getSendPassbutton();

	public HasTapHandlers getCancel();

	void cancelPopup();
}
