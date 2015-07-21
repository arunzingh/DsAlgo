package com.arun.arrays;

public class MaximumDifference {
	
	int findMaxDifference(int[] a) {
		int maxDiff = a[1] - a[0];
		int minNum = a[0];
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] - minNum > maxDiff) {
				maxDiff = a[i] - minNum;
			}
			
			if (a[i] < minNum) {
				minNum = a[i];
			}
		}
		
		return maxDiff;
	}
	
	
	public static void main(String[] args) {
		int[] a = {7, 9, 5, 6, 3, 2 };
		
		System.out.println(new MaximumDifference().findMaxDifference(a));
	}
	
}
