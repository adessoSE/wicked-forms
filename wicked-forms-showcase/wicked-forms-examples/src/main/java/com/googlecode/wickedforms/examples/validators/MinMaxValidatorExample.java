package com.googlecode.wickedforms.examples.validators;

import com.googlecode.wickedforms.model.FormModel;
import com.googlecode.wickedforms.model.SectionModel;
import com.googlecode.wickedforms.model.elements.TextModel;
import com.googlecode.wickedforms.model.elements.fields.IntegerTextFieldModel;
import com.googlecode.wickedforms.model.validation.NumberRangeValidatorModel;

public class MinMaxValidatorExample extends FormModel {

	public MinMaxValidatorExample() {
		super("Min / Max Validators");

		add(new SectionModel("Minimum Validator")
		    .add(new TextModel("A simple validator that validates if a numeric value " +
		        "is above a certain threshold. Type in a value below 5 and " +
		        "submit the form to see what happens."))
		    .add(new IntegerTextFieldModel("At least 5")
		        .add(new NumberRangeValidatorModel<Integer>(5, null))));

		add(new SectionModel("Maximum Validator")
		    .add(
		        new TextModel(
		            "Works as the minimum validator but checks the input value " +
		                "against a maxmimum threshold. Type in a value above 5 and " +
		                "submit the form to see what happens."))
		    .add(new IntegerTextFieldModel("Less than 5")
		        .add(new NumberRangeValidatorModel<Integer>(null, 5))));

		add(new SectionModel("Range Validator")
		    .add(
		        new TextModel(
		            "Minimum and maximum thresholds can be combined. Type in a value that " +
		                "is not between 1 and 5 and " +
		                "submit the form to see what happens."))
		    .add(new IntegerTextFieldModel("Between 1 and 5")
		        .add(new NumberRangeValidatorModel<Integer>(1, 5))));

	}
}
