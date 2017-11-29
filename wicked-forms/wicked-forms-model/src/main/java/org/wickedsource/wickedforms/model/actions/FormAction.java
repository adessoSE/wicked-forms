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
package org.wickedsource.wickedforms.model.actions;

import org.wickedsource.wickedforms.model.Form;
import org.wickedsource.wickedforms.model.elements.AbstractFormElement;
import org.wickedsource.wickedforms.model.elements.fields.AbstractInputField;

import java.io.Serializable;
import java.util.List;

public interface FormAction<T> extends Serializable {

/**
	 * Returns a list of the input fields which act as trigger to this action.
	 * If the user changes the values in these fields, the action is triggered.
	 * The values the user entered into the returned input fields can be
	 * accessed within the {@link #execute()} method via {@link AbstractInputField#getUserInput().
	 * 
	 * @return list of the input fields that act as trigger to this action.
	 */
	List<AbstractInputField<?>> getTriggerInputFields();

	/**
	 * Executes the action. All elements returned by
	 * {@link #getTriggerInputFields()} have their user input values updated
	 * which can be accessed here via
	 * {@link AbstractInputField#getUserInput()}.
	 * <p/>
	 * Within this method, you can change the state of form elements within your
	 * {@link Form} as you wish. However, <strong>no new form elements may
	 * be added and no existing form elements may be removed</strong>! All form
	 * elements whose state has changed must be part of the result list of this
	 * method so that the interpreter knows which elements he has to re-render.
	 * 
	 * @return list of all form elements whose state has changed within this
	 *         method.
	 */
	List<AbstractFormElement> execute();

}
