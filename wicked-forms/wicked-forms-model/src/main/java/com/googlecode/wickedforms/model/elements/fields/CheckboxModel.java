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
package com.googlecode.wickedforms.model.elements.fields;

import com.googlecode.wickedforms.model.binding.Binding;

/**
 * A checkbox that can be marked or not and thus is bound to a boolean value.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public class CheckboxModel extends AbstractInputFieldModel<Boolean> {

	/**
	 * @see AbstractInputFieldModel#InputField(String)
	 */
	public CheckboxModel(String label) {
		super(label);
	}

	/**
	 * @see AbstractInputFieldModel#InputField(String, Boolean)
	 */
	public CheckboxModel(String label, Boolean value) {
		super(label, value);
	}

	/**
	 * @see AbstractInputFieldModel#InputField(String, Binding)
	 */
	public CheckboxModel(String label, Binding<Boolean> binding) {
		super(label, binding);
	}

	public CheckboxModel() {
		super();
	}

	@Override
	public Class<?> getModelClass() {
		return Boolean.class;
	}

}
