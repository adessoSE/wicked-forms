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
package de.adesso.wickedforms.model.elements;

import de.adesso.wickedforms.model.Section;
import de.adesso.wickedforms.model.elements.buttons.AddSectionButton;
import de.adesso.wickedforms.model.elements.fields.Checkbox;
import de.adesso.wickedforms.model.elements.fields.CheckboxGroup;
import de.adesso.wickedforms.model.elements.fields.DropDown;
import de.adesso.wickedforms.model.elements.fields.IntegerTextField;
import de.adesso.wickedforms.model.elements.fields.RadioGroup;
import de.adesso.wickedforms.model.elements.fields.StringTextField;
import de.adesso.wickedforms.model.elements.fields.TextArea;
import de.adesso.wickedforms.model.elements.fields.TextField;

/**
 * Enumeration to map the different Wicked Forms models to an enumeration
 * constant each.
 * <p/>
 * By calling {@link #forClass(Class)}, this enumeration can be used to avoid
 * ugly instanceof comparisons.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public enum FormElementType {

	TEXT(Text.class),

	CHECKBOX(Checkbox.class),

	TEXTFIELD(TextField.class),

	DROPDOWN(DropDown.class),

	RADIO(RadioGroup.class),

	CHECKBOXGROUP(CheckboxGroup.class),

	TEXTAREA(TextArea.class),

	SECTION(Section.class),

	ADDSECTIONBUTTON(AddSectionButton.class),

	TEXTFIELD_STRING(StringTextField.class),

	TEXTFIELD_INTEGER(IntegerTextField.class);

	public static <T extends AbstractFormElement> FormElementType ofObject(AbstractFormElement formElement) {
		for (FormElementType elementType : FormElementType.values()) {
			if (elementType.getElementClass().isInstance(formElement)) {
				return elementType;
			}
		}
		return null;
	}

	private final Class<? extends AbstractFormElement> elementClass;

	private FormElementType(final Class<? extends AbstractFormElement> elementClass) {
		this.elementClass = elementClass;
	}

	public Class<? extends AbstractFormElement> getElementClass() {
		return this.elementClass;
	}

}
