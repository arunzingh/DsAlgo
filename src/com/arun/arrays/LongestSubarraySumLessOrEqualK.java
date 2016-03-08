package com.arun.arrays;

import java.util.Arrays;

public class LongestSubarraySumLessOrEqualK {
	
	public void findLongestSubarraySumLessOrEqualK(int[] a, int k) {
		
		// prefixSum[i] holds the sum of elements 
		// from 0 to i
		int[] prefixSum = new int[a.length];
		
		// minPrefixSum[i] holds the minimum prefixSum[k]
		// where k is from i to n-1
 		int[] minPrefixSum = new int[a.length];
		
		int n = a.length;
 		prefixSum[0] = a[0];
 		for (int i = 1; i < a.length; i++) {
 			prefixSum[i] = prefixSum[i-1] + a[i];
		}
		
 		minPrefixSum[n-1] = prefixSum[n-1];
 		for (int i = n-2; i >= 0; i--) {
 			minPrefixSum[i] = Math.min(prefixSum[i], prefixSum[i+1]);
		}
 		
// 		System.out.println("preSum=" + Arrays.toString(prefixSum));
// 		System.out.println("minSum=" + Arrays.toString(minPrefixSum));
 		
 		int startIndex = 0;
 		int endIndex = 0;
 		for (int i = 0; i < prefixSum.length; i++) {
 			int j = findCeil(minPrefixSum, k + prefixSum[i], 0, n-1);
 			if (j-i-1 > endIndex-startIndex) {
 				startIndex = i;
 				endIndex = j-1;
 			}
		}
 		
 		System.out.println("Longest subarray with sum less than or equal to " + k  
 				+ " is from " + startIndex + " to " + endIndex);
 		
	}
	
	public int findCeil(int[] a, int key, int low, int high) {
		int res = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] > key) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = {1, -2, 4, 5, -2, 6, 7};
		
		LongestSubarraySumLessOrEqualK l = new LongestSubarraySumLessOrEqualK();
		l.findLongestSubarraySumLessOrEqualK(a, 7);
	}
}
