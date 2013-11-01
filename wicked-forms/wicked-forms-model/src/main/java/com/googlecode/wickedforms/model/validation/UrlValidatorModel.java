/**
 *   Copyright 2013 Wicked Forms (http://wicked-forms.googlecode.com)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.googlecode.wickedforms.model.validation;

import com.googlecode.wickedforms.model.elements.fields.AbstractInputFieldModel;

public class UrlValidatorModel implements FieldValidatorModel<String> {

	@Override
	public void validate(final AbstractInputFieldModel<String> inputField, final String value,
	    final ValidationFeedback feedback) {
		if (!value
		    .matches("(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?")) {
			feedback.error(String.format("The value for '%s' is not a valid URL!", inputField.getLabel()));
		}

	}
}
