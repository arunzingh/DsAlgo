package com.arun.searchsort;

public class BinarySearch {
	int doBinarySearch(int[] a, int left, int right, int num) {
		if (left <= right) {
			int mid = left + (right - left) /2;
			if (a[mid] == num) {
				return mid;
			} else if (a[mid] > num) {
				return doBinarySearch(a, left, mid - 1, num);
			} else {
				return doBinarySearch(a, mid + 1, right, num);
			}
		}
		
		return -1;
	}
	
	int doBinarySearchIterative(int[] a, int num) {
		int left = 0;
		int right = a.length - 1;
		while (left <= right) {
			int mid = left + (right - left) /2;
			if (a[mid] == num)
				return mid;
			
			if (a[mid] > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {2, 3, 4, 10, 40};
		
//		System.out.println(new BinarySearch().doBinarySearch(a, 0, a.length - 1, 10));
		System.out.println(new BinarySearch().doBinarySearch(a, 0, a.length - 1, 4));
	}
}
