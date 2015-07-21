package com.arun.arrays;

public class CompressString {
	String compress(String s) {
		
		char[] c = s.toCharArray();
		char curr = s.charAt(0);
		String s1 = "";
		int count = 1;
		for (int i = 1; i < c.length; i++) {
			if (c[i] == curr) {
				count++;
			} else {
				s1 += curr + String.valueOf(count); 
				curr = s.charAt(i);
				count = 1;
			}
		}
		
		s1 += curr + String.valueOf(count); 
		
		return s1;
	}
	
	String compress1(String s) {
		
		char[] c = s.toCharArray();
		int compressedSize = getCompressedSize(c);
		
		if (compressedSize > s.length()) {
			System.out.println("compressed string is of more length");
			return s;
		}
		
		char[] result = new char[compressedSize];
		char curr = s.charAt(0);
		int count = 1;
		int index = 0;
		for (int i = 1; i < c.length; i++) {
			if (c[i] == curr) {
				count++;
			} else {
				index = copyToResult(result, curr, count, index);
				curr = s.charAt(i);
				count = 1;
			}
		}
		
		copyToResult(result, curr, count, index);
		
		return new String(result);
	}
	
	private int copyToResult(char[] result, char curr, int count, int index) {
		result[index++] = curr;
		char[] num = String.valueOf(count).toCharArray();
		for (char n : num) {
			result[index++] = n;
		}
		
		return index;
	}

	private int getCompressedSize(char[] c) {
		char curr = c[0];
		int size = 0;
		int count = 1;
		for (int i = 1; i < c.length; i++) {
			if (curr == c[i]) {
				count++;
			} else {
				size += 1 + String.valueOf(count).length();
				curr = c[i];
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}

	public static void main(String[] args) {
		String str = "aabcccccaaa";

		System.out.println(new CompressString().compress1(str));
	}
}
