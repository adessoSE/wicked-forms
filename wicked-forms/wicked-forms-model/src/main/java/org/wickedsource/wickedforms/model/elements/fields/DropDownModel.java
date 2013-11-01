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
 * A drop down field that enables a user to select one of a set of objects. It
 * is bound to single object of type T.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 * @param <T>
 *            the type of the items that can be selected by the drop down field.
 */
public class DropDownModel<T> extends
		AbstractSingleChoiceModel<T> {

	public DropDownModel(final String label, final List<T> choices, Class<T> modelClass) {
		super(label, choices, modelClass);
	}

	/**
	 * @see AbstractSingleChoiceModel#SingleChoice(String, List)
	 */
	public DropDownModel(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
			Class<T> modelClass) {
		super(label, choices, choiceLabeller, modelClass);
	}

	/**
	 * @see AbstractSingleChoiceModel#SingleChoice(String, List, Object)
	 */
	public DropDownModel(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
			final T selectedValue, Class<T> modelClass) {
		super(label, choices, choiceLabeller, selectedValue, modelClass);
	}

	/**
	 * @see AbstractSingleChoiceModel#SingleChoice(String, List, Binding)
	 */
	public DropDownModel(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
			final Binding<T> binding, Class<T> modelClass) {
		super(label, choices, choiceLabeller, binding, modelClass);
	}

}
