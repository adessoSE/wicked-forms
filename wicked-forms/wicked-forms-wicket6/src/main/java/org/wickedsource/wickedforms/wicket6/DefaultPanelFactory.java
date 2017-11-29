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
package org.wickedsource.wickedforms.wicket6;

import org.apache.wicket.markup.html.panel.Panel;
import org.wickedsource.wickedforms.model.Section;
import org.wickedsource.wickedforms.model.elements.AbstractFormElement;
import org.wickedsource.wickedforms.model.elements.FormElementType;
import org.wickedsource.wickedforms.model.elements.Text;
import org.wickedsource.wickedforms.model.elements.buttons.AddSectionButton;
import org.wickedsource.wickedforms.model.elements.fields.*;
import org.wickedsource.wickedforms.wicket6.components.fields.*;

/**
 * Default implementation of {@link PanelFactory}. This factory creates the
 * matching {@link Panel}s for each of the form element models that ship with
 * Wicked Forms.
 * <p/>
 * You can extend this factory to add your own custom form elements like this:
 * 
 * <pre>
 * public class MyPanelFactory extends DefaultPanelFactory {
 * 
 * 	public Panel createFormElementPanel(final String wicketId, final AbstractFormElement element) {
 * 		if (element instanceof MyVeryOwnFormElement) {
 * 			// if the element is an instance of one of your custom
 * 			// form elements, handle the Panel creation yourself
 * 			return new MyVeryOwnFormElementPanel(wicketId, (MyVeryOwnFormElement) element);
 * 		}
 * 
 * 		// if the element is not an instance of one of your custom
 * 		// form elements, let the DefaultPanelFactory handle it
 * 		return super.createFormElementPanel(wicketId, element);
 * 	}
 * 
 * }
 * </pre>
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public class DefaultPanelFactory implements PanelFactory {

	private <T> CheckboxGroupPanel<T> createCheckboxGroupPanel(final String wicketId,
			final CheckboxGroup<T> model) {
		return new CheckboxGroupPanel<T>(wicketId, model);
	}

	private CheckboxPanel createCheckboxPanel(final String wicketId, final Checkbox model) {
		return new CheckboxPanel(wicketId, model);
	}

	private <T> DropDownPanel<T> createDropDownPanel(final String wicketId, final DropDown<T> model) {
		return new DropDownPanel<T>(wicketId, model);
	}

	@Override
	public Panel createFormElementPanel(final String wicketId, final AbstractFormElement element) {
		FormElementType elementType = FormElementType.ofObject(element);

		if (elementType == null) {
			throw new IllegalArgumentException("Unknown Wicked Forms element: " + elementType);
		}

		switch (elementType) {
		case CHECKBOX:
			return createCheckboxPanel(wicketId, (Checkbox) element);
		case TEXT:
			return createTextElementPanel(wicketId, (Text) element);
		case TEXTFIELD:
		case TEXTFIELD_STRING:
		case TEXTFIELD_INTEGER:
			return createTextFieldPanel(wicketId, (TextField) element);
		case DROPDOWN:
			return createDropDownPanel(wicketId, (DropDown) element);
		case RADIO:
			return createRadioGroupPanel(wicketId, (RadioGroup) element);
		case CHECKBOXGROUP:
			return createCheckboxGroupPanel(wicketId, (CheckboxGroup) element);
		case TEXTAREA:
			return createTextAreaPanel(wicketId, (TextArea) element);
		case SECTION:
			return createSectionPanel(wicketId, (Section) element);
		case ADDSECTIONBUTTON:
			return createAddSectionButtonPanel(wicketId, (AddSectionButton) element);
		default:
			throw new IllegalArgumentException("Unknown Wicked Forms element: " + elementType);
		}
	}

	private Panel createAddSectionButtonPanel(String wicketId, AddSectionButton element) {
		return new AddSectionButtonPanel(wicketId, element, this);
	}

	private <T> RadioGroupPanel<T> createRadioGroupPanel(final String wicketId,
			final RadioGroup<T> model) {
		return new RadioGroupPanel<T>(wicketId, model);
	}

	private SectionPanel createSectionPanel(final String wicketId, final Section model) {
		return new SectionPanel(wicketId, model, this);
	}

	private TextAreaPanel createTextAreaPanel(final String wicketId, final TextArea model) {
		return new TextAreaPanel(wicketId, model);
	}

	private TextElementPanel createTextElementPanel(final String wicketId, final Text model) {
		return new TextElementPanel(wicketId, model);
	}

	private <T> TextFieldPanel<T> createTextFieldPanel(final String wicketId, final TextField<T> model) {
		return new TextFieldPanel<T>(wicketId, model, model.getModelClass());
	}

}
