package com.arun.arrays;

public class MatrixSpiral {

	void printSpiral(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		// starting row index
		int k = 0;
		// starting column index
		int l = 0;
		
		while (k < m && l < n) {
			
			for (int i = l; i < n; i++) {
				System.out.print(a[k][i] + " ");
			}
			k++;
			
			for (int i = k; i < m; i++) {
				System.out.print(a[i][n - 1] + " ");
			}
			n--;
			
			for (int i = n - 1; i >= l; i--) {
				System.out.print(a[m - 1][i] + " ");
			}
			m--;
			
			for (int i = m - 1; i >= k ; i--) {
				System.out.print(a[i][l] + " ");
			}
			l++;

		}
	}

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4, 41}, { 5, 6, 7, 8, 81 }, { 9, 10, 11, 12, 121 },
				{ 13, 14, 15, 16, 161 } };

		new MatrixSpiral().printSpiral(a);
	}

}
