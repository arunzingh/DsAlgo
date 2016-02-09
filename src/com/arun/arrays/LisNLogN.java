package com.arun.arrays;

public class LisNLogN {
	void findLisNLogN(int[] a) {
		int[] tailIndex = new int[a.length];
		int[] prevIndex = new int[a.length];
		
		// lis of length 1 has only element in a[] which is at index 0
		tailIndex[0] = 0;
		int len = 0;
		
		for (int i = 0; i < prevIndex.length; i++) {
			prevIndex[i] = -1;
		}
		
		for (int i = 1; i < a.length; i++) {
			
			if (a[i] < a[tailIndex[0]]) {
				tailIndex[0] = i;
			} else if(a[i] > a[tailIndex[len]]) {
				prevIndex[i] = tailIndex[len];
				len++;
				tailIndex[len] = i;
			} else {
				int pos = findCeilIndex(a, tailIndex, a[i], -1, len);
				
				prevIndex[i] = tailIndex[pos-1];
				tailIndex[pos] = i;
			}
			
//			System.out.println("prev = " + Arrays.toString(prevIndex) );
		}
		
		for (int i = tailIndex[len]; i >= 0 ; i = prevIndex[i]) {
			System.out.print(a[i] +  " ");
		}
		
	}
	

	public int findCeilIndex(int[] a, int[] tailIndex, int x, int left, int right) {
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
//			System.out.println("mid=" + mid);
			if (x <= a[tailIndex[mid]]) right = mid;
			else left = mid;
		}
//		System.out.println("left=" + left);
		return right;
	}


	public static void main(String[] args) {
		int a[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		int[] a1 = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};
		
		LisNLogN lis = new LisNLogN();
		lis.findLisNLogN(a);
		
		
		int[] tailIndex = {2, 5, 6, 4, 7};
//		System.out.println("ceil= " + lis.findCeilIndex(a1, tailIndex, 7, 0, 4));
	}
}
