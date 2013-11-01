package com.googlecode.wickedforms.showcase;

import org.apache.wicket.protocol.http.WebApplication;

import com.googlecode.wickedforms.showcase.formelements.CheckboxGroupPage;
import com.googlecode.wickedforms.showcase.formelements.CheckboxPage;
import com.googlecode.wickedforms.showcase.formelements.DropDownPage;
import com.googlecode.wickedforms.showcase.formelements.RadioGroupPage;
import com.googlecode.wickedforms.showcase.formelements.SectionPage;
import com.googlecode.wickedforms.showcase.formelements.TextAreaPage;
import com.googlecode.wickedforms.showcase.formelements.TextFieldPage;
import com.googlecode.wickedforms.showcase.formelements.TextPage;
import com.googlecode.wickedforms.showcase.generalusage.UsagePage;
import com.googlecode.wickedforms.showcase.metadata.DisabledPage;
import com.googlecode.wickedforms.showcase.metadata.LabelPage;
import com.googlecode.wickedforms.showcase.metadata.RequiredPage;
import com.googlecode.wickedforms.showcase.metadata.UserHintPage;
import com.googlecode.wickedforms.showcase.validators.CustomValidatorPage;
import com.googlecode.wickedforms.showcase.validators.MinMaxValidatorPage;
import com.googlecode.wickedforms.showcase.validators.UrlValidatorPage;

public class WicketApplication extends WebApplication {

	@Override
	public Class<BasePage> getHomePage() {
		return BasePage.class;
	}

	@Override
	public void init() {
		super.init();

		this.getMarkupSettings().setStripWicketTags(true);
		this.getMarkupSettings().setDefaultAfterDisabledLink("");
		this.getMarkupSettings().setDefaultBeforeDisabledLink("");

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
