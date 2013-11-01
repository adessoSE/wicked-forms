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
package com.googlecode.wickedforms.wicket6.validators;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import com.googlecode.wickedforms.model.elements.fields.AbstractInputFieldModel;
import com.googlecode.wickedforms.model.validation.FieldValidatorModel;
import com.googlecode.wickedforms.model.validation.ValidationFeedback;

public class WickedFieldValidator<T> implements IValidator<T> {

	private final AbstractInputFieldModel<T> field;

	public WickedFieldValidator(final AbstractInputFieldModel<T> field) {
		this.field = field;
	}

	@Override
	public void validate(final IValidatable<T> validatable) {
		for (FieldValidatorModel<T> v : this.field.getValidators()) {
			v.validate(this.field, validatable.getValue(), new WicketValidationFeedback<T>(validatable));
		}
	}

	class WicketValidationFeedback<T> implements ValidationFeedback {

		private final IValidatable<T> validatable;

		public WicketValidationFeedback(final IValidatable<T> validatable) {
			this.validatable = validatable;
		}

		@Override
		public void error(final String message) {
			this.validatable.error(new ValidationError(message));
		}

	}

}
