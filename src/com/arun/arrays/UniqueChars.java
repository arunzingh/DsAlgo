package com.arun.arrays;

public class UniqueChars {
	
	boolean hasUniqueChars(String s) {
		int checker = 0;
		char[] c = s.toCharArray();
		
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}		
		return true;
	}
	
	
	public static void main(String[] args) {
		String str = "arunsigh";
		System.out.println(new UniqueChars().hasUniqueChars(str));
	}
} 
