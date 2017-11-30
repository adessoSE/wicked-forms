package de.adesso.wickedforms.formelements;

import de.adesso.wickedforms.model.Section;
import de.adesso.wickedforms.model.elements.fields.Checkbox;
import de.adesso.wickedforms.model.Form;
import de.adesso.wickedforms.model.elements.Text;

public class CheckboxExample extends Form {

	public CheckboxExample() {
		super("Checkbox Examples");

		add(new Section("Simple Checkbox")
		    .add(new Text(
		        "A simple checkbox. Wow!"))
		    .add(new Checkbox("Subscribe Newsletter?")));

		add(new Section("Selected Checkbox")
		    .add(new Text(
		        "A selected checkbox."))
		    .add(new Checkbox("Subscribe Newsletter?", true)));

		add(new Section("Disabled Checkbox")
		    .add(new Text(
		        "Most form elements support the method setEnabled() to enable or disable them. "))
		    .add(new Checkbox("Did you read the terms and conditions?")
		        .setEnabled(false)
		        .setValue(true)));

	}

}
