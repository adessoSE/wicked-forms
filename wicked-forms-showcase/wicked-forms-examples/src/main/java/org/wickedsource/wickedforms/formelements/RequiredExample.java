package org.wickedsource.wickedforms.formelements;

import org.wickedsource.wickedforms.model.FormModel;
import org.wickedsource.wickedforms.model.SectionModel;
import org.wickedsource.wickedforms.model.elements.TextModel;
import org.wickedsource.wickedforms.model.elements.fields.StringTextFieldModel;

public class RequiredExample extends FormModel {

	public RequiredExample() {
		super("Required Input Field Examples");

		add(new SectionModel("Optional Text Field")
		    .add(new TextModel("This is a field that the user does not need to fill out. This is the default behavior."))
		    .add(new StringTextFieldModel("Optional Field")));

		add(new SectionModel("Required Text Field")
		    .add(
		        new TextModel(
		            "This is a field that the user is required to fill out. Try to submit the form without entering text in this field."))
		    .add(new StringTextFieldModel("Required Field").setRequired(true)));

	}

}
