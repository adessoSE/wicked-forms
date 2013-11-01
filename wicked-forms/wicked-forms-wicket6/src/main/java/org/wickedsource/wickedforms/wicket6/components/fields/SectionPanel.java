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
package org.wickedsource.wickedforms.wicket6.components.fields;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.AbstractSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.wickedsource.wickedforms.model.SectionModel;
import org.wickedsource.wickedforms.model.elements.AbstractFormElementModel;
import org.wickedsource.wickedforms.wicket6.PanelFactory;
import org.wickedsource.wickedforms.wicket6.components.LocalizedString;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SectionPanel extends AbstractFormElementPanel {

	private final PanelFactory panelFactory;

	private ListView<AbstractFormElementModel> listView;

	private AbstractSubmitLink removeButton;

	public SectionPanel(final String id, final SectionModel model, final PanelFactory panelFactory) {
		super(id, model);
		setOutputMarkupId(true);
		setRenderBodyOnly(false);
		this.panelFactory = panelFactory;
	}

	@Override
	protected void onConfigure() {
		if (!hasBeenRendered()) {
			SectionModel model = (SectionModel) getWickedFormModel();
			Fragment fragment;
			if (model.isHidden()) {
				fragment = new Fragment("sectionFragment", "hiddenSection", this);
			} else {
				fragment = new Fragment("sectionFragment", "defaultSection", this);
				Label titleLabel = new Label("sectionTitle", model.getTitle());
				fragment.add(titleLabel);
			}

			ListView<AbstractFormElementModel> elementList = createElementList("elementList", model);
			fragment.add(elementList);
			removeButton = createAjaxButton("removeButton");
			removeButton.setDefaultFormProcessing(false);
			removeButton
					.add(new AttributeModifier("value", getString(LocalizedString.REMOVE_BUTTON_LABEL.getResourceKey())));
			removeButton.setVisible(model.isShowRemoveButton());
			fragment.add(removeButton);

			add(fragment);
		}
	}

	/**
	 * Creates a "remove"-Button that removes this section via AJAX.
	 */
	private AjaxSubmitLink createAjaxButton(String wicketId) {
		AjaxSubmitLink button = new AjaxSubmitLink(wicketId) {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				SectionModel sectionToRemove = (SectionModel) getWickedFormModel();
				sectionToRemove.discard();
				SectionPanel.this.setVisible(false);
				target.add(getParentSectionPanel());
			}
		};
		return button;
	}

	// private SubmitLink createAjaxlessButton(String wicketId) {
	// SubmitLink button = new SubmitLink(wicketId) {
	// @Override
	// public void onSubmit() {
	// SectionModel sectionToRemove = (SectionModel) getWickedFormModel();
	// sectionToRemove.discard();
	// SectionPanel.this.setVisible(false);
	// }
	// };
	//
	// return button;
	// }

/**
	 * Creates the {@link ListView} that contains the section's form elements.
	 * <p/>
	 * The created {@link ListView} will render it's items sorted by {@link AbstractFormElementModel#getIndex().
	 * 
	 * @param wicketId the wicket id of the ListView
	 * @param section the model of the section for which to create the {@link ListView}
	 * @return a sorted ListView of the sections elements.
	 */
	private ListView<AbstractFormElementModel> createElementList(final String wicketId,
			final SectionModel section) {

		IModel<List<AbstractFormElementModel>> model = new PropertyModel<List<AbstractFormElementModel>>(section,
				"formElements");

		listView = new ListView<AbstractFormElementModel>(wicketId, model) {
			@Override
			protected void populateItem(final ListItem<AbstractFormElementModel> item) {
				AbstractFormElementModel element = item.getModelObject();
				item.add(createFormElementPanel("elementPanel", element));
				item.setRenderBodyOnly(true);
			}

			@Override
			protected Iterator<Component> renderIterator() {
				return iterator(new Comparator<Component>() {
					@Override
					@SuppressWarnings("unchecked")
					public int compare(Component o1, Component o2) {
						ListItem<AbstractFormElementModel> item1 = (ListItem<AbstractFormElementModel>) o1;
						AbstractFormElementModel model1 = item1.getModelObject();
						ListItem<AbstractFormElementModel> item2 = (ListItem<AbstractFormElementModel>) o2;
						AbstractFormElementModel model2 = item2.getModelObject();
						return model1.getIndex().compareTo(model2.getIndex());
					}
				});
			};
		};
		listView.setReuseItems(true);
		return listView;
	}

	private <T> Component createFormElementPanel(final String wicketId, final AbstractFormElementModel element) {
		return panelFactory.createFormElementPanel(wicketId, element);

	}

	public ListView<AbstractFormElementModel> getListView() {
		return listView;
	}

	public void showRemoveButton() {
		removeButton.setVisible(true);
	}

	public void hideRemoveButton() {
		removeButton.setVisible(false);
	}
}
