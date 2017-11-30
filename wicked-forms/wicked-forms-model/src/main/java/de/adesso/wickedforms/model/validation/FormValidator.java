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
package de.adesso.wickedforms.model.validation;

import de.adesso.wickedforms.model.elements.AbstractBoundField;
import de.adesso.wickedforms.model.elements.fields.AbstractInputField;

import java.io.Serializable;
import java.util.List;

/**
 * A form validator implements a validation rule that validates the combined
 * input of several input fields within a form.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public interface FormValidator extends Serializable {

	/**
	 * Returns a list of the input fields that are relevant to this form
	 * validator. This list must contain all input fields whose values are
	 * validated in the {@link #validate(ValidationFeedback)} method.
	 * 
	 * @return list of the relevant input fields.
	 */
	List<AbstractInputField<?>> getRelevantInputFields();

	/**
	 * Implements the actual validation rule. Only input fields that are
	 * included in {@link #getRelevantInputFields()} may be accessed in this
	 * method.
	 * <p/>
	 * The values of the input field that are to be validated must be accessed
	 * by calling {@link AbstractInputField#getUserInput()} and
	 * <strong>NOT</strong> by {@link AbstractBoundField#getValue()}, since the
	 * real value is only updated after validation has succeeded.
	 * 
	 * @param feedback
	 *            this feedback object can be used to propagate error messages
	 *            if the validation fails. If the validation is successful, the
	 *            method can simply return and leave the feedback object alone.
	 */
	void validate(ValidationFeedback feedback);

}
