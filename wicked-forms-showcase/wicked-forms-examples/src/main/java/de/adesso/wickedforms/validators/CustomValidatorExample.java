package de.adesso.wickedforms.validators;

import de.adesso.wickedforms.model.Section;
import de.adesso.wickedforms.model.elements.fields.AbstractInputField;
import de.adesso.wickedforms.model.validation.FieldValidator;
import de.adesso.wickedforms.model.validation.ValidationFeedback;
import de.adesso.wickedforms.model.Form;
import de.adesso.wickedforms.model.elements.Text;
import de.adesso.wickedforms.model.elements.fields.StringTextField;

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
