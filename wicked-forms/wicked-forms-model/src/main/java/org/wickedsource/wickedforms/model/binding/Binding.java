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
package org.wickedsource.wickedforms.model.binding;

import java.io.Serializable;

/**
 * This interface defines a binding / a link between a {@link org.wickedsource.wickedforms.model.elements.AbstractFormElementModel} and
 * an arbitrary Java object. Form elements like input fields will then display
 * the value of the bound java object. If the user enters a value into the form
 * element, it will in turn be stored into the bound object.
 * <p/>
 * The concept of the this interface is inspired by the model concept of Apache
 * Wicket.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 * @param <T>
 *            the type of the bound object.
 */
public interface Binding<T> extends Serializable {

	void setValue(T value);

	T getValue();

}
