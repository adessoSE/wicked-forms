package org.wickedsource.wickedforms.formelements;

import org.wickedsource.wickedforms.model.Form;
import org.wickedsource.wickedforms.model.Section;
import org.wickedsource.wickedforms.model.elements.Text;
import org.wickedsource.wickedforms.model.elements.fields.Checkbox;

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
