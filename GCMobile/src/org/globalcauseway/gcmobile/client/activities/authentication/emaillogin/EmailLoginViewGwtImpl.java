/*
 * Copyright 2010 Daniel Kurka
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
package org.globalcauseway.gcmobile.client.activities.authentication.emaillogin;

import org.globalcauseway.gcmobile.client.DetailViewGwtImpl;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.FormListEntry;
import com.googlecode.mgwt.ui.client.widget.MPasswordTextBox;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.WidgetList;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ActionButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ArrowDownButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ArrowLeftButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ArrowRightButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ArrowUpButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.BookmarkButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBar;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarSpacer;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarText;
import com.googlecode.mgwt.ui.client.widget.buttonbar.CameraButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ComposeButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.FastForwardButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.InfoButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.LocateButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.NewIconButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.NextSlideButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.OrganizeButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.PauseButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.PlayButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.PlusButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.PreviousSlideButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ReplyButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.RewindButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.SearchButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.StopButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.TrashButton;

public class EmailLoginViewGwtImpl extends DetailViewGwtImpl implements EmailLoginView {

	private Button loginButton;
	private MTextBox email;
	private MPasswordTextBox password;

	/**
	 * 
	 */
	public EmailLoginViewGwtImpl() {
		loginButton= new Button("Login");
		email = new MTextBox();
		email.setPlaceHolder("Email address");
		
		password = new MPasswordTextBox();
		password.setPlaceHolder("Password");
		
		FlowPanel container = new FlowPanel();

		WidgetList widgetList = new WidgetList();
		widgetList.setRound(true);
		HTML header = new HTML("Contact Data");
		widgetList.add(email);
		widgetList.add(password);
		
		container.add(widgetList);
		widgetList.add(loginButton);
		
		main.add(container);
		
	}

	@Override
	public HasText getPassword() {
		return password;
	}

	@Override
	public HasText getUserName() {
		return email;
	}

	@Override
	public HasTapHandlers getLoginbutton() {
		return loginButton;
	}

}
