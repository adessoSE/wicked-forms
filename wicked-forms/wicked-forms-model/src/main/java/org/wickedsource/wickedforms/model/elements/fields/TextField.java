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
package org.wickedsource.wickedforms.model.elements.fields;

import org.wickedsource.wickedforms.model.binding.Binding;

/**
 * A text field that may contain a string, a number or any other type that can
 * be represented as a string. A text field binds to a single object of type T.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 * @param <T>
 *            the type of object the text field binds to.
 */
public class TextField<T> extends AbstractInputField<T> {

	private String placeholder;

	private final Class<T> modelClass;

	public TextField(final Class<T> modelClass) {
		super();
		this.modelClass = modelClass;
	}

	public TextField(final String label, final Binding<T> binding, final Class<T> modelClass) {
		super(label, binding);
		this.modelClass = modelClass;
	}

	/**
	 * @param modelClass
	 *            the class of the object this text field takes as input
	 */
	public TextField(final String label, final Class<T> modelClass) {
		super(label);
		this.modelClass = modelClass;
	}

	public TextField(final String label, final T value, final Class<T> modelClass) {
		super(label, value);
		this.modelClass = modelClass;
	}

	public String getPlaceHolder() {
		return this.placeholder;
	}

	/**
	 * Sets the placeholder value that is initially displayed in the input field
	 * (if no value is set yet).
	 * 
	 * @param placeHolder
	 *            the placeholder to show initially.
	 */
	public void setPlaceHolder(final String placeHolder) {
		this.placeholder = placeHolder;
	}

	@Override
	public Class<T> getModelClass() {
		return this.modelClass;
	};
}
