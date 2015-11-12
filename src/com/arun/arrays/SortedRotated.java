package com.arun.arrays;

public class SortedRotated {
	
	int findPivotIndex(int[] arr, int left, int right) {
			
			if (left > right) return -1;
		
			if (left == right) 
				return left;
			
			int mid = (left + right) / 2;
			
			if (mid < right && arr[mid] > arr[mid+1])
				return mid;
			else if (mid > left && arr[mid] < arr[mid-1])
				return mid-1;
			else if (arr[left] >= arr[mid])
				return findPivotIndex(arr, left, mid-1);
			else 
				return findPivotIndex(arr, mid+1, right);
	}
	
	
	public static void main(String[] args) {
		int[] arr = { 2, 1 };
		int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int arr2[] = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1};
		SortedRotated sr = new SortedRotated();
		System.out.println("pivot index = "
				+ sr.findPivotIndex(arr, 0, arr.length - 1));
		System.out.println("pivot index = "
				+ sr.findPivotIndex(arr1, 0, arr1.length - 1));
		System.out.println("pivot index arr2 = "
				+ sr.findPivotIndex(arr2, 0, arr2.length - 1));
		
		int arr7[] =  {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2};
		
		System.out.println("pivot index arr7 = "
				+ sr.findPivotIndex(arr7, 0, arr7.length - 1));
		
		System.out.println("2 mod 0 = " + 2 % 0);

	}
}
