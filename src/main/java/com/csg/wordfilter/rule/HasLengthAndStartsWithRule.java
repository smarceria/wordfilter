package com.csg.wordfilter.rule;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements the `TextFilterRule` interface and defines a rule that filters text based on
 * both minimum length and starting characters. Words must meet both criteria to be included in the filtered list.
 */

public class HasLengthAndStartsWithRule implements TextFilterRule {

	private int length;
	private String prefix;

	public HasLengthAndStartsWithRule() {

	}

	@Override
	public String getName() {
		return "HasLengthAndStartsWith";
	}

	@Override
	public String getDescription() {
		return String.format("List of words with %d letters and starts with '%s'.", length, prefix);
	}

	@Override
	public List<String> filter(List<String> input, String[] ruleParams) {
		if (ruleParams == null || ruleParams.length == 0 || ruleParams.length < 2) {
			throw new IllegalArgumentException("Rule params must contain two elements -> length, prefix");
		}

		try {
			Integer length = Integer.valueOf(ruleParams[0]);
			this.length = length;

			String prefix = (String) ruleParams[1];
			this.prefix = prefix;

			List<String> filteredResult = input.stream()
					.filter(text -> text.length() == length) // Filter based on length
					.filter(x -> x.toLowerCase().startsWith(prefix.toLowerCase()))
					.collect(Collectors.toList()); // Collect filtered strings into a list

			return filteredResult;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("length should be an integer");
		}
	}

}
