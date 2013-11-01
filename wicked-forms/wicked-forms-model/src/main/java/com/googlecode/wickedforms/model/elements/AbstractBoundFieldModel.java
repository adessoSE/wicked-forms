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

import com.googlecode.wickedforms.model.binding.Binding;
import com.googlecode.wickedforms.model.binding.SimpleBinding;

/**
 * A field in a form that binds to a value of type T.
 * 
 * @author hombergs
 * 
 * @param <T>
 *          the type the value of this field binds to.
 */
public class AbstractBoundFieldModel<T> extends AbstractFormElementModel {

	private Binding<T> binding;

	/**
	 * Default constructor. No backing value is initialized, so that the form
	 * element is empty (null).
	 */
	public AbstractBoundFieldModel() {
		this.setBinding(new SimpleBinding<T>(null));
	}

	/**
	 * Constructor with initial value. If you wish to bind the value of the form
	 * element to another object, use {@link #FormElement(Binding)} instead.
	 * 
	 * @param value
	 *          the value to be displayed by the form element.
	 */
	public AbstractBoundFieldModel(final T value) {
		this.setBinding(new SimpleBinding<T>(value));
	}

	/**
	 * Constructor with binding. The given binding binds the value of this form
	 * element to an object defined by the binding. The form element displays the
	 * value of the bound object. If the user enters a value into the form
	 * element, this value will be saved in the bound object.
	 * 
	 * @param binding
	 *          the binding defining the link between this form element and
	 *          another object that serves as backing object to this form element.
	 */
	public AbstractBoundFieldModel(final Binding<T> binding) {
		this.setBinding(binding);
	}

	/**
	 * Retrieves the backing value of this form element. If a binding was
	 * specified in the constructor, the value will be loaded via that binding.
	 * 
	 * @return the current value of the form element.
	 */
	public T getValue() {
		return getBinding().getValue();
	}

	/**
	 * Sets the value of this form element. If a binding was specified in the
	 * constructor, the value will be stored into that binding.
	 * 
	 * @param value
	 *          the new value.
	 * @return this object for chaining
	 */
	public AbstractBoundFieldModel<T> setValue(final T value) {
		getBinding().setValue(value);
		return this;
	}

	public Binding<T> getBinding() {
		return this.binding;
	}

	public AbstractBoundFieldModel<T> setBinding(final Binding<T> binding) {
		this.binding = binding;
		return this;
	}

}
