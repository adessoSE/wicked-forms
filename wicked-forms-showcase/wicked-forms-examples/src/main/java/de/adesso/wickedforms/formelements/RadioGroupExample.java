package de.adesso.wickedforms.formelements;

import de.adesso.wickedforms.model.elements.fields.RadioGroup;
import de.adesso.wickedforms.model.Form;
import de.adesso.wickedforms.model.Section;
import de.adesso.wickedforms.model.elements.Text;
import de.adesso.wickedforms.model.elements.fields.ChoiceLabeller;

import java.util.Arrays;

public class RadioGroupExample extends Form {

	public RadioGroupExample() {
		super("Radio Group Examples");

		this.add(new Section("String selection")
				.add(new Text(
						"A simple radio group selecting one of a list of Strings."))
				.add(new RadioGroup<String>("Your favorite color", Arrays.asList("red", "yellow", "green"),
						String.class)));

		this.add(new Section("Enum selection")
				.add(
						new Text(
								"Often, you will want to let the user select between one of a set of enum constants. This radio group is backed by a color enum."))
				.add(new RadioGroup<Color>("Your favorite color", Arrays.asList(Color.values()), Color.class)));

		this.add(new Section("Enum selection with custom labels")
				.add(
						new Text(
								"Enums are usually all CAPITAL letters which you may want to translate in a more user friendly representation. You can do this by providing a ChoiceLabeller implementation."))
				.add(new RadioGroup<Color>("Your favorite color", Arrays.asList(Color.values()),
						new ColorLabeller(), Color.class)));

		this.add(new Section("Enum selection with selected value")
				.add(
						new Text(
								"As with most form elements, you can provide a default value in the constructor."))
				.add(
						new RadioGroup<Color>("Your favorite color", Arrays.asList(Color.values()),
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
