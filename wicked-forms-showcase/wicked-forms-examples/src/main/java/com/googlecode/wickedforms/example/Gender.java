package com.googlecode.wickedforms.example;

import java.io.Serializable;

import com.googlecode.wickedforms.model.elements.fields.ChoiceLabeller;

public enum Gender implements Serializable {

	MALE("Male"),

	FEMALE("Female");

	private final String label;

	private Gender(final String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public static ChoiceLabeller<Gender> choiceLabeller() {
		return new ChoiceLabeller<Gender>() {

			@Override
			public String getLabel(final Gender choice) {
				return choice.getLabel();
			}
		};
	}

}
