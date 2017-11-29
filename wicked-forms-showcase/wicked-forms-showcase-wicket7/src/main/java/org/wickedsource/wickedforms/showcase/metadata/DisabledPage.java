package org.wickedsource.wickedforms.showcase.metadata;

import org.wickedsource.wickedforms.metadata.DisabledExample;
import org.wickedsource.wickedforms.showcase.BasePage;

public class DisabledPage extends BasePage {

	public DisabledPage() {
		super(new DisabledExample(), DisabledExample.class);
	}

}
