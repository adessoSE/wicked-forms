package de.adesso.wickedforms.example;

import de.adesso.wickedforms.model.Form;
import de.adesso.wickedforms.model.Section;
import de.adesso.wickedforms.model.elements.fields.AbstractInputField;
import de.adesso.wickedforms.model.elements.fields.TextField;

public class NestedSectionsForm extends Form {

	public NestedSectionsForm(final Person person) {
		super("Test Form");

		Section section = new Section("Section Level 1");
		this.add(section);

		Section subSection = new Section("Section Level 2");

		Section subSubSection = new Section("Section Level 3");

		AbstractInputField<String> textField1 = new TextField<String>("Text1", String.class);
		textField1.setHint("Test 123");
		section.add(textField1);
		section.add(new TextField<String>("Text2", String.class));
		section.add(subSection);

		subSection.add(new TextField<String>("Text3", String.class));
		subSection.add(new TextField<String>("Text4", String.class));
		subSection.add(subSubSection);

		subSubSection.add(new TextField<String>("Text5", String.class));
		subSubSection.add(new TextField<String>("Text6", String.class));

		section.add(new TextField<String>("Text7", String.class));
	}
}
