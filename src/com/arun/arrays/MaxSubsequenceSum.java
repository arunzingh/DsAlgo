package com.arun.arrays;

/**
 * Given an array of positive numbers, find the maximum sum of a subsequence 
 * with the constraint that no 2 numbers in the sequence should be adjacent in the array. 
 * 
 * 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
 * @author Arun
 *
 */
public class MaxSubsequenceSum {
	int findMaxSubsequenceSum(int[] a) {
		int incl = a[0];
		int excl = 0;
		
		for (int i = 1; i < a.length; i++) {
			int exclNew = Math.max(incl, excl);
			incl = excl + a[i];
			excl = exclNew;
		}
		
		return Math.max(incl, excl);
	}
	
	
	public static void main(String[] args) {
		int[] arr = {3, 2, 5, 10, 7};
		MaxSubsequenceSum mss = new MaxSubsequenceSum();
		System.out.println("Max Subsequence sum = " + mss.findMaxSubsequenceSum(arr));
	}
}
