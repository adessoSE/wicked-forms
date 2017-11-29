package org.wickedsource.wickedforms.formelements;

import org.wickedsource.wickedforms.model.Form;
import org.wickedsource.wickedforms.model.Section;
import org.wickedsource.wickedforms.model.elements.Text;
import org.wickedsource.wickedforms.model.elements.fields.ChoiceLabeller;
import org.wickedsource.wickedforms.model.elements.fields.DropDown;

import java.util.Arrays;

public class DropDownExample extends Form {

	public DropDownExample() {
		super("Drop Down List Examples");

		this.add(new Section("String selection")
				.add(new Text(
						"A simple Drop Down List selecting one of a list of Strings."))
				.add(new DropDown<String>("Your favorite color", Arrays.asList("red", "yellow", "green"),
						String.class)));

		this.add(new Section("Enum selection")
				.add(
						new Text(
								"Often, you will want to let the user select between one of a set of enum constants. This drop down list is backed by a color enum."))
				.add(new DropDown<Color>("Your favorite color", Arrays.asList(Color.values()), Color.class)));

		this.add(new Section("Enum selection with custom labels")
				.add(
						new Text(
								"Enums are usually all CAPITAL letters which you may want to translate in a more user friendly representation. You can do this by providing a ChoiceLabeller implementation."))
				.add(new DropDown<Color>("Your favorite color", Arrays.asList(Color.values()),
						new ColorLabeller(), Color.class)));

		this.add(new Section("Enum selection with selected value")
				.add(
						new Text(
								"As with most form elements, you can provide a default value in the constructor."))
				.add(
						new DropDown<Color>("Your favorite color", Arrays.asList(Color.values()),
								new ColorLabeller(),
								Color.RED, Color.class)));

	}

	private class ColorLabeller implements ChoiceLabeller<Color> {

		@Override
		public String getLabel(final Color choice) {
			return choice.getLabel();
		}

	}

	private enum Color {

		RED("Red"),

		YELLOW("Yellow"),

		GREEN("Green");

		private final String label;

		private Color(final String label) {
			this.label = label;
		}

		public String getLabel() {
			return this.label;
		}
	}

}
