package org.wickedsource.wickedforms.validators;

import org.wickedsource.wickedforms.model.Form;
import org.wickedsource.wickedforms.model.elements.Text;
import org.wickedsource.wickedforms.model.elements.fields.StringTextField;
import org.wickedsource.wickedforms.model.validation.UrlValidator;

public class UrlValidatorExample extends Form {

	public UrlValidatorExample() {
		super("URL Validator");

		add(
		    new Text(
		        "This validator checks against a regular expression" +
		            " if the input value is a valid URL including the " +
		            "protocol prefix (i.e. 'http://'). Type in an invalid URL and submit the form."))
		    .add(new StringTextField("Your web site URL")
		        .add(new UrlValidator()));

	}
}
