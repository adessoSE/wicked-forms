package com.googlecode.wickedforms.examples.formelements;

import java.util.Arrays;

import com.googlecode.wickedforms.model.FormModel;
import com.googlecode.wickedforms.model.SectionModel;
import com.googlecode.wickedforms.model.elements.TextModel;
import com.googlecode.wickedforms.model.elements.fields.ChoiceLabeller;
import com.googlecode.wickedforms.model.elements.fields.DropDownModel;

public class DropDownExample extends FormModel {

	public DropDownExample() {
		super("Drop Down List Examples");

		this.add(new SectionModel("String selection")
				.add(new TextModel(
						"A simple Drop Down List selecting one of a list of Strings."))
				.add(new DropDownModel<String>("Your favorite color", Arrays.asList("red", "yellow", "green"),
						String.class)));

		this.add(new SectionModel("Enum selection")
				.add(
						new TextModel(
								"Often, you will want to let the user select between one of a set of enum constants. This drop down list is backed by a color enum."))
				.add(new DropDownModel<Color>("Your favorite color", Arrays.asList(Color.values()), Color.class)));

		this.add(new SectionModel("Enum selection with custom labels")
				.add(
						new TextModel(
								"Enums are usually all CAPITAL letters which you may want to translate in a more user friendly representation. You can do this by providing a ChoiceLabeller implementation."))
				.add(new DropDownModel<Color>("Your favorite color", Arrays.asList(Color.values()),
						new ColorLabeller(), Color.class)));

		this.add(new SectionModel("Enum selection with selected value")
				.add(
						new TextModel(
								"As with most form elements, you can provide a default value in the constructor."))
				.add(
						new DropDownModel<Color>("Your favorite color", Arrays.asList(Color.values()),
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
