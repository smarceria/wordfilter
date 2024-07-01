package com.csg.wordfilter;

import java.util.List;
import java.util.stream.Collectors;

public class StartsWithRule implements TextFilterRule {

	private final String prefix;
	
	public StartsWithRule(String prefix) {
	    this.prefix = prefix;
	  }

	@Override
	public List<String> filter(List<String> input) {
		
		List<String> filteredResult = input.stream()
	            .filter(x -> x.toLowerCase().startsWith(prefix.toLowerCase()))
	            .collect(Collectors.toList());
	        

		return filteredResult;
	}



}
