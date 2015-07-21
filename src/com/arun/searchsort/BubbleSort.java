package com.arun.practise.searchsort;

public class BubbleSort {
	
	void doBubbleSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (a[j] > a[j+1]) {
					swap(a, j, j+1);
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
