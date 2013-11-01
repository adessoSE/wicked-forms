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
package org.wickedsource.wickedforms.wicket6.components.fields;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.AbstractSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.wickedsource.wickedforms.model.SectionModel;
import org.wickedsource.wickedforms.model.elements.buttons.AddSectionButtonModel;
import org.wickedsource.wickedforms.wicket6.PanelFactory;

public class AddSectionButtonPanel extends AbstractFormElementPanel {

	public AddSectionButtonPanel(final String id,
			final AddSectionButtonModel buttonModel, PanelFactory panelFactory) {
		super(id, buttonModel);
	}

	@Override
	protected void onConfigure() {
		// The button must be added in onConfigure, because the parent FormModel
		// can only be determined after this component's hierarchy has been set.
		if (!hasBeenRendered()) {
			AbstractSubmitLink button;
			button = createAjaxButton("button",
					(AddSectionButtonModel) getWickedFormModel());
			button.setDefaultFormProcessing(false);
			button.add(new AttributeModifier("value",
					((AddSectionButtonModel) getWickedFormModel()).getLabel()));
			add(button);
		}
	}

	/**
	 * Creates a button that adds the new section without AJAX.
	 */
	// private SubmitLink createAjaxlessButton(String wicketId, final
	// AddSectionButtonModel buttonModel) {
	// SubmitLink button = new SubmitLink(wicketId) {
	// @Override
	// public void onSubmit() {
	// addNewSection(buttonModel);
	// }
	// };
	// return button;
	// }

	/**
	 * Creates a button that adds the new section via AJAX.
	 */
	private AjaxSubmitLink createAjaxButton(String wicketId,
			final AddSectionButtonModel buttonModel) {
		AjaxSubmitLink button = new AjaxSubmitLink(wicketId) {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				addNewSection(buttonModel);
				target.add(getParentSectionPanel());
			}
		};
		return button;
	}

	/**
	 * Adds the section defined by the {@link AddSectionButtonModel} to the
	 * {@link FormModel}.
	 */
	private void addNewSection(final AddSectionButtonModel buttonModel) {
		SectionModel parentSection = getParentSectionModel();
		SectionModel sectionToAdd = buttonModel.createSection();
		if (sectionToAdd != null) {
			parentSection.insertBefore(sectionToAdd, buttonModel);
		}
	}
}
