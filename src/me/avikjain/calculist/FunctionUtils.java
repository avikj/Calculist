package me.avikjain.calculist;

import java.util.ArrayList;
import java.util.List;

public class FunctionUtils {
	public static void main(String[] args) {
		// System.out.println(fromString("x + 12.3 "));
	}

	/*public static Function fromString(String str) {
		char[] separators = { '+', '*', '/', '^', '(', ')' };
		str = str.replace(" ", "");
		List<String> tokens = tokenize(str, separators);
		return fromTokens(tokens);
	}

	private static Function fromTokens(List<String> tokens) {
		if (tokens.size() == 1) {
			if (tokens.get(0).equals("x"))
				return new Variable("x");
			else
				return new Constant(Double.parseDouble(tokens.get(0)));
		}

		return null;
	}

	private static ArrayList<Function> getTerms(List<String> tokens) {
		ArrayList<Integer> separatorInds = new ArrayList<Integer>();
		int depth = 0;
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i).equals("("))
				depth++;
			else if (tokens.get(i).equals(")"))
				depth--;
			else if (depth == 0 && ("+-".contains(tokens.get(i))))
				separatorInds.add(i);
		}
		List<List<String>> terms = new ArrayList<List<String>>();
		if(separatorInds.size() > 0 && separatorInds.get(0) != 0)
			terms.add(tokens.subList(0, separatorInds.get(0)));
		for(Integer separatorInd : separatorInds){
			t
		}
	}

	private static int getMatchingParenIndex(int openParenIndex,
			List<String> tokens) {
		int depth = 0;
		for (int i = openParenIndex; i < tokens.size(); i++) {
			switch (tokens.get(i)) {
			case "(":
				depth++;
				break;
			case ")":
				depth--;
				if (depth == 0)
					return i;
			}
		}

		return -1;
	}

	private static List<String> tokenize(String str, char[] separators) {
		List<String> tokens = new ArrayList<String>();
		String currentStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (contains(separators, str.charAt(i))) {
				tokens.add(currentStr);
				currentStr = "";
				tokens.add(str.charAt(i) + "");
				continue;
			}
			currentStr += str.charAt(i);
		}
		tokens.add(currentStr);

		while (tokens.contains(""))
			tokens.remove("");
		return tokens;
	}

	private static boolean contains(char[] arr, char c) {
		for (char s : arr)
			if (s == c)
				return true;
		return false;
	}

	private static String concatenateRange(List<String> list, int start, int end) {
		String result = "";
		for (int i = start; i < end; i++)
			result += list.get(i);
		return result;
	}
	*/
}
