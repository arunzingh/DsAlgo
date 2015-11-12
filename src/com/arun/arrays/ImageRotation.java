package com.arun.arrays;

public class ImageRotation {
	
	void rotate(int[][] image, int n) {
		
		for (int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			
			for (int i = first; i < last; i++) {
				
				int offset = i - first;
				
				// save top
				int top = image[first][i];
				
				// left -> top
				image[first][i] = image[last - offset][first];
				
				// bottom -> left
				image[last - offset][first] = image[last][last - offset];
				
				// right -> bottom
				image[last][last - offset] = image[i][last];
				
				// top -> right
				image[i][last] = top;
			}
		}
	}
	
	int[][] rotate(int[][] image, int m, int n) {
		
		int[][] buffer = new int[n][m];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("i= " + j + " j= " + (m-i-1));
				buffer[j][m - 1 -i] = image[i][j]; 
			}
		}
		
		return buffer;
	}
	
	public static void main(String[] args) {
		int rows = 3;
		int cols = 3;
		int count = 1;
		int[][] a = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				a[i][j] = count++;
			}
		}
		
		
		Utils.printMatrix(a);
		new ImageRotation().rotate(a, a.length);
		System.out.println("After rotation:");
		Utils.printMatrix(a);
//		System.out.println("result");
//		Utils.printMatrix(new ImageRotation().rotate(a, 3, 4));
		
		
		
		
	}
}
