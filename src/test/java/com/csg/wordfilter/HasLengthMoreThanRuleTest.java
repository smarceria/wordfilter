package com.csg.wordfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.csg.wordfilter.rule.HasLengthMoreThanRule;
import com.csg.wordfilter.rule.TextFilterRule;

public class HasLengthMoreThanRuleTest {
	@Test
	public void testHasLengthMoreThan_shouldReturnInputStringWithDefinedMinLength() {
		 List<String> testText = Arrays.asList("hello", "Mama", "I", "love", "you", "to", "the", "moon", "and", "back");
		 TextFilterRule rule = new HasLengthMoreThanRule();
		 List<String> filteredStrings = rule.filter(testText, new String[] {"3"});

		 assertEquals(5, filteredStrings.size());
		 assertTrue(filteredStrings.contains("hello"));
		 assertTrue(filteredStrings.contains("Mama"));
		 assertTrue(filteredStrings.contains("love"));
		 assertTrue(filteredStrings.contains("moon"));
		 assertTrue(filteredStrings.contains("back"));

	}

}
