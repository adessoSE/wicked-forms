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
package org.wickedsource.wickedforms.wicket6.components.fields;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.model.PropertyModel;
import org.wickedsource.wickedforms.model.elements.fields.RadioGroup;
import org.wickedsource.wickedforms.wicket6.components.WickedFormsChoiceRenderer;

/**
 * A panel that represents a {@link RadioGroup} in a form.
 * <p/>
 * <strong>Wicket IDs needed in the markup:</strong>
 * <ul>
 * <li><strong>label</strong>: a {@link Label} that displays the label of the
 * text field.
 * <li><strong>inputField</strong>: a {@link RadioChoice} that takes the user's
 * input.
 * </ul>
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public class RadioGroupPanel<T> extends AbstractInputFieldPanel<T> {

	private final RadioChoice<T> radio;

	public RadioGroupPanel(final String id, final RadioGroup<T> model) {
		super(id, model);

		this.radio = new RadioChoice<T>("inputField", new PropertyModel<T>(model, "value"),
				model.getChoices());
		this.decorateComponent(this.radio);
		this.radio.setChoiceRenderer(WickedFormsChoiceRenderer.fromChoiceLabeller(model.getChoiceLabeller()));
		this.add(this.radio);
	}

}
