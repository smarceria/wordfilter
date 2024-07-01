package com.csg.wordfilter;

import java.util.List;
import java.util.stream.Collectors;

public class HasLengthMoreThanRule implements TextFilterRule {

	private final int minLength;

	public HasLengthMoreThanRule(int minLength) {
	    this.minLength = minLength;
	}
	  
	@Override
	public List<String> filter(List<String> input) {
		return input.stream()
			      .filter(text -> text.length() > minLength) // Filter based on length
			      .collect(Collectors.toList()); // Collect filtered strings into a list
			
	}

}
