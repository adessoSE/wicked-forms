package de.adesso.wickedforms.advanced;

import de.adesso.wickedforms.model.Section;
import de.adesso.wickedforms.model.actions.ToggleVisibilityAction;
import de.adesso.wickedforms.model.elements.fields.Checkbox;
import de.adesso.wickedforms.model.Form;
import de.adesso.wickedforms.model.elements.Text;
import de.adesso.wickedforms.model.elements.fields.StringTextField;

public class ConditionalVisibilityExample extends Form {

	public ConditionalVisibilityExample() {
		super("Conditional Visibility of Input Fields");
		this.add(new Text("Sometimes, forms have to adapt to the user input. Wicked Forms supports "
				+ "hiding or showing certain form elements when the user enters some pre-defined value. You "
				+ "simply have to add a ToggleVisibilityAction to the input field that shall serve as trigger."));
		this.add(createVisibleCheckboxSection());
	}

	private Section createVisibleCheckboxSection() {
		
		StringTextField visibleField = new StringTextField("Your Toggle");
		visibleField.setVisible(true);
		Checkbox triggerVisibleCheckbox = new Checkbox("check to hide the Textfield below!");
		triggerVisibleCheckbox.add(new ToggleVisibilityAction<Boolean>(triggerVisibleCheckbox, Boolean.FALSE, visibleField));

		return new Section("Checkbox Visible Trigger")
				.add(new Text(
						"A checkbox can serve as trigger for toggling the visibility of another form element. Mark and unmark the checkbox to see what happens."))
				.add(triggerVisibleCheckbox).add(visibleField);
	}

}
