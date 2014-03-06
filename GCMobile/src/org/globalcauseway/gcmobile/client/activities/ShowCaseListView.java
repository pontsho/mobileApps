package org.globalcauseway.gcmobile.client.activities;

import java.util.List;

import org.globalcauseway.gcmobile.shared.dto.Product;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;


/**
 * @author Pontsho M
 *
 */
public interface ShowCaseListView extends IsWidget {

	public void setTitle(String text);

	public void setRightButtonText(String text);

	public HasTapHandlers getAboutButton();

	public HasCellSelectedHandler getCellSelectedHandler();

	public void setTopics(List<Product> createTopicsList);

	public HasText getFirstHeader();

	HasTapHandlers getPasswordResetButton();

	HasTapHandlers getForgotPasswordButton();

	HasTapHandlers getEmailLoginButton();

	HasTapHandlers getFBloginButton();

	HasTapHandlers getSignupButton();

	HasTapHandlers getTestButton();

}
