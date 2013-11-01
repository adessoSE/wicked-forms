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
package com.googlecode.wickedforms.wicket6.components.fields;

import org.apache.wicket.Component;
import org.apache.wicket.MetaDataKey;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;

import com.googlecode.wickedforms.model.FormModel;
import com.googlecode.wickedforms.model.SectionModel;
import com.googlecode.wickedforms.model.elements.AbstractFormElementModel;
import com.googlecode.wickedforms.wicket6.components.FormPanel;

/**
 * Base class for all panels that represent a form element within a form.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public abstract class AbstractFormElementPanel extends Panel {

	/**
	 * Key for storing the ID of an {@link AbstractFormElementModel} in a Wicket
	 * component.
	 */
	public static final MetaDataKey<String> COMPONENT_ID_KEY = new MetaDataKey<String>() {
	};

	private final AbstractFormElementModel model;

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            the wicket id.
	 * @param model
	 *            the Wicked Charts model object that is displayed by this
	 *            panel.
	 */
	public AbstractFormElementPanel(String id, AbstractFormElementModel model) {
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

	protected AbstractFormElementModel getWickedFormModel() {
		return model;
	}

	public FormModel getParentFormModel() {
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

	public SectionModel getParentSectionModel() {
		SectionPanel parentSectionPanel = getParentSectionPanel();
		if (parentSectionPanel == null) {
			throw new IllegalStateException("no SectionPanel could be found in the parent hierarchy");
		} else {
			return (SectionModel) parentSectionPanel.getWickedFormModel();
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
