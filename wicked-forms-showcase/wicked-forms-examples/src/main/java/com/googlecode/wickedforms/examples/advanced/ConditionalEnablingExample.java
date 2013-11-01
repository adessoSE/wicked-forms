package com.googlecode.wickedforms.examples.advanced;

import java.util.Arrays;

import com.googlecode.wickedforms.model.FormModel;
import com.googlecode.wickedforms.model.SectionModel;
import com.googlecode.wickedforms.model.actions.ToggleEnabledAction;
import com.googlecode.wickedforms.model.elements.TextModel;
import com.googlecode.wickedforms.model.elements.fields.CheckboxModel;
import com.googlecode.wickedforms.model.elements.fields.DropDownModel;
import com.googlecode.wickedforms.model.elements.fields.IntegerTextFieldModel;
import com.googlecode.wickedforms.model.elements.fields.StringTextFieldModel;

public class ConditionalEnablingExample extends FormModel {

	public ConditionalEnablingExample() {
		super("Conditional Enabling of Input Fields");
		this.add(new TextModel("Sometimes, forms have to adapt to the user input. Wicked Forms supports " +
				"enabling or disabling certain form elements when the user enters some pre-defined value. You " +
				"simply have to add a ToggleEnabledAction to the input field that shall serve as trigger."));
		this.add(createCheckboxSection());
		this.add(createTextFieldSection());
		this.add(createDropDownSection());
		this.add(createMultipleTriggersSection());
	}

	private SectionModel createCheckboxSection() {
		StringTextFieldModel nameField = new StringTextFieldModel("Your name");
		nameField.setEnabled(false);
		CheckboxModel triggerCheckbox = new CheckboxModel("Yes, I want to enter my name");
		triggerCheckbox.add(new ToggleEnabledAction<Boolean>(triggerCheckbox, Boolean.TRUE, nameField));

		return new SectionModel("Checkbox Trigger")
				.add(new TextModel(
						"A checkbox can serve as trigger for enabling or disabling another form element. Mark and unmark the checkbox to see what happens."))
				.add(triggerCheckbox)
				.add(nameField);
	}

	private SectionModel createTextFieldSection() {
		StringTextFieldModel nameField = new StringTextFieldModel("Your name");
		nameField.setEnabled(false);

		StringTextFieldModel triggerTextField = new StringTextFieldModel("Do you want to enter your name (yes/no)?");
		triggerTextField.add(new ToggleEnabledAction<String>(triggerTextField, "yes", nameField));

		return new SectionModel("Textfield Trigger")
				.add(new TextModel(
						"A text field can serve as trigger for enabling or disabling another form element. Type 'yes' and 'no' to see what happens."))
				.add(triggerTextField)
				.add(nameField);
	}

	private SectionModel createDropDownSection() {
		StringTextFieldModel nameField = new StringTextFieldModel("Your name");
		nameField.setEnabled(false);

		DropDownModel<YesNo> triggerDropDown = new DropDownModel<YesNo>("Do you want to enter your name (yes/no)?",
				Arrays.asList(YesNo.values()), YesNo.class);
		triggerDropDown.add(new ToggleEnabledAction<YesNo>(triggerDropDown, YesNo.YES, nameField));

		return new SectionModel("Dropdown Trigger")
				.add(new TextModel(
						"A dropdown field backed by an enum can serve as trigger for enabling or disabling another form element."))
				.add(triggerDropDown)
				.add(nameField);
	}

	private SectionModel createMultipleTriggersSection() {
		StringTextFieldModel nameField = new StringTextFieldModel("Your name");
		IntegerTextFieldModel ageField = new IntegerTextFieldModel("Your age");
		StringTextFieldModel hobbyField = new StringTextFieldModel("Your hobby");

		nameField.setEnabled(false);
		ageField.setEnabled(false);
		hobbyField.setEnabled(false);

		CheckboxModel triggerCheckbox = new CheckboxModel("Activate fields below");
		triggerCheckbox.add(new ToggleEnabledAction<Boolean>(triggerCheckbox, Boolean.TRUE, nameField,
				ageField, hobbyField));

		return new SectionModel("Checkbox Trigger")
				.add(new TextModel(
						"You can of course enable or disable more than one input field at once."))
				.add(triggerCheckbox)
				.add(nameField)
				.add(ageField)
				.add(hobbyField);
	}
	
	private enum YesNo {
		YES,
		NO;
	}
}
