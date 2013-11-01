package org.wickedsource.wickedforms.example;

import org.wickedsource.wickedforms.model.FormModel;
import org.wickedsource.wickedforms.model.SectionModel;
import org.wickedsource.wickedforms.model.elements.fields.AbstractInputFieldModel;
import org.wickedsource.wickedforms.model.elements.fields.TextFieldModel;

public class NestedSectionsForm extends FormModel {

	public NestedSectionsForm(final Person person) {
		super("Test Form");

		SectionModel section = new SectionModel("Section Level 1");
		this.add(section);

		SectionModel subSection = new SectionModel("Section Level 2");

		SectionModel subSubSection = new SectionModel("Section Level 3");

		AbstractInputFieldModel<String> textField1 = new TextFieldModel<String>("Text1", String.class);
		textField1.setHint("Test 123");
		section.add(textField1);
		section.add(new TextFieldModel<String>("Text2", String.class));
		section.add(subSection);

		subSection.add(new TextFieldModel<String>("Text3", String.class));
		subSection.add(new TextFieldModel<String>("Text4", String.class));
		subSection.add(subSubSection);

		subSubSection.add(new TextFieldModel<String>("Text5", String.class));
		subSubSection.add(new TextFieldModel<String>("Text6", String.class));

		section.add(new TextFieldModel<String>("Text7", String.class));
	}
}
