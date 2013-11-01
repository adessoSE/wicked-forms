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
package org.wickedsource.wickedforms.wicket6.validators;

import org.apache.wicket.validation.INullAcceptingValidator;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.ValidationError;
import org.wickedsource.wickedforms.model.elements.fields.AbstractInputFieldModel;

import java.text.MessageFormat;

public class WickedRequiredValidator<T> implements INullAcceptingValidator<T> {

	private final AbstractInputFieldModel<T> field;

	public WickedRequiredValidator(AbstractInputFieldModel<T> field) {
		this.field = field;
	}

	@Override
	public void validate(IValidatable<T> validatable) {
		if (validatable.getValue() == null) {
			ValidationError error = new ValidationError(getMessage());
			validatable.error(error);
		}
	}

	private String getMessage() {
		if (field.getRequiredMessage() != null) {
			return field.getRequiredMessage();
		} else {
			return MessageFormat.format("Please fill out the required field ''{0}''.", field.getLabel());
		}
	}
}
