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
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.AbstractSingleSelectChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;
import org.wickedsource.wickedforms.model.actions.FormAction;
import org.wickedsource.wickedforms.model.elements.AbstractFormElement;
import org.wickedsource.wickedforms.model.elements.fields.AbstractInputField;
import org.wickedsource.wickedforms.wicket6.validators.WickedFieldValidator;
import org.wickedsource.wickedforms.wicket6.validators.WickedRequiredValidator;

import java.util.List;

public abstract class AbstractInputFieldPanel<T> extends AbstractFormElementPanel {

	private final Label label;

	public AbstractInputFieldPanel(final String id, final AbstractInputField<T> model) {
		super(id, model);

		this.label = new Label("label", model.getLabel());
		this.add(this.label);

		Label hint = new Label("hint", model.getHint());
		this.add(hint);
		if (model.getHint() == null || "".equals(model.getHint())) {
			hint.setVisible(false);
		}
	}

	private void addRequiredIfNeccessary(final FormComponent<T> component, final AbstractInputField<T> field) {
		if (field.isRequired()) {
			WickedRequiredValidator<T> requiredValidator = new WickedRequiredValidator<T>(field);
			component.add(requiredValidator);
			component.add(new AttributeModifier("required", "true"));
		}
	}

	private void connectLabelAndInputField(final FormComponent<T> component, final Label label) {
		component.setOutputMarkupId(true);
		label.add(new AttributeModifier("for", component.getMarkupId()));
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void decorateComponent(final Component component) {
		super.decorateComponent(component);
		FormComponent formComponent = (FormComponent) component;
		AbstractInputField<T> model = (AbstractInputField<T>) this.getWickedFormModel();
		this.addRequiredIfNeccessary(formComponent, model);
		this.connectLabelAndInputField(formComponent, this.label);
		formComponent.add(new WickedFieldValidator<T>(model));
		formComponent.setEnabled(model.isEnabled());
		this.add(new ComponentFeedbackPanel("feedback", component));
		this.addActions((FormComponent) component);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void addActions(final FormComponent component) {
		AbstractInputField model = (AbstractInputField) this.getWickedFormModel();
		for (final FormAction<T> action : (List<FormAction<T>>) model.getActions()) {
			AjaxFormSubmitBehavior submitBehavior = new AjaxFormSubmitBehavior("onchange") {
				@Override
				protected void onSubmit(AjaxRequestTarget target) {
					AbstractInputFieldPanel.this.updateUserInput(this.getForm(), action.getTriggerInputFields());
					List<AbstractFormElement> changedModels = action.execute();
					AbstractInputFieldPanel.this.rerenderComponents(target, this.getForm(), changedModels);
				}
			};
			submitBehavior.setDefaultProcessing(false);
			component.add(submitBehavior);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void rerenderComponents(final AjaxRequestTarget target, Form form,
			final List<AbstractFormElement> changedModels) {
		form.visitFormComponents(new IVisitor<FormComponent<?>, Void>() {
			@Override
			public void component(FormComponent<?> component, IVisit<Void> visit) {
				String id = component.getMetaData(AbstractFormElementPanel.COMPONENT_ID_KEY);
				for (AbstractFormElement model : changedModels) {
					if (model.getId().equals(id)) {
						if (model instanceof AbstractInputField) {
							component.setEnabled(((AbstractInputField) model).isEnabled());
						}
						component.setVisible(model.isVisible());
						target.add(component);
					}
				}
			}
		});
	}

	/**
	 * Iterates through all form components within the given Wicket form and
	 * writes the value of the form component into the Wicked Forms Model.
	 * <p/>
	 * TODO: the input is converted from raw input to objects somewhat manually
	 * here, so that not all input field types are automatically supported,
	 * which is bad. There must be a better way in which to let Wicket do the
	 * dirty conversion work.
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void updateUserInput(Form form, final List<AbstractInputField<?>> sourceFieldModels) {
		form.visitFormComponents(new IVisitor<FormComponent<?>, Void>() {
			@Override
			public void component(FormComponent<?> component, IVisit<Void> visit) {
				String id = component.getMetaData(AbstractFormElementPanel.COMPONENT_ID_KEY);
				for (AbstractInputField model : sourceFieldModels) {
					if (model.getId().equals(id)) {
						IConverter<?> converter;

						if (component instanceof AbstractSingleSelectChoice) {
							List choices = ((AbstractSingleSelectChoice) component).getChoices();
							converter = new DefaultListChoiceConverter(choices);
						} else {
							converter = component.getConverter(model.getModelClass());
						}

						if (converter != null) {
							Object convertedInput = converter.convertToObject(component.getInput(),
									AbstractInputFieldPanel.this.getLocale());
							model.setUserInput(convertedInput);
						} else {
							throw new RuntimeException(
									String.format(
											"%s does not support type conversion that is necessary for supporting Wicked Forms actions!",
											model.getClass().getName()));
						}
						visit.stop();
					}
				}
			}
		});
	}
}
