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
package org.globalcauseway.gcmobile.client;

import org.globalcauseway.gcmobile.client.activities.AboutPlace.AboutPlaceTokenizer;
import org.globalcauseway.gcmobile.client.activities.UIPlace.UIPlaceTokenizer;
import org.globalcauseway.gcmobile.client.activities.animation.AnimationPlace.AnimationPlaceTokenizer;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationCubePlace;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationDissolvePlace.AnimationDissolvePlaceTokenizer;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationFadePlace.AnimationFadePlaceTokenizer;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationFlipPlace.AnimationFlipPlaceTokenizer;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationPopPlace.AnimationPopPlaceTokenizer;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationSlidePlace.AnimationSlidePlaceTokenizer;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationSlideUpPlace.AnimationSlideUpPlaceTokenizer;
import org.globalcauseway.gcmobile.client.activities.animationdone.AnimationSwapPlace.AnimationSwapPlaceTokenizer;
import org.globalcauseway.gcmobile.client.activities.authentication.emaillogin.EmailLoginPlace;
import org.globalcauseway.gcmobile.client.activities.authentication.passwordreset.SignupPlace.SignupPlaceTokenizer;
import org.globalcauseway.gcmobile.client.activities.authentication.signup.ForgotPasswordPlace;
import org.globalcauseway.gcmobile.client.activities.branddetails.BrandDetailsPlace;
import org.globalcauseway.gcmobile.client.activities.homepage.HomePagePlace;
import org.globalcauseway.gcmobile.client.activities.search.SearchPlace;
import org.globalcauseway.gcmobile.client.activities.searchresults.SearchResultsPlace;
import org.globalcauseway.gcmobile.client.activities.slideShow.ElementsPlace.ElementsPlaceTokenizer;
import org.globalcauseway.gcmobile.client.places.HomePlace.HomePlaceTokenizer;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * @author Daniel Kurka
 * 
 */
@WithTokenizers({HomePlaceTokenizer.class, UIPlaceTokenizer.class,  AboutPlaceTokenizer.class, HomePagePlace.HomePagePlaceTokenizer.class, AnimationDissolvePlaceTokenizer.class,
		AnimationFadePlaceTokenizer.class, AnimationFlipPlaceTokenizer.class, AnimationPlaceTokenizer.class, AnimationPopPlaceTokenizer.class, AnimationSlidePlaceTokenizer.class,
		AnimationSlideUpPlaceTokenizer.class, AnimationSwapPlaceTokenizer.class, EmailLoginPlace.Tokenizer.class, ElementsPlaceTokenizer.class, SearchPlace.Tokenizer.class, 
		 SignupPlaceTokenizer.class,  AnimationCubePlace.Tokenizer.class,
		 ForgotPasswordPlace.Tokenizer.class, SearchResultsPlace.Tokenizer.class, BrandDetailsPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
