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
package com.googlecode.wickedforms.model.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.googlecode.wickedforms.model.elements.AbstractFormElementModel;
import com.googlecode.wickedforms.model.elements.fields.AbstractInputFieldModel;

/**
 * This action allows to enable or disable an input field depending on a user
 * input in a specified trigger input field.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 * @param <T>
 *            the type of object that the trigger input field is bound to.
 */
public class ToggleEnabledAction<T> implements FormActionModel<T> {

	private final AbstractInputFieldModel<T> triggerInputField;

	private final T enabledValue;

	private final List<AbstractInputFieldModel<?>> targetElements;

	/**
	 * Constructs a new instance.
	 * 
	 * @param triggerInputField
	 *            The input field that serves as trigger for this action. If the
	 *            user changes the value of this input field, the action is
	 *            triggered.
	 * @param enabledValue
	 *            If the user enters this value into the trigger input field,
	 *            the target input fields are enabled.
	 * @param targetInputFields
	 *            The input fields that are the target of this action.
	 */
	public ToggleEnabledAction(AbstractInputFieldModel<T> triggerInputField, T enabledValue, T disabledValue,
			List<AbstractInputFieldModel<?>> targetInputFields) {
		this.triggerInputField = triggerInputField;
		this.enabledValue = enabledValue;
		this.targetElements = targetInputFields;
	}

	/**
	 * Constructs a new instance.
	 * 
	 * @param triggerInputField
	 *            The input field that serves as trigger for this action. If the
	 *            user changes the value of this input field, the action is
	 *            triggered.
	 * @param enabledValue
	 *            If the user enters this value into the trigger input field,
	 *            the target input fields are enabled.
	 * @param disabledValue
	 *            If the user enters this value into the trigger input field,
	 *            the target input fields are disabled.
	 * @param targetInputFields
	 *            The input fields that are the target of this action.
	 */
	public ToggleEnabledAction(AbstractInputFieldModel<T> triggerInputField, T enabledValue, 
			AbstractInputFieldModel<?>... targetInputFields) {
		this.triggerInputField = triggerInputField;
		this.enabledValue = enabledValue;
		
		this.targetElements = Arrays.asList(targetInputFields);
	}

	@Override
	public List<AbstractInputFieldModel<?>> getTriggerInputFields() {
		List<AbstractInputFieldModel<?>> list = new ArrayList<AbstractInputFieldModel<?>>();
		list.add(this.triggerInputField);
		return list;
	}

	@Override
	public List<AbstractFormElementModel> execute() {
		List<AbstractFormElementModel> list = new ArrayList<AbstractFormElementModel>();
		if (this.enabledValue.equals(this.triggerInputField.getUserInput())) {
			for (AbstractInputFieldModel<?> targetElement : this.targetElements) {
				targetElement.setEnabled(true);
				list.add(targetElement);
			}
		} else {
			for (AbstractInputFieldModel<?> targetElement : this.targetElements) {
				targetElement.setEnabled(false);
				list.add(targetElement);
			}
		}
		return list;
	}
}
