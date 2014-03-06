package org.globalcauseway.gcmobile.client.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;
import com.googlecode.mgwt.ui.client.theme.base.MGWTClientBundleBaseThemeAndroid;

public interface AppBundle extends ClientBundle, MGWTClientBundleBaseThemeAndroid {
	//This is a very nasty workaround because GWT CssResource does not support @media correctly!
	@Source("app.css")
	TextResource css();
	
	@Source("resources/Terms & Privacy.txt")
	TextResource terms_privacy();
	
	@Source("resources/About.txt")
	TextResource aboutText();
	
	@NotStrict
	@Source("resources/main.css")
	public GlobalStyles globalStyles();
 
	@Source("resources/body_bg.jpg")
	ImageResource bodybgImage();
	
	@Source("resources/header_bg.jpg")
	DataResource headerbgImage();
	
	
	@Source("resources/Globe_05.png")
	ImageResource Globe_05Image();
	
	@Source("resources/Globe_1_5.png")
	ImageResource Globe_1_5Image();
	
	@Source("resources/Globe_1.png")
	ImageResource Globe_1Image();
	
	@Source("resources/Globe_2.png")
	ImageResource Globe_2Image();
	
	@Source("resources/Globe_25.png")
	ImageResource Globe_2_5Image();
	
	@Source("resources/Globe_3.png")
	ImageResource Globe_3Image();
	
	@Source("resources/Globe_35.png")
	ImageResource Globe_3_5Image();
	
	@Source("resources/Globe_45.png")
	ImageResource Globe_4_5Image();
	
	@Source("resources/Globe_4.png")
	ImageResource Globe_4Image();
	
	@Source("resources/Globe_5.png")
	ImageResource Globe_5Image();
	
	@Source("resources/Zhai Logo_38.jpg")
	ImageResource zai_logo38();
	
	@Source("resources/Zhai Logo_44.jpg")
	ImageResource zai_logo44();
	
	@Source("resources/Default-Icon-icon.png")
	ImageResource defaut_logo();
	
	@Source("resources/theme-150.jpg")
	ImageResource themeplaceholder_250();
	
	@Source("resources/theme-240.jpg")
	ImageResource themeplaceholder_150();
	
	@Source("resources/unlock.jpg")
	ImageResource unlock();
	
	@Source("resources/0.1 what is ethical fast fashion 600 x 400.jpg")
	ImageResource slide0();
	
	@Source("resources/0.2 Definition 600 x 400.jpg")
	ImageResource slide1();
	
	@Source("resources/0.3 In our everyday lives 600 x 400.jpg")
	ImageResource slide2();
	
	@Source("resources/0.4 ethical mashup background 600 x 400.jpg")
	ImageResource slide3();
	
	@Source("resources/1.1 decisions on clothing to purchase 600 x 400.jpg")
	ImageResource slide4();
	
	@Source("resources/1.2 queue for purchase of clothing 600 x 400.jpg")
	ImageResource slide5();
	
	@Source("resources/2.0 Spending Decisions 600 x 400.jpg")
	ImageResource slide6();
	
	@Source("resources/2.1 synthetic fibre 600 x 400.jpg")
	ImageResource slide7();
	
	@Source("resources/2.2 pesticides 600 x 400.jpg")
	ImageResource slide8();
	
	@Source("resources/3.0 ethical fashion reduces global warming 600 x 400.jpg")
	ImageResource slide9();
	
	@Source("resources/3.1 Ethical fashion conserves resources 600 x 400.jpg")
	ImageResource slide10();
	
	@Source("resources/3.2 where would you want to  live (graph) 600 x 400.jpg")
	ImageResource slide11();
	
	@Source("resources/3.3 last collage its your choice 600 x 400.jpg")
	ImageResource slide12();
	
	@Source("resources/fb_login.png")
	DataResource fbImage();
	
	@Source("resources/dropdown_icon.png")
	DataResource dropdownImage();
	
	interface GlobalStyles extends CssResource{}

	public static final AppBundle INSTANCE = GWT.create(AppBundle.class);

}
