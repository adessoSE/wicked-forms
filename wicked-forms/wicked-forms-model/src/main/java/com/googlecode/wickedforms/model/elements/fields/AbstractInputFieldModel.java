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
package com.googlecode.wickedforms.model.elements.fields;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.wickedforms.model.actions.FormActionModel;
import com.googlecode.wickedforms.model.binding.Binding;
import com.googlecode.wickedforms.model.elements.AbstractBoundFieldModel;
import com.googlecode.wickedforms.model.elements.AbstractFormElementModel;
import com.googlecode.wickedforms.model.validation.FieldValidatorModel;

/**
 * Base class for all input fields that can be part of a dynamic form. All input
 * fields can display a value to a user as well as take a value as input from a
 * user.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 * @param <T>
 *            the type of the user input
 * @param <C>
 *            the type of
 */
public abstract class AbstractInputFieldModel<T> extends
		AbstractBoundFieldModel<T> {

	private String label;

	private String hint;

	private boolean required = false;

	private boolean enabled = true;

	private String requiredMessage;

	private final List<FieldValidatorModel<T>> validators = new ArrayList<FieldValidatorModel<T>>();

	private final List<FormActionModel<T>> actions = new ArrayList<FormActionModel<T>>();

	private T userInput;

	/**
	 * Constructor.
	 * 
	 * @param label
	 *            the label of the input field. This label should be displayed
	 *            next to the input field itself, so that it is clear what input
	 *            the user is expected to give.
	 */
	public AbstractInputFieldModel(final String label) {
		this.label = label;
	}

	/**
	 * Constructor with initial value.
	 * 
	 * @param the
	 *            label of the input field. This label should be displayed next
	 *            to the input field itself, so that it is clear what input the
	 *            user is expected to give.
	 * @param value
	 *            the initial value of the input field.
	 * @see AbstractFormElementModel#FormElement(Object)
	 */
	public AbstractInputFieldModel(final String label, final T value) {
		super(value);
		this.label = label;
	}

	/**
	 * Constructor with binding.
	 * 
	 * @param label
	 *            the label of the input field. This label should be displayed
	 *            next to the input field itself, so that it is clear what input
	 *            the user is expected to give.
	 * @param binding
	 *            a binding defining a link between this input field and an
	 *            arbitrary object.
	 * @see AbstractFormElementModel#FormElement(Binding)
	 */
	public AbstractInputFieldModel(final String label, final Binding<T> binding) {
		super(binding);
		this.label = label;
	}

	public AbstractInputFieldModel() {

	}

	public AbstractInputFieldModel<T> setLabel(final String label) {
		this.label = label;
		return this;
	}

	public String getLabel() {
		return this.label;
	}

	/**
	 * Adds a validator to this input field. The validators are executed when
	 * the user submits the form.
	 * 
	 * @param validator
	 *            the validator to add.
	 * @return this object for chaining
	 */
	public AbstractInputFieldModel<T> add(final FieldValidatorModel<T> validator) {
		this.getValidators().add(validator);
		return this;
	}

	public AbstractInputFieldModel<T> add(final FormActionModel<T> action) {
		this.getActions().add(action);
		return this;
	}

	/**
	 * Sets an optional hint for the input field. This hint may for example be
	 * displayed as a info to the user next to the input field or as a
	 * mouse-over popup.
	 * 
	 * @param hint
	 *            the hint of the input field.
	 * @return this object for chaining
	 */
	public AbstractInputFieldModel<T> setHint(final String hint) {
		this.hint = hint;
		return this;
	}

	public String getHint() {
		return this.hint;
	}

	/**
	 * Defines if this input field is mandatory and thus must be filled by the
	 * user.
	 * 
	 * @param required
	 *            true, if the field should be mandatory and the form cannot be
	 *            submitted without filling this input field.
	 * @return this object for chaining
	 */
	public AbstractInputFieldModel<T> setRequired(final boolean required) {
		this.required = required;
		return this;
	}

	public boolean isRequired() {
		return this.required;
	}

	/**
	 * Sets the message that is displayed to the user if he did not fill this
	 * input field although it was defined as required.
	 * 
	 * @param requiredMessage
	 *            the message to display when not filling this required input
	 *            field.
	 * @return this object for chaining
	 */
	public AbstractInputFieldModel<T> setRequiredMessage(final String requiredMessage) {
		this.requiredMessage = requiredMessage;
		return this;
	}

	public String getRequiredMessage() {
		return this.requiredMessage;
	}

	public List<FieldValidatorModel<T>> getValidators() {
		return this.validators;
	}

	/**
	 * Stores the user's input. This field is intended to be used by Wicked
	 * Forms interpreters to store the user's input BEFORE validation has
	 * occured. Validators may use this field to validate user input before the
	 * value is passed into the binding.
	 * <p/>
	 * This method should NOT be called by users of Wicked Forms but only by
	 * Wicked Forms interpreters.
	 * 
	 * @param userInput
	 *            the user's input into this field.
	 */
	public void setUserInput(final T userInput) {
		this.userInput = userInput;
	}

	/**
	 * Returns the user's input. This field is intended to be used by Wicked
	 * Forms interpreters to store the user's input BEFORE validation has
	 * occured. Validators may use this field to validate user input before the
	 * value is passed into the binding.
	 * <p/>
	 * This method should be called instead of getValue() by Validators to
	 * validate the user's input. The getValue() method may not contain the
	 * correct value in the validation phase.
	 * 
	 * @return the user's input into this field.
	 */
	public T getUserInput() {
		return this.userInput;
	}

	/**
	 * Enables or disables an input field. Disabled input fields cannot be
	 * filled out by the user.
	 * 
	 * @param enabled
	 *            true to enable, false to disable.
	 * @return this object for chaining
	 */
	public AbstractInputFieldModel<T> setEnabled(final boolean enabled) {
		this.enabled = enabled;
		return this;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public List<FormActionModel<T>> getActions() {
		return this.actions;
	}

	/**
	 * Returns the class of object this input fields takes as input.
	 * <p/>
	 * Must be overridden by sub types in order for actions to properly update
	 * the user input.
	 * 
	 * @return class of the user input into this input field.
	 */
	public Class<?> getModelClass() {
		return Object.class;
	}

}
