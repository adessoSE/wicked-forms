package de.adesso.wickedforms.showcase;

import de.adesso.wickedforms.showcase.formelements.CheckboxGroupPage;
import de.adesso.wickedforms.showcase.formelements.CheckboxPage;
import de.adesso.wickedforms.showcase.formelements.DropDownPage;
import de.adesso.wickedforms.showcase.formelements.RadioGroupPage;
import de.adesso.wickedforms.showcase.formelements.SectionPage;
import de.adesso.wickedforms.showcase.formelements.TextAreaPage;
import de.adesso.wickedforms.showcase.formelements.TextFieldPage;
import de.adesso.wickedforms.showcase.formelements.TextPage;
import de.adesso.wickedforms.showcase.generalusage.UsagePage;
import de.adesso.wickedforms.showcase.metadata.DisabledPage;
import de.adesso.wickedforms.showcase.metadata.LabelPage;
import de.adesso.wickedforms.showcase.metadata.RequiredPage;
import de.adesso.wickedforms.showcase.validators.CustomValidatorPage;
import de.adesso.wickedforms.showcase.validators.MinMaxValidatorPage;
import org.apache.wicket.protocol.http.WebApplication;
import de.adesso.wickedforms.showcase.metadata.UserHintPage;
import de.adesso.wickedforms.showcase.validators.UrlValidatorPage;

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
