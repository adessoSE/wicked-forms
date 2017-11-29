package org.wickedsource.wickedforms.formelements;

import org.wickedsource.wickedforms.model.Form;
import org.wickedsource.wickedforms.model.Section;
import org.wickedsource.wickedforms.model.elements.Text;
import org.wickedsource.wickedforms.model.elements.fields.StringTextField;

public class RequiredExample extends Form {

	public RequiredExample() {
		super("Required Input Field Examples");

		add(new Section("Optional Text Field")
		    .add(new Text("This is a field that the user does not need to fill out. This is the default behavior."))
		    .add(new StringTextField("Optional Field")));

		add(new Section("Required Text Field")
		    .add(
		        new Text(
		            "This is a field that the user is required to fill out. Try to submit the form without entering text in this field."))
		    .add(new StringTextField("Required Field").setRequired(true)));

	}

}
