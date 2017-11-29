package org.wickedsource.wickedforms.formelements;

import org.wickedsource.wickedforms.model.Form;
import org.wickedsource.wickedforms.model.Section;
import org.wickedsource.wickedforms.model.elements.Text;
import org.wickedsource.wickedforms.model.elements.fields.CheckboxGroup;
import org.wickedsource.wickedforms.model.elements.fields.ChoiceLabeller;

import java.util.Arrays;

public class CheckboxGroupExample extends Form {

	public CheckboxGroupExample() {
		super("Checkbox Group Examples");

		add(new Section("String selection")
		    .add(new Text(
		        "A checkbox group allows multiple selections."))
		    .add(
		        new CheckboxGroup<String>("Where do you spend your spare time?", Arrays.asList("at the beach",
		            "on the soccer field", "on the couch", "in front of my computer"))));

		add(new Section("Enum selection")
		    .add(
		        new Text(
		            "Often, you will want to let the user select between one of a set of enum constants. This radio group is backed by a color enum."))
		    .add(
		        new CheckboxGroup<LeisureActivity>("Where do you spend your spare time?", Arrays
		            .asList(LeisureActivity.values()))));

		add(new Section("Enum selection with custom labels")
		    .add(
		        new Text(
		            "Enums are usually all CAPITAL letters which you may want to translate in a more user friendly representation. You can do this by providing a ChoiceLabeller implementation."))
		    .add(
		        new CheckboxGroup<LeisureActivity>("Where do you spend your spare time?", Arrays
		            .asList(LeisureActivity.values()), new LeisureActivityLabeller())));

		add(new Section("Enum selection with selected value")
		    .add(
		        new Text(
		            "As with most form elements, you can provide a default value in the constructor. Since multiple selections are allowed, you may set multiple default values."))
		    .add(
		        new CheckboxGroup<LeisureActivity>("Where do you spend your spare time?", Arrays
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
