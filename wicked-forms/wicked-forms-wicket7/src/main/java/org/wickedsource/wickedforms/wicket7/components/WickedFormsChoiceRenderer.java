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
package org.wickedsource.wickedforms.wicket7.components;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;
import org.wickedsource.wickedforms.model.elements.fields.ChoiceLabeller;

import java.util.List;

public class WickedFormsChoiceRenderer {

	/**
	 * Converts a Wicked Forms {@link ChoiceLabeller} into a Wicket
	 * {@link IChoiceRenderer}.
	 * 
	 * @param <T>
	 *          the type of choice
	 * @param labeller
	 *          the Wicked Forms {@link ChoiceLabeller} to convert
	 * @return a Wicket {@link IChoiceRenderer} that wraps the given
	 *         {@link ChoiceLabeller}
	 */
	public static <T> IChoiceRenderer<T> fromChoiceLabeller(final ChoiceLabeller<T> labeller) {
		return new ChoiceRenderer<T>() {

			@Override
			public Object getDisplayValue(final T object) {
				return labeller.getLabel(object);
			}

			@Override
			public String getIdValue(final T object, final int index) {
				return String.valueOf(index);
			}
        };
	}

}
