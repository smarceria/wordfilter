package com.csg.wordfilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFilterUtil {

	public static String readFileToString(String filePath) throws IOException {
	    File file = new File(filePath);
	    if (!file.exists()) {
	      throw new FileNotFoundException("File not found: " + filePath);
	    }
	    
	    StringBuilder content = new StringBuilder();
	    String line;
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	      while ((line = reader.readLine()) != null) {
	        content.append(line).append("\n"); // Add newline after each line
	      }
	    }
	    return content.toString().trim(); // Remove trailing newline
	}

    public static List<String> getStringTokens(String content) {

        String sanitizedContent = sanitize(content);
        StringTokenizer st = new StringTokenizer(sanitizedContent);

        Set<String> tokens = new HashSet<>();

        while (st.hasMoreTokens()) {
        	tokens.add(st.nextToken());
        }

        List<String> stringList = new ArrayList<String>(tokens);
        Collections.sort(stringList);
        return stringList;
    }

    private static String sanitize(String text) {
        Pattern pattern = Pattern.compile("\\w+");  // Matches one or more word characters
       // Pattern pattern = Pattern.compile("\\w+(?:'\\w+)*");  // Matches words with optional apostrophes 
        Matcher matcher = pattern.matcher(text);
        StringBuilder sanitizedText = new StringBuilder();
        while (matcher.find()) {
          sanitizedText.append(matcher.group());
          sanitizedText.append(" ");
        }
        return sanitizedText.toString().trim();
      }
}



