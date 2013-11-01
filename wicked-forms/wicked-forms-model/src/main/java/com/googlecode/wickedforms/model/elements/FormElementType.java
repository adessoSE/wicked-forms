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
package com.googlecode.wickedforms.model.elements;

import com.googlecode.wickedforms.model.SectionModel;
import com.googlecode.wickedforms.model.elements.buttons.AddSectionButtonModel;
import com.googlecode.wickedforms.model.elements.fields.CheckboxGroupModel;
import com.googlecode.wickedforms.model.elements.fields.CheckboxModel;
import com.googlecode.wickedforms.model.elements.fields.DropDownModel;
import com.googlecode.wickedforms.model.elements.fields.IntegerTextFieldModel;
import com.googlecode.wickedforms.model.elements.fields.RadioGroupModel;
import com.googlecode.wickedforms.model.elements.fields.StringTextFieldModel;
import com.googlecode.wickedforms.model.elements.fields.TextAreaModel;
import com.googlecode.wickedforms.model.elements.fields.TextFieldModel;

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

	TEXT(TextModel.class),

	CHECKBOX(CheckboxModel.class),

	TEXTFIELD(TextFieldModel.class),

	DROPDOWN(DropDownModel.class),

	RADIO(RadioGroupModel.class),

	CHECKBOXGROUP(CheckboxGroupModel.class),

	TEXTAREA(TextAreaModel.class),

	SECTION(SectionModel.class),

	ADDSECTIONBUTTON(AddSectionButtonModel.class),

	TEXTFIELD_STRING(StringTextFieldModel.class),

	TEXTFIELD_INTEGER(IntegerTextFieldModel.class);

	public static <T extends AbstractFormElementModel> FormElementType ofObject(AbstractFormElementModel formElement) {
		for (FormElementType elementType : FormElementType.values()) {
			if (elementType.getElementClass().isInstance(formElement)) {
				return elementType;
			}
		}
		return null;
	}

	private final Class<? extends AbstractFormElementModel> elementClass;

	private FormElementType(final Class<? extends AbstractFormElementModel> elementClass) {
		this.elementClass = elementClass;
	}

	public Class<? extends AbstractFormElementModel> getElementClass() {
		return this.elementClass;
	}

}
