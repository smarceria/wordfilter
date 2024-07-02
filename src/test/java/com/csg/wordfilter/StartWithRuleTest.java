package com.csg.wordfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.csg.wordfilter.rule.StartsWithRule;
import com.csg.wordfilter.rule.TextFilterRule;

public class StartWithRuleTest {

	@Test
	public void testStartsWith_shouldReturnInputStringIfStartsWithPrefix() {
		 List<String> testText = Arrays.asList("hello", "Mama", "I", "love", "you", "to", "the", "moon", "and", "back");

		 TextFilterRule rule = new StartsWithRule();
		 List<String> filteredStrings = rule.filter(testText, new String[] {"m"});

		 assertEquals(2, filteredStrings.size());
		 assertTrue(filteredStrings.contains("Mama"));
		 assertTrue(filteredStrings.contains("moon"));
	}

}
