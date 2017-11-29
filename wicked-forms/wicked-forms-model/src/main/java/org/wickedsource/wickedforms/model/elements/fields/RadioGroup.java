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
 * A group of radio buttons of which the user may select exactly one. A radio
 * group is bound to a single object of type T.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 * @param <T>
 *            type of the objects that the user may select from.
 */
public class RadioGroup<T> extends
    AbstractSingleChoice<T> {

	public RadioGroup(final String label, final List<T> choices, Class<T> modelClass) {
		super(label, choices, modelClass);
	}

	public RadioGroup(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
			Class<T> modelClass) {
		super(label, choices, choiceLabeller, modelClass);
	}

	public RadioGroup(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
			final T selectedValue, Class<T> modelClass) {
		super(label, choices, choiceLabeller, selectedValue, modelClass);
	}

	public RadioGroup(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
			final Binding<T> binding, Class<T> modelClass) {
		super(label, choices, choiceLabeller, binding, modelClass);
	}

	public RadioGroup(final List<T> choices, final ChoiceLabeller<T> choiceLabeller, Class<T> modelClass) {
		super(choices, choiceLabeller, modelClass);
	}

}
