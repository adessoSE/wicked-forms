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
package com.googlecode.wickedforms.model.binding;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * This implementation of the {@link Binding} interface binds a form element to
 * a specified property of a specified object. Using a {@link PropertyBinding},
 * you can for example bind the "name" attribute of a Person object to a text
 * field within a form.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 * @param <T>
 *            the type of the bound object.
 */
public class PropertyBinding<T> implements Binding<T> {

	private final Object boundObject;

	private final String property;

	/**
	 * Constructor linking the value of form element to a specified property of
	 * a specified object.
	 * 
	 * @param boundObject
	 *            the object that contains the property that is the target of
	 *            this binding. Note that the class of the object must be
	 *            public, otherwise the binding may lead to runtime exceptions
	 *            due to reflection errors.
	 * @param property
	 *            the name of the property. Note that this property must be of
	 *            type T, otherwise a runtime exception will occur. The methods
	 *            {@link #getValue()} and {@link #setValue(Object)} will access
	 *            this property via reflection. Also, this property must be
	 *            accessible through public setter and getter complying to the
	 *            Java Beans standard.
	 */
	public PropertyBinding(Object boundObject, String property) {
		this.boundObject = boundObject;
		this.property = property;

	}

	@Override
	public void setValue(T value) {
		try {
			PropertyUtils.setSimpleProperty(boundObject, property, value);
		} catch (Exception e) {
			throw new IllegalStateException(String.format(
					"Binding error! Setting property '%s' on bound object of class %s failed!", property,
					boundObject.getClass()), e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getValue() {
		try {
			return (T) PropertyUtils.getSimpleProperty(boundObject, property);
		} catch (Exception e) {
			throw new IllegalStateException(String.format(
					"Binding error! Getting property '%s' from bound object of class %s failed!", property,
					boundObject.getClass()), e);
		}
	}

}
