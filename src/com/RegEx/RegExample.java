package com.RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*Subexpression	Matches
^	Matches beginning of line.
$	Matches end of line.
.	Matches any single character except newline. Using m option allows it to match newline as well.
[...]	Matches any single character in brackets.
[^...]	Matches any single character not in brackets
\A	Beginning of entire string
\z	End of entire string
\Z	End of entire string except allowable final line terminator.
re*	Matches 0 or more occurrences of preceding expression.
re+	Matches 1 or more of the previous thing
re?	Matches 0 or 1 occurrence of preceding expression.
re{ n}	Matches exactly n number of occurrences of preceding expression.
re{ n,}	Matches n or more occurrences of preceding expression.
re{ n, m}	Matches at least n and at most m occurrences of preceding expression.
a| b	Matches either a or b.
(re)	Groups regular expressions and remembers matched text.
(?: re)	Groups regular expressions without remembering matched text.
(?> re)	Matches independent pattern without backtracking.
\w	Matches word characters.
\W	Matches nonword characters.
\s	Matches whitespace. Equivalent to [\t\n\r\f].
\S	Matches nonwhitespace.
\d	Matches digits. Equivalent to [0-9].
\D	Matches nondigits.
\A	Matches beginning of string.
\Z	Matches end of string. If a newline exists, it matches just before newline.
\z	Matches end of string.
\G	Matches point where last match finished.
\n	Back-reference to capture group number "n"
\b	Matches word boundaries when outside brackets. Matches backspace (0x08) when inside brackets.
\B	Matches nonword boundaries.
\n, \t, etc.	Matches newlines, carriage returns, tabs, etc.
\Q	Escape (quote) all characters up to \E
\E	Ends quoting begun with \Q*/
public class RegExample {

	public static final String EXAMPLE_TEST = "This is my small example "
		      + "string which I'm going to " + "use for pattern matching.";
	
	public static void main(String[] args) {
		
		String test1 = " <title> .Did.</title>sad <title> this is title</title> "; 
		
		// Removes whitespace between a word character and . or ,
		String pattern = "(\\w)(\\s+)([\\.,])";
		String output = test1.replaceAll(pattern, "$1$3");
		System.out.println("output::" +output); 

		// Extract the text between the two title elements
		pattern = "(?i)(<title.*?>)(.+?)(</title>)";
		String updated = test1.replaceAll(pattern, "$2"); 
		System.out.println(updated);
		
		
		//-----------Negative Lookaheads are defined via (?!pattern). 
		//For example the following will match a if a is not followed by b.
		//Replace a with HELLO if it is not followed by b-------
		String test ="abcdefcasabd";
		pattern ="a(?!b)";
		System.out.println(test.replaceAll(pattern, "HELLO"));
		
		
		System.out.println("3::"+EXAMPLE_TEST.matches("\\w.*"));
	    String[] splitString = (EXAMPLE_TEST.split("\\s+"));
	    System.out.println(splitString.length);// Should be 14
	    for (String string : splitString) {
	      System.out.println(string);
	    }
	    // Replace all whitespace with tabs
	    System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));

	    
	    
	    
	    
	    Pattern pattern1 = Pattern.compile("\\w+");
	    // in case you would like to ignore case sensitivity,
	    // you could use this statement:
	    // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
	    Matcher matcher1 = pattern1.matcher(EXAMPLE_TEST);
	    // check all occurance
	    while (matcher1.find()) {
	      System.out.print("Start index: " + matcher1.start());
	      System.out.print(" End index: " + matcher1.end() + " ");
	      System.out.println(matcher1.group());
	    }
	    // now create a new pattern and matcher to replace whitespace with tabs
	    Pattern replace = Pattern.compile("\\s+");
	    Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
	    System.out.println(matcher2.replaceAll("\t"));
	    
	    Pattern wordBreakPattern = Pattern.compile("[\\s]");
	    String words[] = wordBreakPattern.split("Hello\nWord\t!");
	    for(String w:words){
	    	System.out.println(w);
	    }
	    
	}

}
