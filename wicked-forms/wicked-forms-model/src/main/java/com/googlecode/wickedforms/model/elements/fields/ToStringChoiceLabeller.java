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

/**
 * The simplest possible implementation of the {@link ChoiceLabeller} interface.
 * It simply calls the toString() method to create the label of an object.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public class ToStringChoiceLabeller<T> implements ChoiceLabeller<T> {

	@Override
	public String getLabel(final T choice) {
		return choice.toString();
	}

}
