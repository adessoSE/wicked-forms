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
package org.wickedsource.wickedforms.model.validation;

/**
 * This interface defines a means to propagate messages for validation errors to
 * the actual framework that is responsible for displaying a form. This
 * interface must be implemented for each view technology that wants to support
 * Wicked Charts.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 */
public interface ValidationFeedback {

	/**
	 * This method is called when a validation of an input field fails. An
	 * implementation of this interface must forward this message to the
	 * framework responsible for displaying the validation messages on the
	 * screen.
	 * 
	 * @param message
	 *            the error message explaining what validation failed. This
	 *            message is to be displayed to the user so it should provide an
	 *            understandable explanation.
	 */
	void error(String message);

}
