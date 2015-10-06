package com.arun.dp;

public class MinJumpsToEnd {
	
	int getMinJumsToEnd(int[] a) {
		int[] jumps = new int[a.length];
		
		for (int i = 0; i < jumps.length; i++) {
			jumps[i] = Integer.MAX_VALUE;
		}
		
		jumps[0] = 0;
		
		for (int i = 1; i < jumps.length; i++) {
			for (int j = 0; j < i; j++) {
				if (i <= a[j] + j && jumps[i] > jumps[j] + 1) {
					jumps[i] = jumps[j] + 1;
				}
			}
		}
		
		return jumps[jumps.length-1];
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		int[] arr2 = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int[] arr3 = {1, 3, 6, 1, 0, 9};
		MinJumpsToEnd j = new MinJumpsToEnd();
		System.out.println("Minimum jumps = " + j.getMinJumsToEnd(arr3));
	}
}
