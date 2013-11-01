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
package org.wickedsource.wickedforms.wicket6;

import org.apache.wicket.markup.html.panel.Panel;
import org.wickedsource.wickedforms.model.elements.AbstractFormElementModel;

import java.io.Serializable;

/**
 * A PanelFactory is responsible for creating a Wicket {@link Panel} for each
 * {@link AbstractFormElementModel}.
 * <p/>
 * By providing a custom implementation (that extends
 * {@link DefaultPanelFactory}, you can add your own form elements.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public interface PanelFactory extends Serializable {

	/**
	 * Creates a panel that contains a form element that is described by the given
	 * subtype of {@link AbstractFormElementModel}.
	 * 
	 * @param wicketId
	 *          the Wicket ID of the panel that is to be created.
	 * @param element
	 *          the model of the form element to create the panel for.
	 * @return
	 */
	Panel createFormElementPanel(final String wicketId, final AbstractFormElementModel element);

}
