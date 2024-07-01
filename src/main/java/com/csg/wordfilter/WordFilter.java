package com.csg.wordfilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordFilter {

	public static void main(String[] args) {

		String filePath = args[0];
		String prefix = args[1];
		String minLength = args[2];
		
		 // Read the file content
	    try {
			String content = WordFilterUtil.readFileToString(filePath);
			List<String> tokens = WordFilterUtil.getStringTokens(content);
			
			TextFilterRule startsWithRule = new StartsWithRule(prefix);
			
			List<String> filteredStrings = new ArrayList<>();
			System.out.println("FILTER WORDS STARTS WITH "+ prefix);
			for (String word : startsWithRule.filter(tokens)) {
				System.out.println(word);
				filteredStrings.add(word);
			}
			if (filteredStrings.size() == 1) {
				System.out.println("There is one word found.");
			} else if (filteredStrings.size() > 1) {
				System.out.println(String.format("There are %d words found", filteredStrings.size()));
			} else {
				System.out.println("No word's found");
			}
			
			System.out.println("===========================================");
			
			TextFilterRule hasLengthMoreThanFive = new HasLengthMoreThanRule(Integer.valueOf(minLength));
			
			System.out.println("FILTER WORDS WITH LENGTH MORE THAN " + minLength + ":");
			for (String word : hasLengthMoreThanFive.filter(filteredStrings)) {
				System.out.println(word);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
