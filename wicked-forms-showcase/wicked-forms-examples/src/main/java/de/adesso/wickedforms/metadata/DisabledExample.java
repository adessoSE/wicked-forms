package de.adesso.wickedforms.metadata;

import de.adesso.wickedforms.model.Section;
import de.adesso.wickedforms.model.Form;
import de.adesso.wickedforms.model.elements.Text;
import de.adesso.wickedforms.model.elements.fields.TextField;

public class DisabledExample extends Form {

	public DisabledExample() {
		super("Enabled / Disabled Examples");

		add(new Section("Enabled Field")
		    .add(
		        new Text(
		            "All fields are enabled by default."))
		    .add(new TextField<String>("Enabled Text Field", String.class)));

		add(new Section("Disabled Field")
		    .add(
		        new Text(
		            "You can disable a field by calling setEnabled(false)."))
		    .add(new TextField<String>("Disabled Text Field", String.class)
		        .setEnabled(false)));

	}

}
