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
package de.adesso.wickedforms.wicket6.components;

import de.adesso.wickedforms.model.validation.FormValidator;
import de.adesso.wickedforms.wicket6.PanelFactory;
import de.adesso.wickedforms.wicket6.components.fields.SectionPanel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import de.adesso.wickedforms.model.Form;
import de.adesso.wickedforms.wicket6.validators.WickedFormValidator;

public class DynamicForm extends org.apache.wicket.markup.html.form.Form {

	private final Submittable submittable;

	public DynamicForm(final String id, final IModel<Form> model, PanelFactory panelFactory,
			Submittable submittable) {
		super(id, model);
		this.submittable = submittable;
		Form form = model.getObject();
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedback") {
			@Override
			public boolean isVisible() {
				return hasError();
			}
		};

		add(feedbackPanel);
		add(new Label("formTitle", form.getLabel()));
		add(new SectionPanel("sectionPanel", form.getMainSection(), panelFactory));

		for (FormValidator formValidator : form.getValidators()) {
			add(new WickedFormValidator(formValidator, this));
		}
	}

	@Override
	protected void onSubmit() {
		this.submittable.onSubmit((Form) getModelObject());
	}

}