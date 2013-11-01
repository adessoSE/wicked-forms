package com.googlecode.wickedforms.examples.metadata;

import com.googlecode.wickedforms.model.FormModel;
import com.googlecode.wickedforms.model.SectionModel;
import com.googlecode.wickedforms.model.elements.TextModel;
import com.googlecode.wickedforms.model.elements.fields.CheckboxModel;
import com.googlecode.wickedforms.model.elements.fields.TextFieldModel;

public class LabelExample extends FormModel {

	public LabelExample() {
		super("Label Examples (this is the form label)");

		add(new SectionModel("Label on an input field")
		    .add(
		        new TextModel(
		            "Each input field in a form should have a label. Otherwise the user won't know what to input. Most form elements accept a label String in the constructor."))
		    .add(new TextFieldModel<String>("This is a text field label", String.class))
		    .add(new CheckboxModel("This is a checkbox label")));

		add(new SectionModel("This is a section label")
		    .add(
		        new TextModel(
		            "Not only input fields have labels. Each section also has a label.")));

	}

}
