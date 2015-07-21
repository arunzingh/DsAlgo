package com.arun.arrays;

public class StringReverse {
	String reverse(String s1) {
		int n = s1.length();
		char[] c = s1.toCharArray();
		for (int i = 0; i < n/2; i++) {
			char temp = c[n-1-i];
			c[n-1-i] = c[i];
			c[i] = temp;
			
		}
		
		return new String(c);
	}
	
	String reverseWords(String s) {
		char[] c = s.toCharArray();
		int start = 0;
		int end = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ' || c[i] == '.') {
				end =  i - 1;
				reverse(c, start, end);
				start = i + 1;
			} 
		}
		end = c.length - 1;
		reverse(c, start, end);
		
		System.out.println(new String(c));
		return reverse(new String(c));
	}
	
	void reverse(char[] c, int start, int end) {
		char temp;
		while (start <= end) {
			temp = c[end];
			c[end] = c[start];
			c[start] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		String str = "1234567890";
		StringReverse reverser = new StringReverse();
		System.out.println(reverser.reverse(str));
		
		String sentence =  "Arun likes this program very much.so does he";
		System.out.println(reverser.reverseWords(sentence));
	}
}
