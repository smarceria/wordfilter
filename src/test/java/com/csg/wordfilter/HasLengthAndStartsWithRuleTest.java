package com.csg.wordfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.csg.wordfilter.rule.HasLengthAndStartsWithRule;
import com.csg.wordfilter.rule.TextFilterRule;

public class HasLengthAndStartsWithRuleTest {
	@Test
	public void testHasLengthAndStartsWith_shouldReturnInputStringWithDefinedLength() {
		 List<String> testText = Arrays.asList("hello", "Mama", "I", "love", "you", "to", "the", "moon", "and", "back");
		 TextFilterRule rule = new HasLengthAndStartsWithRule();
		 List<String> filteredStrings = rule.filter(testText, new String[] {"4", "m"});

		 assertEquals(2, filteredStrings.size());
		 assertTrue(filteredStrings.contains("Mama"));
		 assertTrue(filteredStrings.contains("moon"));
	}

}
