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
package de.adesso.wickedforms.model.elements.fields;

import de.adesso.wickedforms.model.binding.Binding;

public class IntegerTextField extends TextField<Integer> {

	public IntegerTextField() {
		super(Integer.class);
	}

	public IntegerTextField(final String label) {
		super(label, Integer.class);
	}

	public IntegerTextField(final String label, final Binding<Integer> binding) {
		super(label, binding, Integer.class);
	}

	public IntegerTextField(final String label, final Integer value) {
		super(label, value, Integer.class);
	}

	@Override
	public Class<Integer> getModelClass() {
		return Integer.class;
	}

}
