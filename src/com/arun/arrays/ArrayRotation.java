package com.arun.arrays;

public class ArrayRotation {
	
	void rotate(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			rotateByOne(a);
		}
	}
	
	void rotateByOne(int[] a) {
		int temp = a[a.length - 1];

		for (int i = a.length - 1; i > 0 ; i--) {
			a[i] = a[i-1];
		}
		a[0] = temp;

	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		
		new ArrayRotation().rotate(a, 2);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
