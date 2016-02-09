package com.arun.arrays;

public class ArraySimple {
	
	
	
	 
	int searchInSortedArray(int[] a, int x, int left, int right) {
	
		int mid = (left + right) / 2;
		
		if (a[mid] == x) return mid;
		
		if (left > right) return -1;
		
		if (a[left] <  a[mid]) {
			// left sub array is sorted
			if (x >= a[left] && x <= a[mid]) {
				return searchInSortedArray(a, x, left, mid - 1);
			} else {
				return searchInSortedArray(a, x, mid + 1, right);
			}
		} else {
			// right array is sorted
			if (x >= a[mid] && x <= a[right]) {
				return searchInSortedArray(a, x, mid + 1, right);
			} else {
				return searchInSortedArray(a, x, left, mid - 1);
			}
		}
	}
	
	int findMaxSubArraySumInDp(int[] a) {
		int currSum = a[0];
		int maxSumSoFar = a[0];
		
		for (int i = 1; i < a.length; i++) {
			currSum = Math.max(a[i], currSum + a[i]);
			maxSumSoFar = Math.max(maxSumSoFar, currSum);
		}
		
		return maxSumSoFar;
	}
	
	/**
	 * Find the maximum-sum subarray of an array. OR
	 * Explain Kadane's Algorithm to solve the Maximum Sum Subarray OR
	 * Find Largest Sum Contiguous Subarray.
	 * @param a
	 * @return
	 */
	int findMaxSumContiguousSubArray(int[] a) {
		int currSum = 0;
		int maxSumSoFar = Integer.MIN_VALUE;
		int startIndex = 0;
		int endIndex = 0;
		int tempStartIndex = 0;
		for (int i = 0; i < a.length; i++) {
			currSum += a[i];
			
			if (currSum > maxSumSoFar) {
				maxSumSoFar = currSum;
				startIndex = tempStartIndex;
				endIndex = i;
			}
			
			// resetting surrSum when it goes negative because
			// 
			if (currSum < 0) {
				currSum = 0;
				tempStartIndex = i + 1;
			}   
		}
		
		System.out.println("start = " + startIndex + " end = " + endIndex);
		
		return maxSumSoFar;
	}
	
	/**
	 * Function which takes an array and emits the majority element (if it exists), 
	 * otherwise prints NONE as
	 * 
	 * A majority element in an array A[] of size n,
	 * is an element that appears more than n/2 times
	 * 
	 *  
	 * @return
	 */
	void findMajorityElement(int[] a) {
		
		int x = findMajorityCandidate(a);
		
		boolean result = isMajority(a, x);
		
		if (result)
			System.out.println("Majority element = " + x);
		else 
			System.out.println("No majority element");
	}

	private boolean isMajority(int[] a, int x) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) count++; 
		}
		
		if (count >= a.length / 2) return true;
		
		return false;
	}

	private int findMajorityCandidate(int[] a) {
		int index = 0;
		int count = 1;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] == a[index]) 
				count++;
			else 
				count--;
			
			if (count == 0) {
				index = i;
				count = 1;
			}
		}
		return a[index];
	}
	
	
	public static void main(String[] args) {
		ArraySimple asTest = new ArraySimple();
		int[] a = {1, 3, 3, 1, 2, 5, 3, 3};
		asTest.findMajorityElement(a);
		
		
		int[] b =  {-21, -33, -45, -15, -22, -17, -55, -37};
		
		System.out.println("Max contiguous sub array is " + asTest.findMaxSumContiguousSubArray(b));
		
		System.out.println("DP: Max contiguous sub array is " + asTest.findMaxSubArraySumInDp(b));
		
		int arr1[] = {2, 2, 2, 3, 4, 2};
		System.out.println("Index of 3 is " + asTest.searchInSortedArray(arr1, 3, 0, arr1.length - 1));
	}
}
