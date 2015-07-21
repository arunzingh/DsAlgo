package com.arun.searchsort;

public class QuickSort {
	
	void doQuickSorting(int[] a, int left, int right) {
		
		if (left < right) {
			int p = partition(a, left, right);
			doQuickSorting(a, left, p-1);
			doQuickSorting(a, p+1, right);
		}
	}
	
	private int partition(int[] a, int left, int right) {
		
		int pivot = a[right];
		int i = left;
		
		for (int j=left; j<=right-1; j++) {
			if (a[j] <= pivot) {
				swap(a, i, j);
				i++;
			}
		}
		swap(a, i, right);
		
		return i;
	}


	void swap (int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = {64, 25, 12, 22, 11, 56, 246, 678, 23, 67, 83, 76};
		
		new QuickSort().doQuickSorting(a, 0, a.length-1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
