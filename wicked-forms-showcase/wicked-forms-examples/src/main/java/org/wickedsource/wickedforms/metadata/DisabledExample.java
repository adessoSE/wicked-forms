package org.wickedsource.wickedforms.metadata;

import org.wickedsource.wickedforms.model.FormModel;
import org.wickedsource.wickedforms.model.SectionModel;
import org.wickedsource.wickedforms.model.elements.TextModel;
import org.wickedsource.wickedforms.model.elements.fields.TextFieldModel;

public class DisabledExample extends FormModel {

	public DisabledExample() {
		super("Enabled / Disabled Examples");

		add(new SectionModel("Enabled Field")
		    .add(
		        new TextModel(
		            "All fields are enabled by default."))
		    .add(new TextFieldModel<String>("Enabled Text Field", String.class)));

		add(new SectionModel("Disabled Field")
		    .add(
		        new TextModel(
		            "You can disable a field by calling setEnabled(false)."))
		    .add(new TextFieldModel<String>("Disabled Text Field", String.class)
		        .setEnabled(false)));

	}

}
