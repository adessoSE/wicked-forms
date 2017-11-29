package org.wickedsource.wickedforms.advanced;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.wickedsource.wickedforms.model.Form;
import org.wickedsource.wickedforms.model.Section;
import org.wickedsource.wickedforms.model.binding.PropertyBinding;
import org.wickedsource.wickedforms.model.elements.Text;
import org.wickedsource.wickedforms.model.elements.buttons.AddSectionButton;
import org.wickedsource.wickedforms.model.elements.fields.IntegerTextField;
import org.wickedsource.wickedforms.model.elements.fields.StringTextField;

public class AddSectionButtonExample extends Form {

	private final List<Person> persons = new ArrayList<Person>();

	public AddSectionButtonExample() {
		super("Button for Adding a Section");

		add(new Text("In some forms the user may have to be able to dynamically add " +
				"some input fields. The AddSectionButtonModel provides a way to provide " +
				"a button with which the user can add a new section (with a predefined " +
				"structure) to the form. In the example below, the data of one or many " +
				"persons can be entered by the user."));

		add(new Text("By clicking the buttons below, the form is updated via AJAX " +
				"to include a new Person section or remove an existing one."));

		add(createSection());

		add(new AddSectionButton("Add another Person") {

			@Override
			public Section createSection() {
				return AddSectionButtonExample.this.createSection();
			}
		});
	}

	private Section createSection() {
		// adding a new person to the list backing the form
		final Person person = new Person();
		persons.add(person);

		// overriding onDiscard() to clean up the above list if a section is
		// discarded (removed)
		Section section = new Section("Person") {
			@Override
			protected void onDiscard() {
				persons.remove(person);
			};
		};

		// configuring the section to add
		section.setShowRemoveButton(true)
				.add(new StringTextField("First Name", new PropertyBinding<String>(person, "firstName")))
				.add(new StringTextField("Last Name", new PropertyBinding<String>(person, "lastName")))
				.add(new IntegerTextField("Age", new PropertyBinding<Integer>(person, "age")));
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
