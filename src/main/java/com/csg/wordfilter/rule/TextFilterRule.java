package com.csg.wordfilter.rule;

import java.util.List;

/**
 * This interface defines a contract for different text filtering rules.
 * Classes implementing this interface provide functionalities for filtering text based on specific criteria.
 */
public interface TextFilterRule {

	/**
     * Returns name of filtering rule.
     * This is used to identify the type of rule applied.
     * 
     * @return The name of the filtering rule.
     */
	String getName();
	
    /**
     * Returns a description of the filtering rule.
     * The description explains what kind of filtering the rule performs
     * and any relevant parameters it might require.
     * 
     * @return The description of the filtering result.
     */
	String getDescription();
	
    /**
     * Filters a list of strings based on the rule's criteria.
     * 
     * @param input The list of strings to be filtered.
     * @param ruleParams An array of strings containing any rule-specific parameters.
     * @return A new list containing only elements from the input list that pass the filtering criteria.
     */
	List<String> filter(List<String> input, String[] ruleParams);

}
