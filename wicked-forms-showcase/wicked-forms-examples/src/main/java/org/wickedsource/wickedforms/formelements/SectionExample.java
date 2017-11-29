package org.wickedsource.wickedforms.formelements;

import org.wickedsource.wickedforms.model.Form;
import org.wickedsource.wickedforms.model.Section;
import org.wickedsource.wickedforms.model.elements.Text;

public class SectionExample extends Form {

	public SectionExample() {
		super("Section Examples");

		add(new Section("Simple Section")
		    .add(
		        new Text(
		            "This is a simple section containing only this text. " +
		                "A form is organized in one or many sections. " +
		                "Each Section has a label and is by default visualized " +
		                "by a border line. The label is used as section title.")));

		add(new Section("Hidden Section")
		    .setHidden(true)
		    .add(new Text(
		        "The title and border of a section can be hidden. " +
		            "This text is part of a second section that is not visible to the user.")));

		add(new Section("Nested Sections")
		    .add(new Text(
		        "Sections can be nested within other sections. This text is " +
		            "part of a first-level section."))
		    .add(new Section("2nd-Level Section")
		        .add(new Text("This text is part of a section within another section."))
		        .add(new Section("3rd-Level Section")
		            .add(new Text("This text is part of yet another nested section. " +
		                "Note that there is no restriction on how deep " +
		                "you can nest sections within each other. " +
		                "However, the default form design will fail to render " +
		                "them properly at some point...")))));

	}
}
