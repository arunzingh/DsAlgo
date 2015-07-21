package com.arun.arrays;

public class DutchNationalFlag {
	void order(int[] a) {
		int left = 0;
		int mid = 0;
		int right = a.length - 1;
		
		while (mid <= right) {
			if (a[mid] == 0) {
				swap(a, mid, left);
				left++;
				mid++;
			} else if (a[mid] == 2) {
				swap(a, mid, right);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
				right--;
			} else {
				mid++;
			}
			
			
		}
		
	}
	
	void swap(int[] a, int n1, int n2) {
		int temp = a[n1];
		a[n1] = a[n2];
		a[n2] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = {0, 1, 1, 2, 2, 2, 1, 2, 0, 1, 1, 0, 2, 1, 0, 0, 0, 2};
		
		new DutchNationalFlag().order(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
