package org.wickedsource.wickedforms.showcase;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.model.Model;
import org.apache.wicket.resource.JQueryResourceReference;
import org.wickedsource.wickedforms.model.FormModel;
import org.wickedsource.wickedforms.wicket7.components.FormPanel;

public class BasePage extends WebPage {

	public BasePage() {
		this(StaticFragment.USAGE);
	}

	public BasePage(final FormModel formModel, final Class<?> exampleCode) {
		initContentPanel(formModel);
		initCodeContainer(exampleCode);
		initShowCodeButtonContainer(exampleCode);
	}

	public BasePage(final StaticFragment staticFragment) {
		initContentPanel(staticFragment);
		initCodeContainer(null);
		initShowCodeButtonContainer(null);
	}

	public BasePage(final StaticFragment staticFragment, final Class<?> exampleCode) {
		initContentPanel(staticFragment);
		initCodeContainer(exampleCode);
		initShowCodeButtonContainer(exampleCode);
	}

	private void initShowCodeButtonContainer(final Class<?> exampleCode) {
		WebMarkupContainer container = new WebMarkupContainer("showCodeButtonContainer");
		container.setVisible(exampleCode != null);
		add(container);
	}

	private void initContentPanel(final FormModel formModel) {
		add(new FormPanel("contentPanel", Model.of(formModel)) {
			@Override
			public void onSubmit(final FormModel submittedData) {
				System.out.println("form submit");
			}
		});
	}

	private void initContentPanel(final StaticFragment staticFragment) {
		add(new Fragment("contentPanel", staticFragment.toString(), this));
	}

	private void initCodeContainer(final Class<?> exampleCode) {
		Label codeContainer = new Label("codeContainer");
		if (exampleCode == null) {
			codeContainer.setVisible(false);
		} else {
			codeContainer
			    .setDefaultModel(new StringFromResourceModel(exampleCode, exampleCode.getSimpleName() + ".java"));
			codeContainer.setVisible(true);
		}
		add(codeContainer);
	}

	@Override
	public void renderHead(final IHeaderResponse response) {
		super.renderHead(response);
		response.render(JavaScriptReferenceHeaderItem.forReference(JQueryResourceReference.get()));
	}

}
