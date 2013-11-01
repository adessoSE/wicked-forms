/**
 *   Copyright 2013 Wicked Forms (http://wicked-forms.googlecode.com)
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
package com.googlecode.wickedforms.model.elements;

import java.io.Serializable;

import com.googlecode.wickedforms.model.SectionModel;

/**
 * Base class for all elements that are contained within a form. A
 * {@link AbstractFormElementModel} contains a value of type T that is displayed
 * to the user as the content of the form element.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public abstract class AbstractFormElementModel implements Serializable {

	private String id;

	private Integer index;

	private SectionModel parentSection;

	private boolean discarded = false;

	private boolean visible = true;

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns the ID of this form element. An ID must be unique within a form.
	 * 
	 * @return the ID of this form element.
	 */
	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		if (this.id == null) {
			return 0;
		} else {
			return this.id.hashCode();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractFormElementModel)) {
			return false;
		}
		if (this.id == null) {
			return false;
		}
		AbstractFormElementModel that = (AbstractFormElementModel) obj;
		return this.id.equals(that.id);
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getIndex() {
		return index;
	}

	public void setParentSection(SectionModel parentSection) {
		this.parentSection = parentSection;
	}

	public SectionModel getParentSection() {
		return parentSection;
	}

	/**
	 * Marks this form element as "discarded", meaning that the user did
	 * something with the consequence that the input from this form element must
	 * not be evaluated at form submission.
	 * <p/>
	 * A use case for discarding a form element is when a user clicks on a
	 * "remove this section" button. The section is not actually removed from
	 * the FormModel but instead marked "discarded", so that frameworks that
	 * work with list indices still function. Elements marked as "discarded"
	 * should not be evaluated in the form's onSubmit method!
	 * <p/>
	 * Note that you should implement {@link #onDiscard()} when you plan to call
	 * this method.
	 */
	public void discard() {
		this.discarded = true;
		onDiscard();
	}

	public boolean isDiscarded() {
		return discarded;
	}

	/**
	 * This method can be implemented by subclasses to clean up after a form
	 * element has been discarded.
	 * <p/>
	 * This clean up is needed when the user input of a discarded form element
	 * is bound to another java object. The bound object should then be removed
	 * from the object tree so it will not be processed on form submission.
	 */
	protected void onDiscard() {
		// do nothing by default
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}

}
