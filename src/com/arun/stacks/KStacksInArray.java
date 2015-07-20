package com.arun.stacks;

public class KStacksInArray {
	
	private int[] arr;
	private int[] next;
	private int[] top;
	private int free;
	
	public KStacksInArray(int k) {
		// TODO Auto-generated constructor stub
		
		arr = new int[10];
		next = new int[10];
		top = new int[k];
		free = 0;
		
		for (int i = 0; i < top.length; i++) {
			top[i] = -1;
		}
		
		for (int i = 0; i < next.length -1; i++) {
			next[i] = i + 1;
		}
		
		next[next.length] = -1;
	}
	
	
	void push(int stackIndex, int item) {
		int i = free;
		free = next[i];
		
		next[i] = top[stackIndex];
		top[stackIndex] = i;
		
		arr[i] = item;
	}
	
	int pop(int stackIndex) {
		
		int i = top[stackIndex];
		
		top[stackIndex] = next[i];
		next[i] = free;
		
		free = i;
		
		return arr[i];

	}
	
	
}
