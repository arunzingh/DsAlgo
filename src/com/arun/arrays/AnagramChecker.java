package com.arun.arrays;

import java.util.Arrays;

public class AnagramChecker {
	
	boolean check1(String s1, String s2) {
		
		if (s1.length() != s2.length())
			return false;
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		String s3 = new String(c1);
		String s4 = new String(c2);
		
		return s3.equals(s4);
	}
	
	boolean check2(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		int[] count = new int[256];
		
		for (int i = 0; i < c1.length; i++) {
			count[c1[i]]++;
			count[c2[i]]--;
		}
		for (int i = 0; i < c1.length; i++) {
			if (count[i] != 0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String str1 = "absdef";
		String str2 = "defsab";
		
		AnagramChecker checker = new AnagramChecker();
		System.out.println(checker.check1(str1, str2));
	}
}
