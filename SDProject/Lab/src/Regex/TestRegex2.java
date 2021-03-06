package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex2 {

	public static void main(String[] args) {
		// String to be scanned to find the pattern.
	      String line = "coucou 77.130.4.239 hehehe";
	      String pattern = "([0-9]{1,3}\\.){3}[0-9]{1,3}";

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(line);
	      if (m.find( )) {
	         System.out.println("Found value: " + m.group(0) );
	      } else {
	         System.out.println("NO MATCH");
	      }
	}

}
