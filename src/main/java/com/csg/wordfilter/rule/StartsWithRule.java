package com.csg.wordfilter.rule;

import java.util.List;
import java.util.stream.Collectors;

public class StartsWithRule implements TextFilterRule {

	private String prefix;

	public StartsWithRule() {

	}

	@Override
	public String getName() {
		return "StartsWith";
	}

	@Override
	public String getDescription() {
		return String.format("List of words starts with '%s'.", prefix);
	}

	@Override
	public List<String> filter(List<String> input, String[] ruleParams) {
		if (ruleParams == null || ruleParams.length == 0) {
			throw new IllegalArgumentException("Rule params must contain one element -> prefix");
		}

		String prefix = (String) ruleParams[0];
		this.prefix = prefix;

		List<String> filteredResult = input.stream()
				.filter(x -> x.toLowerCase().startsWith(prefix.toLowerCase()))
				.collect(Collectors.toList());

		return filteredResult;
	}

}
