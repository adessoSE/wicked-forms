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
package de.adesso.wickedforms.wicket6.components.fields;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.util.convert.IConverter;

public class DefaultListChoiceConverter implements IConverter<Object> {

	private final List<?> choices;

	public DefaultListChoiceConverter(List<?> choices) {
		this.choices = choices;
	}

	@Override
	public Object convertToObject(String value, Locale locale) {
		try {
			if (StringUtils.isEmpty(value)) {
				return null;
			}
			Integer index = Integer.valueOf(value);
			return this.choices.get(index);
		} catch (NumberFormatException e) {
			throw new RuntimeException(String.format("Invalid value for single select choice: %s. " +
					"A number representing the index of the selected choice was expected!", value));
		}
	}

	@Override
	public String convertToString(Object value, Locale locale) {
		throw new NotImplementedException("The method convertToString is not supported by this converter!");
	}
}
