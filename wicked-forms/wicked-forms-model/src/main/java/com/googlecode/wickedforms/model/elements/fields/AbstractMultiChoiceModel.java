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

import java.util.List;

import com.googlecode.wickedforms.model.binding.Binding;

/**
 * Abstract base class for all input fields that allow a user to select one or
 * more items from a specified selection of items. An input field of this type
 * binds to a list of objects of type T.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 * @param <T>
 *          the type of an item that can be selected by the user.
 */
public abstract class AbstractMultiChoiceModel<T> extends
    AbstractInputFieldModel<List<T>> {

	protected final List<T> choices;

	private final ChoiceLabeller<T> choiceLabeller;

	public AbstractMultiChoiceModel(final String label, final List<T> choices) {
		super(label);
		this.choices = choices;
		this.choiceLabeller = new ToStringChoiceLabeller<T>();
	}

	/**
	 * Constructor.
	 * 
	 * @param label
	 *          the label of the input field.
	 * @param choices
	 *          the list of choices that are displayed to the user and of which
	 *          the user may select one or more.
	 */
	public AbstractMultiChoiceModel(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller) {
		super(label);
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
	}

	/**
	 * Constructor with initial value.
	 * 
	 * @param label
	 *          the label of the input field.
	 * @param choices
	 *          the list of choices that are displayed to the user and of which
	 *          the user may select one or more.
	 * @param value
	 *          the list of items that are initially selected.
	 */
	public AbstractMultiChoiceModel(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
	    final List<T> value) {
		super(label, value);
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
	}

	/**
	 * Constructor with binding.
	 * 
	 * @param label
	 *          the label of the input field.
	 * @param choices
	 *          the list of choices that are displayed to the user and of which
	 *          the user may select one or more.
	 * @param binding
	 *          the binding between this input field and an arbitrary object.
	 */
	public AbstractMultiChoiceModel(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
	    final Binding<List<T>> binding) {
		super(label, binding);
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
	}

	public AbstractMultiChoiceModel(final List<T> choices, final ChoiceLabeller<T> choiceLabeller) {
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
	}

	/**
	 * Retrieves the choices that are to be displayed to the user.
	 * 
	 * @return the list of choices.
	 */
	public List<T> getChoices() {
		return this.choices;
	}

	public ChoiceLabeller<T> getChoiceLabeller() {
		return this.choiceLabeller;
	}

}