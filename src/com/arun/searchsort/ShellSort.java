package com.arun.practise.searchsort;

public class ShellSort {
	void doShellSorting(int[] a) {
		
		int h = 1;
		while (h < a.length/3) h = 3 * h + 1; 
		
		while (h>=1) {
			System.out.println("h=" + h);
			for (int i = h; i < a.length; i = i+h) {
				int j = i;
				
				while (j >= h && a[j-h] > a[j]) {
					System.out.println("swapping " + j + " with " + (j-h));
					int temp = a[j];
					a[j] = a[j-h];
					a[j-h] = temp;
					j -= h;
				}
			}
			
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			
			System.out.println("");
			
			h = h / 3;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {64, 25, 12, 22, 11, 4, 68, 5, 436, 36, 46, 54, 27, 37, 95, 85};
		
		new ShellSort().doShellSorting(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
