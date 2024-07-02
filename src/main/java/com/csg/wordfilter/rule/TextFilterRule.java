package com.csg.wordfilter.rule;

import java.util.List;

public interface TextFilterRule {

	String getName();
	String getDescription();

	List<String> filter(List<String> input, String[] ruleParams);

}
