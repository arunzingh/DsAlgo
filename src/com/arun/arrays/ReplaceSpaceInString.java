package com.arun.arrays;

public class ReplaceSpaceInString {
	
	String replace(String s1) {
		char[] c1 = s1.toCharArray();
		
		int spaceCount = 0;
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] == ' ') spaceCount++;
		}
		int newLength = c1.length + (spaceCount * 2);
		char[] c2 = new char[newLength];
		
		for(int i = c1.length - 1; i >= 0 ; i--) {
			if (c1[i] == ' ') {
				c2[newLength - 1] = '0';
				c2[newLength - 2] = '2';
				c2[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				c2[newLength - 1] = c1[i];
				newLength--;
			}
		}
		
		return new String(c2);
	}
	
	public static void main(String[] args) {
		String s1 = "ARUN SINGH";
		System.out.println(new ReplaceSpaceInString().replace(s1));
	}
	
}
