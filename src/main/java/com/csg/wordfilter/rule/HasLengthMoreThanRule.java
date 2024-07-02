package com.csg.wordfilter.rule;

import java.util.List;
import java.util.stream.Collectors;

public class HasLengthMoreThanRule implements TextFilterRule {

	private int minLength;

	public HasLengthMoreThanRule() {

	}

	@Override
	public String getName() {
		return "HasLengthMoreThan";
	}

	@Override
	public String getDescription() {
		return String.format("List of words more than %d characters.", minLength);
	}

	@Override
	public List<String> filter(List<String> input, String[] ruleParams) {
		if (ruleParams == null || ruleParams.length == 0) {
			throw new IllegalArgumentException("Rule params must contain one element -> minLength");
		}

		try {
			Integer minLength = Integer.valueOf(ruleParams[0]);
			this.minLength = minLength;

			List<String> filteredResult = input.stream()
					.filter(text -> text.length() > minLength) // Filter based on length
					.collect(Collectors.toList()); // Collect filtered strings into a list

			return filteredResult;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("minLength should be an integer");
		}
	}

}
