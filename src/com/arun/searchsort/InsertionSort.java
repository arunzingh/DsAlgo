package com.arun.practise.searchsort;

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
	
	public static void main(String[] args) {
		int[] a = {64, 25, 12, 22, 11, 4, 68, 5};
		
		new InsertionSort().doInsertionSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	
}
