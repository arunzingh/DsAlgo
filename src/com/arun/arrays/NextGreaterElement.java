package com.arun.arrays;

import java.util.Stack;

public class NextGreaterElement {
	
	void printNextGreaterElement(int[] a) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(a[0]);
		
		for (int i = 1; i < a.length; i++) {
			int next = a[i];
			while (!stack.isEmpty() && stack.peek() < next) {
				int item = stack.pop();
				System.out.println(item + " --> " + next);
			}
			
			stack.push(next);
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + " --> " + -1);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {11, 13, 21, 3};
		NextGreaterElement nge = new NextGreaterElement();
		nge.printNextGreaterElement(a);
	}
}
