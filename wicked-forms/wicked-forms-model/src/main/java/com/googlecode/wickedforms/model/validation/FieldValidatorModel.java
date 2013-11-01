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

import java.io.Serializable;

import com.googlecode.wickedforms.model.elements.fields.AbstractInputFieldModel;

/**
 * A validator implements a validation rule on a single input field.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 * @param <T>
 *          the type of the form element's value object.
 */
public interface FieldValidatorModel<T> extends Serializable {

	/**
	 * Implements the validation rule represented by this
	 * {@link FieldValidatorModel}.
	 * 
	 * @param inputField
	 *          the input field that is validated. Can for example be used to read
	 *          out the label to use in the validation message.
	 * @param value
	 *          the value of the input field that is to be validated.
	 * @param feedback
	 *          this feedback object can be used to propagate error messages if
	 *          the validation fails. If the validation is successful, the method
	 *          can simply return and leave the feedback object alone.
	 */
	void validate(final AbstractInputFieldModel<T> inputField, final T value, final ValidationFeedback feedback);

}
