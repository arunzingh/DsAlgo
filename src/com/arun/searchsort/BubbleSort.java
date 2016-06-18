package com.arun.searchsort;

public class BubbleSort {
	
	void doBubbleSort(int[] a) {
		int n = a.length;
		for (int count = 0; count < n - 1; count++) {
			for (int i = 0; i < n - 1 - count; i++) {
				if (a[i] > a[i+1]) {
					swap(a, i, i+1);
				}
			}
		}
	}
	
	void swap (int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = {64, 25, 12, 22, 11};
		
		new BubbleSort().doBubbleSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
