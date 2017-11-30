package de.adesso.wickedforms.validators;

import de.adesso.wickedforms.model.validation.UrlValidator;
import de.adesso.wickedforms.model.Form;
import de.adesso.wickedforms.model.elements.Text;
import de.adesso.wickedforms.model.elements.fields.StringTextField;

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
