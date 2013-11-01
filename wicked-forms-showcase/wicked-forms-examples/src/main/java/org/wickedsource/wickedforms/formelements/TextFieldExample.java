package org.wickedsource.wickedforms.formelements;

import org.wickedsource.wickedforms.model.FormModel;
import org.wickedsource.wickedforms.model.SectionModel;
import org.wickedsource.wickedforms.model.elements.TextModel;
import org.wickedsource.wickedforms.model.elements.fields.TextFieldModel;

public class TextFieldExample extends FormModel {

	public TextFieldExample() {
		super("Text Field Examples");

		add(new SectionModel("Simple Text Field")
		    .add(new TextModel(
		        "The basic elements in each form are text fields. Nothing fancy."))
		    .add(new TextFieldModel<String>("Your name", String.class)));

		add(new SectionModel("Integer Text Field")
		    .add(
		        new TextModel(
		            "Some text fields require valid integer numbers as input. Try to input something else and hit the submit button."))
		    .add(new TextFieldModel<Integer>("Your age", Integer.class)));

		add(new SectionModel("Decimal Text Field")
		    .add(
		        new TextModel(
		            "Same goes for Float, BigDecimal and Double numbers. Wicked Forms takes advantage of the browser's HTML5 capabilities for client side validation, if possible."))
		    .add(new TextFieldModel<Float>("Your monthly income", Float.class)));

	}

}
