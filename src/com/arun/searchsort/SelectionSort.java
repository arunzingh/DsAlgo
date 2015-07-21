package com.arun.searchsort;

public class SelectionSort {
	
	void doSelectionSort(int[] a) {
		
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min])
					min = j;
			}
			swap(a, i, min); 
		}
	}
	
	void swap (int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = {64, 25, 12, 22, 11};
		
		new SelectionSort().doSelectionSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
}
