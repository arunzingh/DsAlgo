package com.arun.searchsort;

public class MergeSort {
	
	void doMergeSorting(int[] a) {
		
		int[] helper = new int[a.length];
		mergeSort(a, helper, 0, a.length - 1);
	}
	
	void mergeSort(int[] a, int[] helper, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(a, helper, low, mid);
			mergeSort(a, helper, mid+1, high);
			merge(a, helper, low, mid, high);
		}
	}
	
	void merge(int[] a, int[] helper, int low, int mid, int high) {
//		System.out.println("low =" + low + " high= " + high);
		for (int i = low; i <= high; i++) {
			helper[i] = a[i];
		}
		
		int leftHelper = low;
		int rightHelper = mid + 1;
		int current = low;
		
		while (leftHelper <= mid && rightHelper <= high) {
			if (helper[leftHelper] <= helper[rightHelper]) {
				a[current] = helper[leftHelper];
				leftHelper++;
			} else {
				a[current] = helper[rightHelper];
				rightHelper++;
			}
			current++;
		}
		
		int remaining = mid - leftHelper;
		for (int i = 0; i <= remaining; i++) {
			a[current++] = helper[leftHelper++];
		}
	}
	
	public static void main(String[] args) {
		int[] a = {64, 25, 12, 22, 11, 4, 68, 5};
		
		new MergeSort().doMergeSorting(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	
}
