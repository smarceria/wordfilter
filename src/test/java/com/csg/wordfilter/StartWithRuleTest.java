package com.csg.wordfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StartWithRuleTest {
	
	  @Test
	  public void testStartsWith_shouldReturnInputStringIfStartsWithPrefix() {
	    List<String> testText = Arrays.asList("hello", "Mama", "I", "love", "you", "to", "the", "moon", "and", "back");
	    String prefix = "m";
	    TextFilterRule rule = new StartsWithRule(prefix);
	    List<String> filteredStrings = rule.filter(testText);

	    assertEquals(2, filteredStrings.size());
	    assertTrue(filteredStrings.contains("Mama"));
	    assertTrue(filteredStrings.contains("moon"));
	  }

}
