package com.csg.wordfilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csg.wordfilter.rule.HasLengthAndStartsWithRule;
import com.csg.wordfilter.rule.HasLengthMoreThanRule;
import com.csg.wordfilter.rule.StartsWithRule;
import com.csg.wordfilter.rule.TextFilterRule;

public class WordFilter {

	public static void main(String[] args) {

		String filePath = (String) args[0];

		String ruleName = (String) args[1];

		String[] ruleParams = Arrays.copyOfRange(args, 2, args.length);

		// Read the file content
		try {
			String content = WordFilterUtil.readFileToString(filePath);
			List<String> tokens = WordFilterUtil.getStringTokens(content);

			/**
			 * load all rules, if there are more rules, add those rules to this list
			 */
			Map<String, TextFilterRule> rules = new HashMap<String, TextFilterRule>();

			/**
			 * this can be enhanced by using IoC or dynamically loading classes
			 */
			TextFilterRule rule1 = new StartsWithRule();
			rules.put(rule1.getName(), rule1);

			TextFilterRule rule2 = new HasLengthMoreThanRule();
			rules.put(rule2.getName(), rule2);

			TextFilterRule rule3 = new HasLengthAndStartsWithRule();
			rules.put(rule3.getName(), rule3);

			/**
			 * apply selected rule
			 */
			Boolean hasRule = rules.containsKey(ruleName);
			if (!hasRule) {
				System.out.println("Selected Rule has not been setup.");
				return;
			}

			TextFilterRule selectedRule = rules.get(ruleName);

			List<String> filteredStrings = selectedRule.filter(tokens, ruleParams);

			System.out.println(selectedRule.getDescription());

			for (String word : filteredStrings) {
				System.out.println(word);
			}
			if (filteredStrings.size() == 1) {
				System.out.println("There is one word found.");
			} else if (filteredStrings.size() > 1) {
				System.out.println(String.format("There are %d words found", filteredStrings.size()));
			} else {
				System.out.println("No word's found");
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
