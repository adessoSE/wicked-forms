package org.wickedsource.wickedforms.metadata;

import org.wickedsource.wickedforms.model.FormModel;
import org.wickedsource.wickedforms.model.SectionModel;
import org.wickedsource.wickedforms.model.elements.TextModel;
import org.wickedsource.wickedforms.model.elements.fields.CheckboxModel;
import org.wickedsource.wickedforms.model.elements.fields.TextFieldModel;

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
