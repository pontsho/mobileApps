
package org.globalcauseway.gcmobile.client.activities;

import org.globalcauseway.gcmobile.client.DetailViewGwtImpl;
import org.globalcauseway.gcmobile.client.css.AppBundle;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Text;
import com.google.gwt.user.client.ui.HTML;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;

public class AboutViewGwtImpl extends DetailViewGwtImpl implements AboutView {

  private RoundPanel round;
  private Button button;

  public AboutViewGwtImpl() {

    round = new RoundPanel();

    round.add(new HTML("Global Causeways"));
   
    if (MGWT.getOsDetection().isPhone()) {
      button = new Button("back");
      button.getElement().setAttribute("style", "margin:auto;width: 200px;display:block");
      round.add(button);
      headerBackButton.removeFromParent();
    }
    //AppBundle.INSTANCE.terms_privacy().getText();
    HTML html = new HTML(AppBundle.INSTANCE.aboutText().getText());
    html.getElement().getStyle().setFontSize(14, Unit.PX);
    scrollPanel.setWidget(html);
    scrollPanel.setScrollingEnabledX(false);
    main.add(scrollPanel);
  }

  @Override
  public HasTapHandlers getBackbutton() {
    if (MGWT.getOsDetection().isPhone()) {
      return button;
    }
    return super.getBackbutton();
  }

}
