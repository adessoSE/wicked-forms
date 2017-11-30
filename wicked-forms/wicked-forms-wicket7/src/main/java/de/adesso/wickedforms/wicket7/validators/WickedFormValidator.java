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
package de.adesso.wickedforms.wicket7.validators;

import de.adesso.wickedforms.model.elements.fields.AbstractInputField;
import de.adesso.wickedforms.model.validation.FormValidator;
import de.adesso.wickedforms.model.validation.ValidationFeedback;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.validation.IFormValidator;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;
import de.adesso.wickedforms.wicket7.components.fields.AbstractFormElementPanel;

import java.util.ArrayList;
import java.util.List;

public class WickedFormValidator implements IFormValidator {

	private final FormValidator validatorModel;

	/**
	 * List of the Wicket form components that are relevant for this form
	 * validator.
	 */
	private List<FormComponent<?>> formComponents;

	private final Form<?> form;

	public WickedFormValidator(FormValidator validatorModel, Form<?> form) {
		this.validatorModel = validatorModel;
		this.form = form;
	}

	/**
	 * Returns the input field model attached to this validator with the given
	 * id.
	 * 
	 * @param id
	 *            the id to look for.
	 * @return the input field model with the given id, or null if no input
	 *         field model with this id is attached to this validator.
	 */
	private AbstractInputField getFieldModelWithId(String id) {
		for (AbstractInputField<?> field : validatorModel.getRelevantInputFields()) {
			if (field.getId().equals(id)) {
				return field;
			}
		}
		return null;
	}

	@Override
	public FormComponent<?>[] getDependentFormComponents() {
		updateFormComponents();
		return formComponents.toArray(new FormComponent<?>[] {});
	}

	@Override
	public void validate(Form<?> form) {
		updateFormComponents();
		validatorModel.validate(new WicketFormValidationFeedback(form));
	}

	private void updateFormComponents() {
		formComponents = new ArrayList<FormComponent<?>>();
		form.visitFormComponents(new IVisitor<FormComponent<?>, Void>() {
			@Override
			public void component(FormComponent<?> component, IVisit<Void> visit) {
				String id = component.getMetaData(AbstractFormElementPanel.COMPONENT_ID_KEY);
				AbstractInputField inputFieldModel = getFieldModelWithId(id);
				if (inputFieldModel != null) {
					formComponents.add(component);
					inputFieldModel.setUserInput(component.getConvertedInput());
				}
			}
		});
	}

	class WicketFormValidationFeedback implements ValidationFeedback {

		private final Form<?> form;

		public WicketFormValidationFeedback(Form<?> form) {
			this.form = form;
		}

		@Override
		public void error(String message) {
			this.form.error(message);
		}

	}
}
