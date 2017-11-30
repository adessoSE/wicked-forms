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
package de.adesso.wickedforms.model.binding;

/**
 * Simplest possible implementation of a {@link Binding}. It simply redirects
 * the interface calls to an instance variable of type T.
 * <p/>
 * Please note that this implementation defies the actual aim of the
 * {@link Binding} interface to act as a mediator between external objects and
 * form elements. It should therefore only be used as a default if no binding
 * was specified.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 * @param <T>
 *            the type of the bound object.
 */
public class SimpleBinding<T> implements Binding<T> {

	private T value;

	public SimpleBinding(T value) {
		this.value = value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return this.value;
	}

}
