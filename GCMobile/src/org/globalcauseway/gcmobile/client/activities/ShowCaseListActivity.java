/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.globalcauseway.gcmobile.client.activities;

import java.util.ArrayList;
import java.util.List;

import org.globalcauseway.gcmobile.client.ClientFactory;
import org.globalcauseway.gcmobile.client.activities.animation.AnimationPlace;
import org.globalcauseway.gcmobile.client.activities.authentication.passwordreset.SignupPlace;
import org.globalcauseway.gcmobile.client.activities.authentication.signup.ForgotPasswordPlace;
import org.globalcauseway.gcmobile.client.activities.homepage.HomePagePlace;
import org.globalcauseway.gcmobile.client.activities.slideShow.ElementsPlace;
import org.globalcauseway.gcmobile.shared.dto.Product;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

/**
 * @author Daniel Kurka
 * 
 */
public class ShowCaseListActivity extends MGWTAbstractActivity {

  private final ClientFactory clientFactory;

  public ShowCaseListActivity(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;

  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    ShowCaseListView view = clientFactory.getHomeView();

    view.setTitle("Good Cents");
    view.setRightButtonText("about");

    //view.getFirstHeader().setText("Showcase");

    view.setTopics(createTopicsList());

    addHandlerRegistration(view.getCellSelectedHandler().addCellSelectedHandler(
        new CellSelectedHandler() {

          @Override
          public void onCellSelected(CellSelectedEvent event) {
            int index = event.getIndex();
            if (index == 0) {
              clientFactory.getPlaceController().goTo(new AnimationPlace());
              return;
            }
            if (index == 1) {
              clientFactory.getPlaceController().goTo(new UIPlace());

              return;
            }

          }
        }));

    addHandlerRegistration(view.getAboutButton().addTapHandler(new TapHandler() {

      @Override
      public void onTap(TapEvent event) {
        clientFactory.getPlaceController().goTo(new AboutPlace());

      }
    }));
    
    addHandlerRegistration(view.getFBloginButton().addTapHandler(new TapHandler() {

        @Override
        public void onTap(TapEvent event) {
          clientFactory.getPlaceController().goTo(new ElementsPlace());

        }
      }));
    
    addHandlerRegistration(view.getEmailLoginButton().addTapHandler(new TapHandler() {

        @Override
        public void onTap(TapEvent event) {
          clientFactory.getPlaceController().goTo(new HomePagePlace());

        }
      }));
    
    addHandlerRegistration(view.getForgotPasswordButton().addTapHandler(new TapHandler() {

        @Override
        public void onTap(TapEvent event) {
          clientFactory.getPlaceController().goTo(new ForgotPasswordPlace());

        }
      }));
    
    addHandlerRegistration(view.getSignupButton().addTapHandler(new TapHandler() {

        @Override
        public void onTap(TapEvent event) {
          clientFactory.getPlaceController().goTo(new SignupPlace());

        }
      }));
    
    addHandlerRegistration(view.getTestButton().addTapHandler(new TapHandler() {

        @Override
        public void onTap(TapEvent event) {
          clientFactory.getPlaceController().goTo(new ElementsPlace());

        }
      }));

    panel.setWidget(view);
  }

  private List<Product> createTopicsList() {
    ArrayList<Product> list = new ArrayList<Product>();
    list.add(new Product("Animations", 5));
    list.add(new Product("UI", 5));

    return list;
  }

}
