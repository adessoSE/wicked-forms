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
package org.wickedsource.wickedforms.model;

import org.wickedsource.wickedforms.model.elements.AbstractFormElementModel;
import org.wickedsource.wickedforms.model.validation.FormValidatorModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the starting point for creating a dynamic form with Wicked
 * Forms. You can add one or more {@link SectionModel}s to the form, which in
 * turn contain the actual form elements.
 * <p/>
 * Wicked Forms interpreters should display the form as a HTML form that
 * captures the user's input.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public class FormModel implements Serializable {

	private final SectionModel mainSection = new SectionModel();

	private final List<FormValidatorModel> validators = new ArrayList<FormValidatorModel>();

	private final String label;

	/**
	 * Constructor.
	 * 
	 * @param label
	 *            the title of the form. This title should be displayed
	 *            prominently at the top of the form by a Wicked Forms
	 *            interpreter.
	 */
	public FormModel(final String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	/**
	 * Adds a form element to the form.
	 * 
	 * @param formElement
	 *            the form element to add.
	 * @return this object for chaining
	 */
	public FormModel add(final AbstractFormElementModel formElement) {
		getMainSection().add(formElement);
		return this;
	}

	/**
	 * Adds a form validator to the form.
	 * 
	 * @param validator
	 *            the validator to add.
	 * @return this object for chaining
	 */
	public FormModel add(final FormValidatorModel validator) {
		validators.add(validator);
		return this;
	}

	/**
	 * Retrieves the validators that have been added to the form.
	 * 
	 * @return the list of validators.
	 */
	public List<FormValidatorModel> getValidators() {
		return validators;
	}

	/**
	 * Assigns a unique ID to each form element contained in this form if it
	 * doesn't have an id yet.
	 */
	public void assignIds() {
		getMainSection().assignIds(1);
	}

	public SectionModel getMainSection() {
		return mainSection;
	}

}
