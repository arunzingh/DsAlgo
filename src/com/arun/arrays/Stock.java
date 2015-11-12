package com.arun.arrays;

import java.util.Stack;

public class Stock {
	
	int findMaxProfitOneTrans(int a[]) {
		
		int min = a[0];
		int maxDiff = 0;
		
		
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min)
				min = a[i];
			
			if (maxDiff < a[i] - min) 
				maxDiff = a[i] - min;
			
		}
		
		return maxDiff;
	}
	
	void findStockSpan(int a[]) {
		
		int[] span = new int[a.length];
		span[0] = 1;
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		
		for (int i = 1; i < a.length; i++) {
			
			while (!stack.isEmpty() && a[stack.peek()] <= a[i]) {
				int item = stack.pop();
				System.out.println("popping " + item);
			}
			
			if (stack.isEmpty())
				span[i] = i+1;
			else 
				span[i] = i - stack.peek();
			
			System.out.println("pushing " + i);
			stack.push(i);
				
		}
		
		for (int i = 0; i < span.length; i++) {
			System.out.print(span[i] + "  ");
		}
	}
	
	public static void main(String[] args) {
		int arr[] = { 10, 1, 5, 6, 3, 2};
		int price[] = {10, 4, 5, 90, 120, 80};
		Stock s = new Stock();
//		System.out.println("max stock = " + s.findMaxProfitOneTrans(arr));
		s.findStockSpan(price);
		
	}
}
