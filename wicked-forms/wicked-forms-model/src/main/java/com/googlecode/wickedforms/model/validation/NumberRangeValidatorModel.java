/**
 *   Copyright 2013 Wicked Forms (http://wicked-forms.googlecode.com)
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
package com.googlecode.wickedforms.model.validation;

import com.googlecode.wickedforms.model.elements.fields.AbstractInputFieldModel;

/**
 * A simple validator that checks if a value is within a defined threshold.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 * @param <T>
 *          the type of Number to be validates
 */
public class NumberRangeValidatorModel<T extends Number> implements FieldValidatorModel<T> {

	private final T min;

	private final T max;

	/**
	 * Constructs a {@link NumberRangeValidatorModel} with the given thresholds.
	 * 
	 * @param min
	 *          the minimum threshold to validate against. May be null. In this
	 *          case, the input value is not checked against a lower threshold.
	 * @param max
	 *          the maximum threshold to validate against. May be null. In this
	 *          case, the input value is not checked against an upper threshold.
	 */
	public NumberRangeValidatorModel(final T min, final T max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void validate(final AbstractInputFieldModel<T> inputField, final T value,
	    final ValidationFeedback feedback) {
		if (this.min != null && value != null && value.doubleValue() < this.min.doubleValue()) {
			feedback.error(String.format("The value for '%s' is below the minimum of %s", inputField.getLabel(), this.min));
		}
		if (this.max != null && value != null && value.doubleValue() > this.max.doubleValue()) {
			feedback.error(String.format("The value for '%s' is above the maximum of %s", inputField.getLabel(), this.max));
		}
	}
}
