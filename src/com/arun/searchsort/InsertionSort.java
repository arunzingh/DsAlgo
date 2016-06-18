package com.arun.searchsort;

public class InsertionSort {
	
	void doInsertionSort(int[] a) {
		
		int key, j;
		
		for (int i = 1; i < a.length; i++) {
			key = a[i];
			j = i - 1;
			
			while (j >= 0 && a[j] > key) {
				a[j+1] = a[j];
				j--;
			}
			
			a[j+1] = key;
		}
		
	}
	
	void onInsertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int element = a[i];
			int j = i;
			
			while (j>0 && a[j-1] > element) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = element;
		}
	}
	
	void swap (int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = {64, 25, 12, 22, 11, 4, 68, 5};
		
//		new InsertionSort().doInsertionSort(a);
		
		new InsertionSort().onInsertionSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	
}
