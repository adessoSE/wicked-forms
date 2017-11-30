package de.adesso.wickedforms.showcase.metadata;

import de.adesso.wickedforms.metadata.DisabledExample;
import de.adesso.wickedforms.showcase.BasePage;

public class DisabledPage extends BasePage {

	public DisabledPage() {
		super(new DisabledExample(), DisabledExample.class);
	}

}
