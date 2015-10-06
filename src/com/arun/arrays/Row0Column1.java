package com.arun.arrays;

public class Row0Column1 {
	
	int findKForRow0Column1(int[][] mat) {
		int res = -1;
		int N = mat.length;
		int i = 0, j = N-1;
		
		
		while (i < N && j > 0) {
			System.out.print("(" + i +", " + j + ") ");
			if (mat[i][j] == 0) {
				
				while (j >= 0 && (mat[i][j] == 0 || i == j))
					j--;
				System.out.print("(" + i +", " + j + ") ");
				if (j == -1) {
					res = i;
					break;
				}
				
				i++;
				
			} else {
				while (i < N && (mat[i][j] == 1 || i == j))
					i++;
				
				if (i == N) {
					res = j;
					break;
				}
				
				j--;
			}
		}
		
		
		if (res == -1) return res;
		
		for (int m = 0; m < mat.length; m++) {
			if (mat[m][res] != 1 && res != m)
				return -1;
		}
		
		for (int n = 0; n < mat.length; n++) {
			if (mat[res][n] != 0 && res != n)
				return -1;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[][] mat = {{0, 0, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}};
		
		Row0Column1 r = new Row0Column1();
		int ans = r.findKForRow0Column1(mat);
		
		System.out.println(ans);
	}
}
