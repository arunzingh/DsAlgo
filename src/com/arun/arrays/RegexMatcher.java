package com.arun.arrays;

public class RegexMatcher {
	
	boolean isMatch(String r, String s) {
		
		// case 2(a)
		if (r.startsWith("^")) {
			System.out.println("case 2(a) ");

			return isMatchHere(r.substring(1), s);}
		
		
//		for (int i = 0; i < s.length(); i++) {
			if(isMatchHere(r, s.substring(0)))
				return true;
//		}
		
		return false;
	}
	
	boolean isMatchHere(String r, String s) {
		
//		System.out.println("r= " + r + " s = " + s);
		// case 1
		if (r.isEmpty()) {
			System.out.println("case 1");

			return true;
		}
		
		// case 2(b)
		if (r.equals("$")) {
			System.out.println("case 2 (b)");

			return s.isEmpty();
		}
		
		
		// case 4
		if (r.length() >= 2 && r.charAt(1) == '*') {
			System.out.println("case 4");

			for (int i = 0; i < s.length(); i++) {
				if (r.startsWith(".") || r.startsWith(String.valueOf(s.charAt(i)))){
					if (isMatchHere(r.substring(2), s.substring(i+1)))
						return true;
				}
			}
			
			return isMatchHere(r.substring(2), s);
		}
		
//		System.out.println("case 3 ");
		// case 3
		if (!s.isEmpty() && (r.startsWith(".") || r.startsWith(String.valueOf(s.charAt(0)))))
				return isMatchHere(r.substring(1), s.substring(1));
		
		return false;
		
	}
	
	
	public static void main(String[] args) {
		String r[] = {"abc*de", "abc*de", "abc*de"};
		String s[] = {"abccccccccccde", "abcde", "abcccd"};
		RegexMatcher matcher = new RegexMatcher();
		for (int i = 0; i < s.length; i++) {
			System.out.println("r = " + r[i] + " s= " + s[i] + " result: " + matcher.isMatch(r[i], s[i]));
		}
	}
}
