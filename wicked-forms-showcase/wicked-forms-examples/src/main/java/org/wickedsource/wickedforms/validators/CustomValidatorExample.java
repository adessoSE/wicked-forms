package org.wickedsource.wickedforms.validators;

import org.wickedsource.wickedforms.model.Form;
import org.wickedsource.wickedforms.model.Section;
import org.wickedsource.wickedforms.model.elements.Text;
import org.wickedsource.wickedforms.model.elements.fields.AbstractInputField;
import org.wickedsource.wickedforms.model.elements.fields.StringTextField;
import org.wickedsource.wickedforms.model.validation.FieldValidator;
import org.wickedsource.wickedforms.model.validation.ValidationFeedback;

public class CustomValidatorExample extends Form {

	public CustomValidatorExample() {
		super("Custom Validators");

		add(new Text("Wicked Forms comes with a small set of ready-made validators. " +
		    "In most projects, you need your own custom-made validators. To create a custom " +
		    " validator, all you have to do is to implement the interface FieldValidator."));

		add(new Section("Fixed Value Validator")
		    .add(
		        new Text(
		            "This custom-implemented validator checks if the input " +
		                "value exactly matches the string 'mercury'."))
		    .add(new StringTextField("Nearest planet to the sun")
		        .add(createMercuryValidator())));

	}

	private FieldValidator<String> createMercuryValidator() {
		return new FieldValidator<String>() {
			@Override
			public void validate(final AbstractInputField<String> inputField, final String value,
			    final ValidationFeedback feedback) {
				if (!"mercury".equals(value)) {
					feedback.error(String.format("Your answer to '%s' is wrong.", inputField.getLabel()));
				}
			}
		};
	}
}
