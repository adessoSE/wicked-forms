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
package com.googlecode.wickedforms.wicket6;

import org.apache.wicket.markup.html.panel.Panel;

import com.googlecode.wickedforms.model.SectionModel;
import com.googlecode.wickedforms.model.elements.AbstractFormElementModel;
import com.googlecode.wickedforms.model.elements.FormElementType;
import com.googlecode.wickedforms.model.elements.TextModel;
import com.googlecode.wickedforms.model.elements.buttons.AddSectionButtonModel;
import com.googlecode.wickedforms.model.elements.fields.CheckboxGroupModel;
import com.googlecode.wickedforms.model.elements.fields.CheckboxModel;
import com.googlecode.wickedforms.model.elements.fields.DropDownModel;
import com.googlecode.wickedforms.model.elements.fields.RadioGroupModel;
import com.googlecode.wickedforms.model.elements.fields.TextAreaModel;
import com.googlecode.wickedforms.model.elements.fields.TextFieldModel;
import com.googlecode.wickedforms.wicket6.components.fields.AddSectionButtonPanel;
import com.googlecode.wickedforms.wicket6.components.fields.CheckboxGroupPanel;
import com.googlecode.wickedforms.wicket6.components.fields.CheckboxPanel;
import com.googlecode.wickedforms.wicket6.components.fields.DropDownPanel;
import com.googlecode.wickedforms.wicket6.components.fields.RadioGroupPanel;
import com.googlecode.wickedforms.wicket6.components.fields.SectionPanel;
import com.googlecode.wickedforms.wicket6.components.fields.TextAreaPanel;
import com.googlecode.wickedforms.wicket6.components.fields.TextElementPanel;
import com.googlecode.wickedforms.wicket6.components.fields.TextFieldPanel;

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
 * 	public Panel createFormElementPanel(final String wicketId, final AbstractFormElementModel element) {
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
			final CheckboxGroupModel<T> model) {
		return new CheckboxGroupPanel<T>(wicketId, model);
	}

	private CheckboxPanel createCheckboxPanel(final String wicketId, final CheckboxModel model) {
		return new CheckboxPanel(wicketId, model);
	}

	private <T> DropDownPanel<T> createDropDownPanel(final String wicketId, final DropDownModel<T> model) {
		return new DropDownPanel<T>(wicketId, model);
	}

	@Override
	public Panel createFormElementPanel(final String wicketId, final AbstractFormElementModel element) {
		FormElementType elementType = FormElementType.ofObject(element);

		if (elementType == null) {
			throw new IllegalArgumentException("Unknown Wicked Forms element: " + elementType);
		}

		switch (elementType) {
		case CHECKBOX:
			return createCheckboxPanel(wicketId, (CheckboxModel) element);
		case TEXT:
			return createTextElementPanel(wicketId, (TextModel) element);
		case TEXTFIELD:
		case TEXTFIELD_STRING:
		case TEXTFIELD_INTEGER:
			return createTextFieldPanel(wicketId, (TextFieldModel) element);
		case DROPDOWN:
			return createDropDownPanel(wicketId, (DropDownModel) element);
		case RADIO:
			return createRadioGroupPanel(wicketId, (RadioGroupModel) element);
		case CHECKBOXGROUP:
			return createCheckboxGroupPanel(wicketId, (CheckboxGroupModel) element);
		case TEXTAREA:
			return createTextAreaPanel(wicketId, (TextAreaModel) element);
		case SECTION:
			return createSectionPanel(wicketId, (SectionModel) element);
		case ADDSECTIONBUTTON:
			return createAddSectionButtonPanel(wicketId, (AddSectionButtonModel) element);
		default:
			throw new IllegalArgumentException("Unknown Wicked Forms element: " + elementType);
		}
	}

	private Panel createAddSectionButtonPanel(String wicketId, AddSectionButtonModel element) {
		return new AddSectionButtonPanel(wicketId, element, this);
	}

	private <T> RadioGroupPanel<T> createRadioGroupPanel(final String wicketId,
			final RadioGroupModel<T> model) {
		return new RadioGroupPanel<T>(wicketId, model);
	}

	private SectionPanel createSectionPanel(final String wicketId, final SectionModel model) {
		return new SectionPanel(wicketId, model, this);
	}

	private TextAreaPanel createTextAreaPanel(final String wicketId, final TextAreaModel model) {
		return new TextAreaPanel(wicketId, model);
	}

	private TextElementPanel createTextElementPanel(final String wicketId, final TextModel model) {
		return new TextElementPanel(wicketId, model);
	}

	private <T> TextFieldPanel<T> createTextFieldPanel(final String wicketId, final TextFieldModel<T> model) {
		return new TextFieldPanel<T>(wicketId, model, model.getModelClass());
	}

}
