package com.arun.arrays;

import java.util.Stack;

public class MaxHistogram {
	
	int findMaxHistogram(int[] a) {
		
		Stack<Integer> stack = new Stack<Integer>();
		int[] left = new int[a.length];
		int[] right = new int[a.length];
		
		int n = a.length;
		for (int i = 0; i < a.length; i++) {
			while(!stack.isEmpty() && a[stack.peek()] >= a[i]) {
				stack.pop();
			}
			
			left[i] = stack.isEmpty() ? 0 : stack.peek();
			stack.push(i);
		}
		
		stack.clear();
		
		for (int i = n-1; i >= 0; i--) {
			while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
				stack.pop();
			}
			right[i] = stack.isEmpty() ? n-1 : stack.peek();
			stack.push(i);
		}
		
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			int currArea = a[i] * (right[i] - left[i]);
			maxArea = Math.max(maxArea, currArea);
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		int input[] = {2,2,2,6,1,5,4,2,2,2,2};
		MaxHistogram mh = new MaxHistogram();
		System.out.println(mh.findMaxHistogram(input));
	}
}
