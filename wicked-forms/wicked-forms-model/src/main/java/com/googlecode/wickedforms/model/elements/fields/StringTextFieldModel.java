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

public class StringTextFieldModel extends TextFieldModel<String> {

	public StringTextFieldModel() {
		super(String.class);
	}

	public StringTextFieldModel(final String label) {
		super(label, String.class);
	}

	public StringTextFieldModel(final String label, final Binding<String> binding) {
		super(label, binding, String.class);
	}

	public StringTextFieldModel(final String label, final String value) {
		super(label, value, String.class);
	}

	@Override
	public Class<String> getModelClass() {
		return String.class;
	}

}
