package com.arun.arrays;

public class Utils {
	
	public static final void printMatrix(int[][] a) {
		int rows = a.length;
		int cols = a[0].length;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("");
		}
	}
}
