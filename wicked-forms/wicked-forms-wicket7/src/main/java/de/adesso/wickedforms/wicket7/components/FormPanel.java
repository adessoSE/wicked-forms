/**
 * Copyright 2013 Wicked Forms (https://github.com/thombergs/wicked-forms)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.adesso.wickedforms.wicket7.components;

import de.adesso.wickedforms.model.Form;
import de.adesso.wickedforms.wicket7.DefaultPanelFactory;
import de.adesso.wickedforms.wicket7.PanelFactory;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.PackageResourceReference;

import java.util.ArrayList;
import java.util.List;

public abstract class FormPanel extends GenericPanel<Form> implements Submittable {

    private final PanelFactory panelFactory;

    public FormPanel(String id, final IModel<Form> model) {
        this(id, model, true);
    }

    /**
     * Constructor.
     *
     * @param id    the wicket id this panel should bind to.
     * @param model the form model that describes the contents of the form.
     */
    public FormPanel(final String id, final IModel<Form> model, boolean showSubmittable) {
        super(id, model);
        model.getObject().assignIds();
        this.panelFactory = new DefaultPanelFactory();
        add(new DynamicForm("form", model, panelFactory, this, showSubmittable));
        mountResources();
    }

    public FormPanel(final String id, final Form formModel) {
        this(id, formModel, true);
    }

    @SuppressWarnings("unchecked")
    public FormPanel(final String id, final Form formModel, boolean showSubmittable) {
        super(id, Model.of(formModel));
        formModel.assignIds();
        this.panelFactory = new DefaultPanelFactory();
        add(new DynamicForm("form", getModel(), panelFactory, this, showSubmittable));
        mountResources();
    }

    public FormPanel(final String id, final IModel<Form> model, final PanelFactory panelFactory) {
        this(id, model, panelFactory, true);
    }

    /**
     * Constructor defining a {@link PanelFactory}. The {@link PanelFactory} is
     * responsible for creating the sub panels that each contain an element of
     * the form (i.e. a text field, a checkbox, ...). By providing a custom
     * {@link PanelFactory}, you can define your own panels with their own HTML
     * markup to be used and thus override the default look & feel.
     *
     * @param id              the wicket id this panel should bind to.
     * @param model           the form model that describes the contents of the form.
     * @param panelFactory    the factory to use for creating the sub panels that each
     *                        contain a form element (text field, checkbox, ...).
     * @param showSubmittable tells the form to be submittable from outer form (without explicit submit-button) or can be submitted by itself.
     */
    public FormPanel(final String id, final IModel<Form> model,
                     final PanelFactory panelFactory, boolean showSubmittable) {
        super(id, model);
        model.getObject().assignIds();
        this.panelFactory = panelFactory;
        add(new DynamicForm("form", model, panelFactory, this, showSubmittable));
        mountResources();
    }

    /**
     * Retrieves all {@link HeaderItem}s like Javascript files and CSS files
     * that should be included in each page that contains a {@link FormPanel}.
     * Override this method to provide different CSS.
     *
     * @return all {@link HeaderItem}s to add to the page.
     */
    protected List<HeaderItem> getHeaderItems() {
        List<HeaderItem> headerItems = new ArrayList<HeaderItem>();
        headerItems.add(CssHeaderItem
                .forReference(new PackageResourceReference(FormPanel.class,
                        "FormPanel.css")));
        return headerItems;
    }

    private void mountResources() {
        WebApplication application = ((WebApplication) getApplication());
        application.mountResource("wickedforms/invalid.png",
                new PackageResourceReference(FormPanel.class, "invalid.png"));
        application.mountResource("wickedforms/red_asterisk.png",
                new PackageResourceReference(FormPanel.class,
                        "red_asterisk.png"));
        application.mountResource("wickedforms/valid.png",
                new PackageResourceReference(FormPanel.class, "valid.png"));
    }

    /**
     * Executed when the form is submitted.
     *
     * @param submittedData the {@link Form} object containing the state of the form
     *                      at submit time. If you have used Bindings and implemented
     *                      {@link de.adesso.wickedforms.model.elements.AbstractFormElement#onDiscard} to clean up after
     *                      discarded elements, the user input will be bound to the target
     *                      objects by now and you will not actually need to evaluate this
     *                      parameter.
     *                      <p/>
     *                      If you need to evaluate this parameter, be aware that elements
     *                      that were marked as "discarded" while the user worked with the
     *                      form, are still contained. Call
     *                      {@link de.adesso.wickedforms.model.elements.AbstractFormElement#isDiscarded()} on each element
     *                      before evaluating it.
     */
    @Override
    public abstract void onSubmit(final Form submittedData);

    @Override
    public void renderHead(final IHeaderResponse response) {
        for (HeaderItem headerItem : getHeaderItems()) {
            response.render(headerItem);
        }
    }

    public Form getWickedFormModel() {
        return (Form) getDefaultModelObject();
    }

}
