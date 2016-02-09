package com.arun.searchsort;

public class HeapSort {
	public void doSort(int[] arr) {
		
		
		MaxHeap maxHeap = buildMaxHeap(arr);
		
		while (maxHeap.size > 1) {
			maxHeap.swap(0, maxHeap.size-1);
			maxHeap.size--;
			
			maxHeap.maxHeapify(0);
		}
		
	}
	
	private MaxHeap buildMaxHeap(int[] arr) {
		
		MaxHeap h = new MaxHeap();
		
		h.size = arr.length;
		h.harr = arr;
		
		for (int i = (h.size-2)/2; i >= 0; i--) {
			h.maxHeapify(i);
		}
				
		return h;
	}

	public static void main(String[] args) {
		int[] a = {64, 25, 12, 22, 11, 4, 68, 5};
		
		new HeapSort().doSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
}

