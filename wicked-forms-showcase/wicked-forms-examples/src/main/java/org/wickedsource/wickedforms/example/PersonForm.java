package org.wickedsource.wickedforms.example;

import org.wickedsource.wickedforms.model.Form;
import org.wickedsource.wickedforms.model.Section;
import org.wickedsource.wickedforms.model.binding.PropertyBinding;
import org.wickedsource.wickedforms.model.elements.Text;
import org.wickedsource.wickedforms.model.elements.fields.*;
import org.wickedsource.wickedforms.model.validation.FormValidator;
import org.wickedsource.wickedforms.model.validation.ValidationFeedback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonForm extends Form {

	public PersonForm(final Person person) {
		super("Test Form");

		Section nameSection = new Section("Name");
		this.add(nameSection);

		Text text = new Text("Please enter your names below ...");
		nameSection.add(text);

		final TextField<String> firstNameField = new TextField<String>("First Name",
				new PropertyBinding<String>(person, "firstName"), String.class);
		firstNameField.setRequired(true);
		firstNameField.setHint("Your first name!");
		firstNameField.setPlaceHolder("Your first name...");
		nameSection.add(firstNameField);

		final AbstractInputField<String> lastNameField = new TextField<String>("Last Name",
				new PropertyBinding<String>(person, "lastName"), String.class);
		lastNameField.setHint("Your last name!");
		nameSection.add(lastNameField);

		Section personalSection = new Section("Personal data");
		this.add(personalSection);

		AbstractSingleChoice<Gender> genderField = new DropDown<Gender>("Gender", Arrays.asList(Gender
				.values()), Gender.choiceLabeller(), new PropertyBinding<Gender>(person, "gender"), Gender.class);
		person.setGender(null);
		genderField.setRequired(true);
		genderField.setHint("Bla Blub");
		personalSection.add(genderField);

		AbstractSingleChoice<Age> ageField = new DropDown<Age>("Age", Arrays.asList(Age.values()),
				Age.choiceLabeller(),
				new PropertyBinding<Age>(person, "age"), Age.class);
		ageField.setHint("Man or woman?");
		personalSection.add(ageField);

		AbstractSingleChoice<Age> ageField2 = new RadioGroup<Age>("Age", Arrays.asList(Age.values()),
				Age.choiceLabeller(),
				new PropertyBinding<Age>(person, "age"), Age.class);
		ageField2.setRequired(true);
		ageField2.setHint("Bla blub");
		personalSection.add(ageField2);

		AbstractMultiChoice<Age> ageField3 = new CheckboxGroup<Age>("Age", Arrays.asList(Age.values()),
				Age.choiceLabeller());
		personalSection.add(ageField3);

		AbstractInputField<Boolean> newsletter = new Checkbox("Subscribe Newsletter?");
		personalSection.add(newsletter);

		TextArea area = new TextArea("Your History");
		area.setPlaceHolder("Tell a little about yourself...");
		personalSection.add(area);

		this.add(new FormValidator() {

			@Override
			public List<AbstractInputField<?>> getRelevantInputFields() {
				List<AbstractInputField<?>> list = new ArrayList<AbstractInputField<?>>();
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
