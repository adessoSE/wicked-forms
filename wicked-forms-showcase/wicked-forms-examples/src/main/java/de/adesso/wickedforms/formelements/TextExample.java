package de.adesso.wickedforms.formelements;

import de.adesso.wickedforms.model.Form;
import de.adesso.wickedforms.model.elements.Text;

public class TextExample extends Form {

	public TextExample() {
		super("Plain Text Example");

		add(new Text(
		        "Sometimes you will need to add simple plain text to a form " +
		            "to explain some input field to the user. You can do this by adding " +
		            "a Text like this to the form."));

		add(new Text(
		    "This is a second text. You will see explaining texts like these " +
		        "everywhere across the showcase."));

	}

}
