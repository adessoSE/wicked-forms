package org.wickedsource.wickedforms.example;

import org.wickedsource.wickedforms.model.FormModel;
import org.wickedsource.wickedforms.model.SectionModel;
import org.wickedsource.wickedforms.model.binding.PropertyBinding;
import org.wickedsource.wickedforms.model.elements.TextModel;
import org.wickedsource.wickedforms.model.elements.fields.*;
import org.wickedsource.wickedforms.model.validation.FormValidatorModel;
import org.wickedsource.wickedforms.model.validation.ValidationFeedback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonForm extends FormModel {

	public PersonForm(final Person person) {
		super("Test Form");

		SectionModel nameSection = new SectionModel("Name");
		this.add(nameSection);

		TextModel text = new TextModel("Please enter your names below ...");
		nameSection.add(text);

		final TextFieldModel<String> firstNameField = new TextFieldModel<String>("First Name",
				new PropertyBinding<String>(person, "firstName"), String.class);
		firstNameField.setRequired(true);
		firstNameField.setHint("Your first name!");
		firstNameField.setPlaceHolder("Your first name...");
		nameSection.add(firstNameField);

		final AbstractInputFieldModel<String> lastNameField = new TextFieldModel<String>("Last Name",
				new PropertyBinding<String>(person, "lastName"), String.class);
		lastNameField.setHint("Your last name!");
		nameSection.add(lastNameField);

		SectionModel personalSection = new SectionModel("Personal data");
		this.add(personalSection);

		AbstractSingleChoiceModel<Gender> genderField = new DropDownModel<Gender>("Gender", Arrays.asList(Gender
				.values()), Gender.choiceLabeller(), new PropertyBinding<Gender>(person, "gender"), Gender.class);
		person.setGender(null);
		genderField.setRequired(true);
		genderField.setHint("Bla Blub");
		personalSection.add(genderField);

		AbstractSingleChoiceModel<Age> ageField = new DropDownModel<Age>("Age", Arrays.asList(Age.values()),
				Age.choiceLabeller(),
				new PropertyBinding<Age>(person, "age"), Age.class);
		ageField.setHint("Man or woman?");
		personalSection.add(ageField);

		AbstractSingleChoiceModel<Age> ageField2 = new RadioGroupModel<Age>("Age", Arrays.asList(Age.values()),
				Age.choiceLabeller(),
				new PropertyBinding<Age>(person, "age"), Age.class);
		ageField2.setRequired(true);
		ageField2.setHint("Bla blub");
		personalSection.add(ageField2);

		AbstractMultiChoiceModel<Age> ageField3 = new CheckboxGroupModel<Age>("Age", Arrays.asList(Age.values()),
				Age.choiceLabeller());
		personalSection.add(ageField3);

		AbstractInputFieldModel<Boolean> newsletter = new CheckboxModel("Subscribe Newsletter?");
		personalSection.add(newsletter);

		TextAreaModel area = new TextAreaModel("Your History");
		area.setPlaceHolder("Tell a little about yourself...");
		personalSection.add(area);

		this.add(new FormValidatorModel() {

			@Override
			public List<AbstractInputFieldModel<?>> getRelevantInputFields() {
				List<AbstractInputFieldModel<?>> list = new ArrayList<AbstractInputFieldModel<?>>();
				list.add(firstNameField);
				list.add(lastNameField);
				return list;
			}

			@Override
			public void validate(final ValidationFeedback feedback) {
				String firstName = firstNameField.getUserInput();
				String lastName = lastNameField.getUserInput();
				if (firstName == null && lastName == null) {
					feedback.error("First name and last name must not both be empty!");
				} else if (firstName != null && firstName.equals(lastName)) {
					feedback.error("Your first name is also your last name? That can't be right!");
				}
			}

		});

	}
}
