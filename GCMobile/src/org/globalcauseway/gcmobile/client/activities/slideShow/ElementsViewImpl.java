package org.globalcauseway.gcmobile.client.activities.slideShow;

import org.globalcauseway.gcmobile.client.DetailViewGwtImpl;
import org.globalcauseway.gcmobile.client.css.AppBundle;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.Carousel;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;

/**
 * @author Pontsho 
 * 
 */
public class ElementsViewImpl extends DetailViewGwtImpl implements ElementsView {

private Carousel carousel;
  Button close;
  public ElementsViewImpl() {
    close = new Button("Skip");
    close.setSmall(true);
    carousel = new Carousel();

	main.add(close);
	HTML html = new HTML("<div id=\"Gallery\"> <div class=\"gallery-row\"> <div class=\"gallery-item\"><a href=\"images/full/01.jpg\"><img src=\"images/thumb/01.jpg\" alt=\"Image 01\" /></a></div> <div class=\"gallery-item\"><a href=\"images/full/02.jpg\"><img src=\"images/thumb/02.jpg\" alt=\"Image 02\" /></a></div> <div class=\"gallery-item\"><a href=\"images/full/03.jpg\"><img src=\"images/thumb/03.jpg\" alt=\"Image 03\" /></a></div> </div> <div class=\"gallery-row\"> <div class=\"gallery-item\"><a href=\"images/full/04.jpg\"><img src=\"images/thumb/04.jpg\" alt=\"Image 04\" /></a></div> <div class=\"gallery-item\"><a href=\"images/full/05.jpg\"><img src=\"images/thumb/05.jpg\" alt=\"Image 05\" /></a></div> <div class=\"gallery-item\"><a href=\"images/full/06.jpg\"><img src=\"images/thumb/06.jpg\" alt=\"Image 06\" /></a></div> </div> </div>");
	
	main.add(carousel);
	
	RoundPanel flowPanel0 = new RoundPanel();
	flowPanel0.add(new Image(AppBundle.INSTANCE.slide0()));

	RoundPanel flowPanel1 = new RoundPanel();
	flowPanel1.add(new Image(AppBundle.INSTANCE.slide1()));
	RoundPanel flowPanel2 = new RoundPanel();
	flowPanel2.add(new Image(AppBundle.INSTANCE.slide2()));
	RoundPanel flowPanel3 = new RoundPanel();
	flowPanel3.add(new Image(AppBundle.INSTANCE.slide3()));
	
	RoundPanel flowPanel4 = new RoundPanel();
	flowPanel4.add(new Image(AppBundle.INSTANCE.slide4()));
	RoundPanel flowPanel5 = new RoundPanel();
	flowPanel5.add(new Image(AppBundle.INSTANCE.slide5()));
	RoundPanel flowPanel6 = new RoundPanel();
	flowPanel6.add(new Image(AppBundle.INSTANCE.slide6()));
	RoundPanel flowPanel7 = new RoundPanel();
	flowPanel7.add(new Image(AppBundle.INSTANCE.slide7()));
	RoundPanel flowPanel8 = new RoundPanel();
	flowPanel8.add(new Image(AppBundle.INSTANCE.slide8()));
	RoundPanel flowPanel9 = new RoundPanel();
	flowPanel9.add(new Image(AppBundle.INSTANCE.slide9()));
	RoundPanel flowPanel10 = new RoundPanel();
	flowPanel10.add(new Image(AppBundle.INSTANCE.slide10()));
	RoundPanel flowPanel11 = new RoundPanel();
	flowPanel11.add(new Image(AppBundle.INSTANCE.slide11()));
	RoundPanel flowPanel12 = new RoundPanel();
	flowPanel12.add(new Image(AppBundle.INSTANCE.slide12()));
	
//	flowPanel0.getElement().setAttribute("style", "position:absolute;left:20%");
//	flowPanel1.getElement().setAttribute("style", "position:absolute;left:20%");
//	flowPanel2.getElement().setAttribute("style", "position:absolute;left:20%");
//	flowPanel3.getElement().setAttribute("style", "position:absolute;left:20%");
//	flowPanel4.getElement().setAttribute("style", "position:absolute;left:20%");
//	flowPanel5.getElement().setAttribute("style", "position:absolute;left:20%");
//	flowPanel6.getElement().setAttribute("style", "position:absolute;left:20%");
//	flowPanel7.getElement().setAttribute("style", "position:absolute;left:20%");
//	flowPanel8.getElement().setAttribute("style", "position:absolute;left:20%");
//	flowPanel9.getElement().setAttribute("style", "position:absolute;left:20%");
//	carousel.add(flowPanel0);
//	carousel.add(flowPanel1);
//	carousel.add(flowPanel2);
//	carousel.add(flowPanel3);
//	carousel.add(flowPanel4);
//	carousel.add(flowPanel5);
//	carousel.add(flowPanel6);
//	carousel.add(flowPanel7);
//	carousel.add(flowPanel8);
//	carousel.add(flowPanel9);
//	carousel.add(flowPanel10);
//	carousel.add(flowPanel11);
//	carousel.add(flowPanel12);
	
  }
  
  @Override
  public HasTapHandlers getCloseButton(){
	  return close;
  }
}
