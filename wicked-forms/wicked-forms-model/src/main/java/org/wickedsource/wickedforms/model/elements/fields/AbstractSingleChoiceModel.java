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
package org.wickedsource.wickedforms.model.elements.fields;

import org.wickedsource.wickedforms.model.binding.Binding;

import java.util.List;

/**
 * Base class for all input fields that enable a user to select one item of a
 * list of items. A single choice element binds to a single object of type T.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 * @param <T>
 *            the type of the items the user can choose from
 */
public abstract class AbstractSingleChoiceModel<T> extends
		AbstractInputFieldModel<T> {

	protected final List<T> choices;

	private final ChoiceLabeller<T> choiceLabeller;

	private final Class<T> modelClass;

	/**
	 * Constructor defining a {@link ChoiceLabeller}.
	 * 
	 * @param label
	 *            the label of the field.
	 * @param choices
	 *            the list of items the user can choose from.
	 * @param choiceLabeller
	 *            the labeller to use when creating the text representation of
	 *            the choices.
	 */
	public AbstractSingleChoiceModel(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
			Class<T> modelClass) {
		super(label);
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
		this.modelClass = modelClass;
	}

	/**
	 * Constructor.
	 * 
	 * @param label
	 *            the label of the field.
	 * @param choices
	 *            the list of items the user can choose from.
	 * 
	 */
	public AbstractSingleChoiceModel(final String label, final List<T> choices, Class<T> modelClass) {
		super(label);
		this.choices = choices;
		this.modelClass = modelClass;
		this.choiceLabeller = new ToStringChoiceLabeller<T>();
	}

	/**
	 * Constructor with initial value.
	 * 
	 * @param label
	 *            the label of the field.
	 * @param choices
	 *            the list of items the user can choose from.
	 * @param value
	 *            the initial value of the item.
	 */
	public AbstractSingleChoiceModel(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
			final T value, Class<T> modelClass) {
		super(label, value);
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
		this.modelClass = modelClass;
	}

	/**
	 * Constructor with binding.
	 * 
	 * @param label
	 *            the label of the field.
	 * @param choices
	 *            the list of items the user can choose from.
	 * @param binding
	 *            the binding providing the link between this input field's
	 *            value and an arbitrary java object.
	 */
	public AbstractSingleChoiceModel(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
			final Binding<T> binding, Class<T> modelClass) {
		super(label, binding);
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
		this.modelClass = modelClass;
	}

	public AbstractSingleChoiceModel(final List<T> choices, final ChoiceLabeller<T> choiceLabeller, Class<T> modelClass) {
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
		this.modelClass = modelClass;
	}

	/**
	 * Retrieves the list of elements the user can choose from.
	 * 
	 * @return the list of choices.
	 */
	public List<T> getChoices() {
		return this.choices;
	}

	public ChoiceLabeller<T> getChoiceLabeller() {
		return this.choiceLabeller;
	}

	@Override
	public Class<T> getModelClass() {
		return this.modelClass;
	}

}