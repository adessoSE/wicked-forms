package org.wickedsource.wickedforms.metadata;

import org.wickedsource.wickedforms.model.Form;
import org.wickedsource.wickedforms.model.Section;
import org.wickedsource.wickedforms.model.elements.Text;
import org.wickedsource.wickedforms.model.elements.fields.TextField;

public class UserHintExample extends Form {

	public UserHintExample() {
		super("User Hint Examples");

		add(new Section("User Hint")
		    .add(
		        new Text(
		            "For most input elements you can provide a user hint that by default pops" +
		                " up when you focus the field. Focus the following input field and see what" +
		                " happens. You can change the behavior of the user hint by modifying the CSS."))
		    .add(new TextField<String>("Your name", String.class)
		        .setHint("Please enter your first name only.")));

	}

}
