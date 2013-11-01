package org.wickedsource.wickedforms.formelements;

import org.wickedsource.wickedforms.model.FormModel;
import org.wickedsource.wickedforms.model.elements.TextModel;

public class TextExample extends FormModel {

	public TextExample() {
		super("Plain Text Example");

		add(new TextModel(
		        "Sometimes you will need to add simple plain text to a form " +
		            "to explain some input field to the user. You can do this by adding " +
		            "a TextModel like this to the form."));

		add(new TextModel(
		    "This is a second text. You will see explaining texts like these " +
		        "everywhere across the showcase."));

	}

}
