package com.arun.arrays;

public class PhoneBookCombinations {
	
	static final String[] codes = {" ", " ", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	
	void generateCombinations(int[] num) {
		
		StringBuffer sb = new StringBuffer();
		
		generateCombinations(num, 0, sb);
		
	}
	
	
	
	private void generateCombinations(int[] num, int i, StringBuffer sb) {
//		System.out.println("i= " + i + " " + num.length);
		
		if (i == num.length){
			System.out.println(sb.toString());
			return ;
		}
		
		String digitCode = codes[num[i]];
//		System.out.println("digitcode= " + digitCode);
		for (int j = 0; j < digitCode.length(); j++) {
			sb.append(digitCode.charAt(j));
			generateCombinations(num, i + 1, sb);
			sb = sb.delete(i, sb.length());
		}
		
	}



	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4};
		new PhoneBookCombinations().generateCombinations(num);
		
	}
}
