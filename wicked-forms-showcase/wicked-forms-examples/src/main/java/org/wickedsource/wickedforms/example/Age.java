package org.wickedsource.wickedforms.example;

import org.wickedsource.wickedforms.model.elements.fields.ChoiceLabeller;

import java.io.Serializable;

public enum Age implements Serializable {

	TEENAGER("younger than 18"),

	YOUNG("between 18 and 30"),

	OLD("older than 30");

	private final String label;

	private Age(final String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public static ChoiceLabeller<Age> choiceLabeller() {
		return new ChoiceLabeller<Age>() {

			@Override
			public String getLabel(final Age choice) {
				return choice.getLabel();
			}
		};
	}

}
