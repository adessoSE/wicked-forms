package org.wickedsource.wickedforms.validators;

import org.wickedsource.wickedforms.model.Form;
import org.wickedsource.wickedforms.model.Section;
import org.wickedsource.wickedforms.model.elements.Text;
import org.wickedsource.wickedforms.model.elements.fields.IntegerTextField;
import org.wickedsource.wickedforms.model.validation.NumberRangeValidator;

public class MinMaxValidatorExample extends Form {

	public MinMaxValidatorExample() {
		super("Min / Max Validators");

		add(new Section("Minimum Validator")
		    .add(new Text("A simple validator that validates if a numeric value " +
		        "is above a certain threshold. Type in a value below 5 and " +
		        "submit the form to see what happens."))
		    .add(new IntegerTextField("At least 5")
		        .add(new NumberRangeValidator<Integer>(5, null))));

		add(new Section("Maximum Validator")
		    .add(
		        new Text(
		            "Works as the minimum validator but checks the input value " +
		                "against a maxmimum threshold. Type in a value above 5 and " +
		                "submit the form to see what happens."))
		    .add(new IntegerTextField("Less than 5")
		        .add(new NumberRangeValidator<Integer>(null, 5))));

		add(new Section("Range Validator")
		    .add(
		        new Text(
		            "Minimum and maximum thresholds can be combined. Type in a value that " +
		                "is not between 1 and 5 and " +
		                "submit the form to see what happens."))
		    .add(new IntegerTextField("Between 1 and 5")
		        .add(new NumberRangeValidator<Integer>(1, 5))));

	}
}
