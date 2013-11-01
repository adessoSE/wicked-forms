package com.googlecode.wickedforms.examples.formelements;

import com.googlecode.wickedforms.model.FormModel;
import com.googlecode.wickedforms.model.SectionModel;
import com.googlecode.wickedforms.model.elements.TextModel;

public class SectionExample extends FormModel {

	public SectionExample() {
		super("Section Examples");

		add(new SectionModel("Simple Section")
		    .add(
		        new TextModel(
		            "This is a simple section containing only this text. " +
		                "A form is organized in one or many sections. " +
		                "Each Section has a label and is by default visualized " +
		                "by a border line. The label is used as section title.")));

		add(new SectionModel("Hidden Section")
		    .setHidden(true)
		    .add(new TextModel(
		        "The title and border of a section can be hidden. " +
		            "This text is part of a second section that is not visible to the user.")));

		add(new SectionModel("Nested Sections")
		    .add(new TextModel(
		        "Sections can be nested within other sections. This text is " +
		            "part of a first-level section."))
		    .add(new SectionModel("2nd-Level Section")
		        .add(new TextModel("This text is part of a section within another section."))
		        .add(new SectionModel("3rd-Level Section")
		            .add(new TextModel("This text is part of yet another nested section. " +
		                "Note that there is no restriction on how deep " +
		                "you can nest sections within each other. " +
		                "However, the default form design will fail to render " +
		                "them properly at some point...")))));

	}
}
