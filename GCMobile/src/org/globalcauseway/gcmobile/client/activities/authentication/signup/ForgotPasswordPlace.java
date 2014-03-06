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
package org.globalcauseway.gcmobile.client.activities.authentication.signup;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Daniel Kurka
 * 
 */
public class ForgotPasswordPlace extends Place {
	public static class Tokenizer implements PlaceTokenizer<ForgotPasswordPlace> {

		@Override
		public ForgotPasswordPlace getPlace(String token) {
			return new ForgotPasswordPlace();
		}

		@Override
		public String getToken(ForgotPasswordPlace place) {

			return "";
		}

	}
}
