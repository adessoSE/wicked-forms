package org.wickedsource.wickedforms.advanced;

import org.wickedsource.wickedforms.model.FormModel;
import org.wickedsource.wickedforms.model.SectionModel;
import org.wickedsource.wickedforms.model.binding.PropertyBinding;
import org.wickedsource.wickedforms.model.elements.TextModel;
import org.wickedsource.wickedforms.model.elements.buttons.AddSectionButtonModel;
import org.wickedsource.wickedforms.model.elements.fields.IntegerTextFieldModel;
import org.wickedsource.wickedforms.model.elements.fields.StringTextFieldModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddSectionButtonExample extends FormModel {

	private final List<Person> persons = new ArrayList<Person>();

	public AddSectionButtonExample() {
		super("Button for Adding a Section");

		add(new TextModel("In some forms the user may have to be able to dynamically add " +
				"some input fields. The AddSectionButtonModel provides a way to provide " +
				"a button with which the user can add a new section (with a predefined " +
				"structure) to the form. In the example below, the data of one or many " +
				"persons can be entered by the user."));

		add(new TextModel("By clicking the buttons below, the form is updated via AJAX " +
				"to include a new Person section or remove an existing one."));

		add(createSection());

		add(new AddSectionButtonModel("Add another Person") {

			@Override
			public SectionModel createSection() {
				return AddSectionButtonExample.this.createSection();
			}
		});
	}

	private SectionModel createSection() {
		// adding a new person to the list backing the form
		final Person person = new Person();
		persons.add(person);

		// overriding onDiscard() to clean up the above list if a section is
		// discarded (removed)
		SectionModel section = new SectionModel("Person") {
			@Override
			protected void onDiscard() {
				persons.remove(person);
			};
		};

		// configuring the section to add
		section.setShowRemoveButton(true)
				.add(new StringTextFieldModel("First Name", new PropertyBinding<String>(person, "firstName")))
				.add(new StringTextFieldModel("Last Name", new PropertyBinding<String>(person, "lastName")))
				.add(new IntegerTextFieldModel("Age", new PropertyBinding<Integer>(person, "age")));
		return section;
	}

	public class Person implements Serializable {

		private String firstName;

		private String lastName;

		private Integer age;

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public Integer getAge() {
			return age;
		}

	}

}
