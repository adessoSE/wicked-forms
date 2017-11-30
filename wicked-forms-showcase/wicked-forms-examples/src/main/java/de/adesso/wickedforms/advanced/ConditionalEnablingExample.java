package de.adesso.wickedforms.advanced;

import de.adesso.wickedforms.model.Section;
import de.adesso.wickedforms.model.actions.ToggleEnabledAction;
import de.adesso.wickedforms.model.elements.fields.Checkbox;
import de.adesso.wickedforms.model.elements.fields.IntegerTextField;
import de.adesso.wickedforms.model.elements.fields.StringTextField;
import de.adesso.wickedforms.model.Form;
import de.adesso.wickedforms.model.elements.Text;
import de.adesso.wickedforms.model.elements.fields.DropDown;

import java.util.Arrays;

public class ConditionalEnablingExample extends Form {

	public ConditionalEnablingExample() {
		super("Conditional Enabling of Input Fields");
		this.add(new Text("Sometimes, forms have to adapt to the user input. Wicked Forms supports " +
				"enabling or disabling certain form elements when the user enters some pre-defined value. You " +
				"simply have to add a ToggleEnabledAction to the input field that shall serve as trigger."));
		this.add(createCheckboxSection());
		this.add(createTextFieldSection());
		this.add(createDropDownSection());
		this.add(createMultipleTriggersSection());
	}

	private Section createCheckboxSection() {
		StringTextField nameField = new StringTextField("Your name");
		nameField.setEnabled(false);
		Checkbox triggerCheckbox = new Checkbox("Yes, I want to enter my name");
		triggerCheckbox.add(new ToggleEnabledAction<Boolean>(triggerCheckbox, Boolean.TRUE, nameField));

		return new Section("Checkbox Trigger")
				.add(new Text(
						"A checkbox can serve as trigger for enabling or disabling another form element. Mark and unmark the checkbox to see what happens."))
				.add(triggerCheckbox)
				.add(nameField);
	}

	private Section createTextFieldSection() {
		StringTextField nameField = new StringTextField("Your name");
		nameField.setEnabled(false);

		StringTextField triggerTextField = new StringTextField("Do you want to enter your name (yes/no)?");
		triggerTextField.add(new ToggleEnabledAction<String>(triggerTextField, "yes", nameField));

		return new Section("Textfield Trigger")
				.add(new Text(
						"A text field can serve as trigger for enabling or disabling another form element. Type 'yes' and 'no' to see what happens."))
				.add(triggerTextField)
				.add(nameField);
	}

	private Section createDropDownSection() {
		StringTextField nameField = new StringTextField("Your name");
		nameField.setEnabled(false);

		DropDown<YesNo> triggerDropDown = new DropDown<YesNo>("Do you want to enter your name (yes/no)?",
				Arrays.asList(YesNo.values()), YesNo.class);
		triggerDropDown.add(new ToggleEnabledAction<YesNo>(triggerDropDown, YesNo.YES, nameField));

		return new Section("Dropdown Trigger")
				.add(new Text(
						"A dropdown field backed by an enum can serve as trigger for enabling or disabling another form element."))
				.add(triggerDropDown)
				.add(nameField);
	}

	private Section createMultipleTriggersSection() {
		StringTextField nameField = new StringTextField("Your name");
		IntegerTextField ageField = new IntegerTextField("Your age");
		StringTextField hobbyField = new StringTextField("Your hobby");

		nameField.setEnabled(false);
		ageField.setEnabled(false);
		hobbyField.setEnabled(false);

		Checkbox triggerCheckbox = new Checkbox("Activate fields below");
		triggerCheckbox.add(new ToggleEnabledAction<Boolean>(triggerCheckbox, Boolean.TRUE, nameField,
				ageField, hobbyField));

		return new Section("Checkbox Trigger")
				.add(new Text(
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
