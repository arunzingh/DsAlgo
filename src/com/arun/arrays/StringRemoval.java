package com.arun.arrays;

/**
 * Remove “b” and “ac” from a given string
 * Given a string, eliminate all “b” and “ac” in the string, you have to replace them in-place, 
 * and you are only allowed to iterate over the string once.
 * 
 * @author arunsingh.v
 *
 */
public class StringRemoval {
	enum State {ONE, TWO};
	
	String remove(String s) {
		char[] c = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		State st = State.ONE;
		for (int i = 0; i < c.length; i++) {
			if (st == State.ONE && c[i] != 'b' && c[i] != 'a') {
					sb.append(c[i]);
			} else if (st == State.TWO && c[i] != 'c'){
					sb.append('a');
				
				if (c[i] != 'b' && c[i] != 'a') {
					sb.append(c[i]);
				}
			}
			
			st = c[i] == 'a' ? State.TWO : State.ONE;
			
			int len = sb.length();
			
			if (len >= 2 && sb.charAt(len-2) == 'a' && sb.charAt(len-1) == 'c'){
				sb.setLength(len-2);
			}
		}
		
		if (st == State.TWO) {
			sb.append('a');
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str = "sabc";
		System.out.println(new StringRemoval().remove(str));
	}

}
