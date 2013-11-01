package org.wickedsource.wickedforms.validators;

import org.wickedsource.wickedforms.model.FormModel;
import org.wickedsource.wickedforms.model.elements.TextModel;
import org.wickedsource.wickedforms.model.elements.fields.StringTextFieldModel;
import org.wickedsource.wickedforms.model.validation.UrlValidatorModel;

public class UrlValidatorExample extends FormModel {

	public UrlValidatorExample() {
		super("URL Validator");

		add(
		    new TextModel(
		        "This validator checks against a regular expression" +
		            " if the input value is a valid URL including the " +
		            "protocol prefix (i.e. 'http://'). Type in an invalid URL and submit the form."))
		    .add(new StringTextFieldModel("Your web site URL")
		        .add(new UrlValidatorModel()));

	}
}
