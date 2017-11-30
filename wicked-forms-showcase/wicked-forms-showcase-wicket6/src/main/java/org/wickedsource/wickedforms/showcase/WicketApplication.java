package org.wickedsource.wickedforms.showcase;

import org.apache.wicket.protocol.http.WebApplication;
import org.wickedsource.wickedforms.showcase.formelements.*;
import org.wickedsource.wickedforms.showcase.generalusage.UsagePage;
import org.wickedsource.wickedforms.showcase.metadata.DisabledPage;
import org.wickedsource.wickedforms.showcase.metadata.LabelPage;
import org.wickedsource.wickedforms.showcase.metadata.RequiredPage;
import org.wickedsource.wickedforms.showcase.metadata.UserHintPage;
import org.wickedsource.wickedforms.showcase.validators.CustomValidatorPage;
import org.wickedsource.wickedforms.showcase.validators.MinMaxValidatorPage;
import org.wickedsource.wickedforms.showcase.validators.UrlValidatorPage;

public class WicketApplication extends WebApplication {

	@Override
	public Class<BasePage> getHomePage() {
		return BasePage.class;
	}

	@Override
	public void init() {
		super.init();

		this.getMarkupSettings().setStripWicketTags(true);

		this.mountPage("usage", UsagePage.class);
		this.mountPage("section", SectionPage.class);
		this.mountPage("text", TextPage.class);
		this.mountPage("textfield", TextFieldPage.class);
		this.mountPage("textarea", TextAreaPage.class);
		this.mountPage("dropdown", DropDownPage.class);
		this.mountPage("checkbox", CheckboxPage.class);
		this.mountPage("radiogroup", RadioGroupPage.class);
		this.mountPage("checkboxgroup", CheckboxGroupPage.class);
		this.mountPage("label", LabelPage.class);
		this.mountPage("userhint", UserHintPage.class);
		this.mountPage("disabled", DisabledPage.class);
		this.mountPage("required", RequiredPage.class);
		this.mountPage("numbervalidator", MinMaxValidatorPage.class);
		this.mountPage("urlvalidator", UrlValidatorPage.class);
		this.mountPage("customvalidator", CustomValidatorPage.class);

	}
}
