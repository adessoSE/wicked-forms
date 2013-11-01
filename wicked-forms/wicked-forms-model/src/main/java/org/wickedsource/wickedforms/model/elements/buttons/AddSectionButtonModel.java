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
package org.wickedsource.wickedforms.model.elements.buttons;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.wickedsource.wickedforms.model.SectionModel;
import org.wickedsource.wickedforms.model.elements.AbstractFormElementModel;

/**
 * Use this model to add a button to a form that allows to add a new section to
 * the form.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public abstract class AddSectionButtonModel extends AbstractFormElementModel {

	private String label;

	public AddSectionButtonModel(String label) {
		this.label = label;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	/**
	 * Creates the section that is to be added to the form when the button is
	 * clicked. This section will be added directly ABOVE the section the button
	 * is part of.
	 * 
	 * @return the section to be added to the form. May be null if no section is
	 *         to be added.
	 */
	public abstract SectionModel createSection();

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
