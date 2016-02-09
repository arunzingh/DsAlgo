package com.arun.searchsort;

public class MaxHeap {
	int[] harr;
	int size;
	
	public MaxHeap() {
	}
	
	public void insertKey(int key) {
		
		int index = size;
		size++;
		harr[index] = key;
		
		
	}
	
	private int parent(int i) {
		return (i-1) /2;
	}
	
	
	private int getLeft(int i) {
		return 2 * i + 1;
	}

	private int getRight(int i) {
		return 2 * i + 2;
	}

	public void maxHeapify(int i) {
		int largest = i;
		
		int left = getLeft(i);
		int right = getRight(i);
		
		
		if (left < size && harr[largest] < harr[left]) {
			largest = left;
		}
		
		if (right < size && harr[largest] < harr[right]) {
			largest = right;
		}
		
		
		if (largest != i) {
			swap(largest, i);
			maxHeapify(largest);
		}
		
	}

	public void swap(int a, int b) {
		int temp = harr[a];
		harr[a] = harr[b];
		harr[b] = temp;
	}
	
	
	
	
}
