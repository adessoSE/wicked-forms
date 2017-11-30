/**
 *   Copyright 2013 Wicked Forms (https://github.com/thombergs/wicked-forms)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package de.adesso.wickedforms.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import de.adesso.wickedforms.model.elements.AbstractFormElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A section of a dynamic form. With sections, multiple form elements that
 * belong together can be combined.
 * <p/>
 * A Wicked Forms interpreter should display a section in a way that makes it
 * visible to the user that the contained form elements belong together.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public class Section extends AbstractFormElement {

	private String label;

	private final List<AbstractFormElement> formElements = new ArrayList<AbstractFormElement>();

	private boolean hidden = false;

	private boolean showRemoveButton = false;

	/**
	 * Constructor.
	 * 
	 * @param label
	 *            the title of the form. This title should be displayed
	 *            prominently by a Wicked Forms interpreter.
	 */
	public Section(final String label) {
		this.label = label;
	}

	/**
	 * Constructs a hidden section (i.e. without title and without visual
	 * border.
	 */
	public Section() {
		this.hidden = true;
	}

	/**
	 * Sets the title of this section.
	 * 
	 * @param label
	 *            the new title.
	 * @return this object for chaining
	 */
	public Section setLabel(final String label) {
		this.label = label;
		return this;
	}

	public String getTitle() {
		return this.label;
	}

	/**
	 * Adds a form element to the end of this section.
	 * 
	 * @param element
	 *            the element to add.
	 * @return this object for chaining
	 */
	public Section add(final AbstractFormElement element) {
		element.setIndex(this.formElements.size());
		element.setParentSection(this);
		this.formElements.add(element);
		return this;
	}

	public Section remove(final AbstractFormElement elementToRemove) {
		if (this.formElements.remove(elementToRemove)) {
			elementToRemove.setParentSection(null);
			// shift the index of all form elements behind the new one by one
			for (AbstractFormElement element : this.formElements) {
				if (element.getIndex() > elementToRemove.getIndex()) {
					element.setIndex(element.getIndex() - 1);
				}
			}
		}
		return this;
	}

	/**
	 * Inserts a new element before another element.
	 * <p/>
	 * Internal note: the element is actually added into the formElements list
	 * as the last item! The newly added form element and all elements behind it
	 * will merely have {@link AbstractFormElement#setIndex(Integer)}
	 * called with the according index. This is due to the fact that frameworks
	 * working on the formElements List may access the elements by List index
	 * and may thus be unable to work with elements shifting within the List.
	 * 
	 * @param newElement
	 *            the new element to insert
	 * @param beforeThis
	 *            the element before which to insert the new element
	 * @throws IllegalArgumentException
	 *             if the element before which to insert is not found in this
	 *             section.
	 * @return this object for chaining
	 */
	public Section insertBefore(final AbstractFormElement newElement,
			final AbstractFormElement beforeThis) {
		int index = beforeThis.getIndex();
		if (index == -1) {
			throw new IllegalArgumentException(
					"this section dos not contain the form element before which to insert the new element!");
		}

		// shift the index of all form elements behind the new one by one
		for (AbstractFormElement element : this.formElements) {
			if (element.getIndex() >= index) {
				element.setIndex(element.getIndex() + 1);
			}
		}

		newElement.setParentSection(this);
		newElement.setIndex(index);
		this.formElements.add(newElement);
		return this;
	}

	/**
	 * Retrieves all form elements currently contained in this section.
	 * <p/>
	 * Note that the returned list is not necessarily sorted by the index of the
	 * contained form elements! To have them sorted, use a comparator that sorts
	 * by {@link AbstractFormElement#getIndex()}.
	 * 
	 * @return the form elements.
	 */
	public List<AbstractFormElement> getFormElements() {
		return Collections.unmodifiableList(this.formElements);
	}

	public Section setHidden(final boolean hidden) {
		this.hidden = hidden;
		return this;
	}

	public boolean isHidden() {
		return this.hidden;
	}

	/**
	 * Assigns each form element that is part of this section a unique id if it
	 * does not have an id yet.
	 * 
	 * @param startValue
	 *            the ID to start with
	 * @return the last ID that was assigned
	 */
	protected int assignIds(int startValue) {
		setId("" + startValue++);
		for (AbstractFormElement formElement : this.getFormElements()) {
			if (formElement instanceof Section) {
				startValue = ((Section) formElement).assignIds(startValue++);
			} else if (formElement.getId() == null
					|| "".equals(formElement.getId())) {
				formElement.setId("" + startValue++);
			}
		}
		return startValue;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * Sets whether a "remove" button should be displayed for this section.
	 * 
	 * @return this object for chaining
	 */
	public Section setShowRemoveButton(boolean showRemoveButton) {
		this.showRemoveButton = showRemoveButton;
		return this;
	}

	/**
	 * Determines if a "remove" button should be displayed for this section.
	 * 
	 * @return
	 */
	public boolean isShowRemoveButton() {
		return this.showRemoveButton;
	}

	/**
	 * recursive search through the forms sections/elements for the given id
	 * 
	 * @param id
	 *            like the given id in the XML-form
	 * @return returns the formelement representing with the given id
	 */
	public AbstractFormElement getElementById(String id) {

		AbstractFormElement element = null;

		// this element is the searched one
		if (getId().equals(id)) {
			return this;
		} else {
			for (AbstractFormElement formElement : formElements) {

				// the child element is the searched one
				if (formElement.getId().equals(id)) {
					return formElement;
				}

				// search in child-elements
				if (formElement instanceof Section) {
					element = ((Section) formElement).getElementById(id);
					if (element != null)
						return element;
				}
			}
		}
		// no element found
		return null;
	}

}
