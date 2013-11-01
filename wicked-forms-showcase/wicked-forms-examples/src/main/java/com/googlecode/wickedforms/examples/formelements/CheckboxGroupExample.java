package com.googlecode.wickedforms.examples.formelements;

import java.util.Arrays;

import com.googlecode.wickedforms.model.FormModel;
import com.googlecode.wickedforms.model.SectionModel;
import com.googlecode.wickedforms.model.elements.TextModel;
import com.googlecode.wickedforms.model.elements.fields.CheckboxGroupModel;
import com.googlecode.wickedforms.model.elements.fields.ChoiceLabeller;

public class CheckboxGroupExample extends FormModel {

	public CheckboxGroupExample() {
		super("Checkbox Group Examples");

		add(new SectionModel("String selection")
		    .add(new TextModel(
		        "A checkbox group allows multiple selections."))
		    .add(
		        new CheckboxGroupModel<String>("Where do you spend your spare time?", Arrays.asList("at the beach",
		            "on the soccer field", "on the couch", "in front of my computer"))));

		add(new SectionModel("Enum selection")
		    .add(
		        new TextModel(
		            "Often, you will want to let the user select between one of a set of enum constants. This radio group is backed by a color enum."))
		    .add(
		        new CheckboxGroupModel<LeisureActivity>("Where do you spend your spare time?", Arrays
		            .asList(LeisureActivity.values()))));

		add(new SectionModel("Enum selection with custom labels")
		    .add(
		        new TextModel(
		            "Enums are usually all CAPITAL letters which you may want to translate in a more user friendly representation. You can do this by providing a ChoiceLabeller implementation."))
		    .add(
		        new CheckboxGroupModel<LeisureActivity>("Where do you spend your spare time?", Arrays
		            .asList(LeisureActivity.values()), new LeisureActivityLabeller())));

		add(new SectionModel("Enum selection with selected value")
		    .add(
		        new TextModel(
		            "As with most form elements, you can provide a default value in the constructor. Since multiple selections are allowed, you may set multiple default values."))
		    .add(
		        new CheckboxGroupModel<LeisureActivity>("Where do you spend your spare time?", Arrays
		            .asList(LeisureActivity.values()), new LeisureActivityLabeller(),
		            Arrays.asList(LeisureActivity.COMPUTER, LeisureActivity.BEACH))));

	}

	private class LeisureActivityLabeller implements ChoiceLabeller<LeisureActivity> {

		@Override
		public String getLabel(final LeisureActivity choice) {
			return choice.getLabel();
		}

	}

	private enum LeisureActivity {

		BEACH("at the beach"),

		SOCCER("on the soccer field"),

		COUCH("on the couch"),

		COMPUTER("in front of my computer");

		private final String label;

		private LeisureActivity(final String label) {
			this.label = label;
		}

		public String getLabel() {
			return this.label;
		}
	}

}
