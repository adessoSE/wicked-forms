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
package org.wickedsource.wickedforms.wicket7.components.fields;

import org.apache.wicket.Component;
import org.apache.wicket.MetaDataKey;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.wickedsource.wickedforms.model.Form;
import org.wickedsource.wickedforms.model.Section;
import org.wickedsource.wickedforms.model.elements.AbstractFormElement;
import org.wickedsource.wickedforms.wicket7.components.FormPanel;

/**
 * Base class for all panels that represent a form element within a form.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public abstract class AbstractFormElementPanel extends Panel {

	/**
	 * Key for storing the ID of an {@link AbstractFormElement} in a Wicket
	 * component.
	 */
	public static final MetaDataKey<String> COMPONENT_ID_KEY = new MetaDataKey<String>() {
	};

	private final AbstractFormElement model;

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            the wicket id.
	 * @param model
	 *            the Wicked Charts model object that is displayed by this
	 *            panel.
	 */
	public AbstractFormElementPanel(String id, AbstractFormElement model) {
		super(id);
		this.model = model;
		setRenderBodyOnly(true);
		setVisible(model.isVisible());
	}

	/**
	 * Decorates a component of the form. Must be called by subclasses for each
	 * component that represents a Wicked Charts model object (e.g. a subclass
	 * panel that displays a text field must call this method with the
	 * {@link TextField} component).
	 * 
	 * @param component
	 *            the component to decorate.
	 */
	protected void decorateComponent(Component component) {
		component.setMetaData(COMPONENT_ID_KEY, model.getId());
	}

	protected AbstractFormElement getWickedFormModel() {
		return model;
	}

	public Form getParentFormModel() {
		FormPanel parentFormPanel = getParentFormPanel();
		if (parentFormPanel == null) {
			throw new IllegalStateException("no FormPanel could be found in the parent hierarchy");
		} else {
			return parentFormPanel.getWickedFormModel();
		}
	}

	public FormPanel getParentFormPanel() {
		Component parent = getParent();
		while (parent != null) {
			if (parent instanceof FormPanel) {
				return (FormPanel) parent;
			}
			parent = parent.getParent();
		}
		return null;
	}

	public Section getParentSectionModel() {
		SectionPanel parentSectionPanel = getParentSectionPanel();
		if (parentSectionPanel == null) {
			throw new IllegalStateException("no SectionPanel could be found in the parent hierarchy");
		} else {
			return (Section) parentSectionPanel.getWickedFormModel();
		}
	}

	public SectionPanel getParentSectionPanel() {
		Component parent = getParent();
		while (parent != null) {
			if (parent instanceof SectionPanel) {
				return (SectionPanel) parent;
			}
			parent = parent.getParent();
		}
		return null;
	}

}
