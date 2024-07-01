package com.csg.wordfilter;

import java.util.List;

public interface TextFilterRule {

	List<String> filter(List<String> input);
	
}
