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
package de.adesso.wickedforms.wicket7.components.fields;

import de.adesso.wickedforms.model.elements.fields.TextField;
import de.adesso.wickedforms.wicket7.components.PatternAttributeModifier;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

import java.math.BigDecimal;

/**
 * A panel that represents a {@link TextField} in a form.
 * <p/>
 * <strong>Wicket IDs needed in the markup:</strong>
 * <ul>
 * <li><strong>label</strong>: a {@link Label} that displays the label of the
 * text field.
 * <li><strong>inputField</strong>: a {@link TextField} that takes the user's
 * input.
 * </ul>
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public class TextFieldPanel<T> extends AbstractInputFieldPanel<T> {

	private static final String FLOAT_PATTERN = "-?[0-9.,]+";

	private static final String INTEGER_PATTERN = "-?[0-9]+";

	private final org.apache.wicket.markup.html.form.TextField<T> textField;

	public TextFieldPanel(final String id, final TextField<T> model, final Class<T> modelClass) {
		super(id, model);

		this.textField = new org.apache.wicket.markup.html.form.TextField<T>("inputField", new PropertyModel<T>(model, "value"), modelClass);
		this.decorateComponent(this.textField);

		if (model.getPlaceHolder() != null && !"".equals(model.getPlaceHolder())) {
			this.textField.add(new AttributeModifier("placeholder", model.getPlaceHolder()));
		}

		// add "pattern" attribute
		if (model.getModelClass() == Float.class ||
				model.getModelClass() == BigDecimal.class ||
				model.getModelClass() == Double.class) {
			this.textField.add(new PatternAttributeModifier(FLOAT_PATTERN));
		} else if (model.getModelClass() == Integer.class) {
			this.textField.add(new PatternAttributeModifier(INTEGER_PATTERN));
		}

		this.add(this.textField);
	}
}
