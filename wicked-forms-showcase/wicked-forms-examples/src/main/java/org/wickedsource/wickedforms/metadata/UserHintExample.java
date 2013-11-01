package org.wickedsource.wickedforms.metadata;

import org.wickedsource.wickedforms.model.FormModel;
import org.wickedsource.wickedforms.model.SectionModel;
import org.wickedsource.wickedforms.model.elements.TextModel;
import org.wickedsource.wickedforms.model.elements.fields.TextFieldModel;

public class UserHintExample extends FormModel {

	public UserHintExample() {
		super("User Hint Examples");

		add(new SectionModel("User Hint")
		    .add(
		        new TextModel(
		            "For most input elements you can provide a user hint that by default pops" +
		                " up when you focus the field. Focus the following input field and see what" +
		                " happens. You can change the behavior of the user hint by modifying the CSS."))
		    .add(new TextFieldModel<String>("Your name", String.class)
		        .setHint("Please enter your first name only.")));

	}

}
