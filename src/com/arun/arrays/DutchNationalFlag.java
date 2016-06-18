package com.arun.arrays;

public class DutchNationalFlag {
	void order(int[] a) {
		int left = 0;
		int curr = 0;
		int right = a.length - 1;
		
		while (curr <= right) {
			if (a[curr] == 0) {
				swap(a, curr, left);
				left++;
				curr++;
			} else if (a[curr] == 2) {
				swap(a, curr, right);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
				right--;
			} else {
				curr++;
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
