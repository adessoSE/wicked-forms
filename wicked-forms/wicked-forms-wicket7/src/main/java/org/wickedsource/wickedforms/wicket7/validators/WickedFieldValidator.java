/**
 *   Copyright 2013 Wicked Forms (https://github.com/thombergs/wicked-forms)
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
package org.wickedsource.wickedforms.wicket7.validators;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;
import org.wickedsource.wickedforms.model.elements.fields.AbstractInputField;
import org.wickedsource.wickedforms.model.validation.FieldValidator;
import org.wickedsource.wickedforms.model.validation.ValidationFeedback;

public class WickedFieldValidator<T> implements IValidator<T> {

	private final AbstractInputField<T> field;

	public WickedFieldValidator(final AbstractInputField<T> field) {
		this.field = field;
	}

	@Override
	public void validate(final IValidatable<T> validatable) {
		for (FieldValidator<T> v : this.field.getValidators()) {
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
