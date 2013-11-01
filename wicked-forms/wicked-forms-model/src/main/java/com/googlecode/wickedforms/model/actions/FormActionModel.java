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
package com.googlecode.wickedforms.model.actions;

import java.io.Serializable;
import java.util.List;

import com.googlecode.wickedforms.model.FormModel;
import com.googlecode.wickedforms.model.elements.AbstractFormElementModel;
import com.googlecode.wickedforms.model.elements.fields.AbstractInputFieldModel;

public interface FormActionModel<T> extends Serializable {

/**
	 * Returns a list of the input fields which act as trigger to this action.
	 * If the user changes the values in these fields, the action is triggered.
	 * The values the user entered into the returned input fields can be
	 * accessed within the {@link #execute()} method via {@link AbstractInputFieldModel#getUserInput().
	 * 
	 * @return list of the input fields that act as trigger to this action.
	 */
	List<AbstractInputFieldModel<?>> getTriggerInputFields();

	/**
	 * Executes the action. All elements returned by
	 * {@link #getTriggerInputFields()} have their user input values updated
	 * which can be accessed here via
	 * {@link AbstractInputFieldModel#getUserInput()}.
	 * <p/>
	 * Within this method, you can change the state of form elements within your
	 * {@link FormModel} as you wish. However, <strong>no new form elements may
	 * be added and no existing form elements may be removed</strong>! All form
	 * elements whose state has changed must be part of the result list of this
	 * method so that the interpreter knows which elements he has to re-render.
	 * 
	 * @return list of all form elements whose state has changed within this
	 *         method.
	 */
	List<AbstractFormElementModel> execute();

}
