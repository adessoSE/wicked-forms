package de.adesso.wickedforms.formelements;

import de.adesso.wickedforms.model.Section;
import de.adesso.wickedforms.model.elements.fields.TextField;
import de.adesso.wickedforms.model.Form;
import de.adesso.wickedforms.model.elements.Text;

public class TextFieldExample extends Form {

	public TextFieldExample() {
		super("Text Field Examples");

		add(new Section("Simple Text Field")
		    .add(new Text(
		        "The basic elements in each form are text fields. Nothing fancy."))
		    .add(new TextField<String>("Your name", String.class)));

		add(new Section("Integer Text Field")
		    .add(
		        new Text(
		            "Some text fields require valid integer numbers as input. Try to input something else and hit the submit button."))
		    .add(new TextField<Integer>("Your age", Integer.class)));

		add(new Section("Decimal Text Field")
		    .add(
		        new Text(
		            "Same goes for Float, BigDecimal and Double numbers. Wicked Forms takes advantage of the browser's HTML5 capabilities for client side validation, if possible."))
		    .add(new TextField<Float>("Your monthly income", Float.class)));

	}

}
